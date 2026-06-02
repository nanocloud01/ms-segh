package bo.gob.sigep.seg.accesos.infrastructure.persistence.repository.impl;

import bo.gob.sigep.seg.accesos.infrastructure.persistence.dto.ProductSummaryDTO;
import bo.gob.sigep.seg.accesos.infrastructure.persistence.repository.CustomProductRepository;
import bo.gob.sigep.seg.shared.dto.PageResponse;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CustomProductRepositoryImpl implements CustomProductRepository {

    public CustomProductRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    // Whitelist de columnas para evitar SQL Injection en el ORDER BY
    private static final Map<String, String> SORTABLE_COLUMNS = Map.of(
            "name",      "p.name",
            "price",     "p.price",
            "category",  "p.category",
            "totalSold", "total_sold",
            "lastSale",  "last_sale"
    );

    @PersistenceContext
    private final EntityManager entityManager;

    @Override
    public PageResponse<ProductSummaryDTO> findProductSummaries(
            String  category,
            Double  minPrice,
            Double  maxPrice,
            Boolean active,
            Pageable pageable) {

        // 1. Construir el WHERE dinámicamente
        String whereClause = buildWhereClause(category, minPrice, maxPrice, active);
        System.out.println("whereClause: " + whereClause);

        // 2. Query principal con JOIN a sales
        String sql = """
            SELECT
                p.id,
                p.name,
                p.category,
                p.price,
                COALESCE(SUM(s.quantity), 0) AS total_sold,
                MAX(s.sale_date)             AS last_sale
            FROM products p
            LEFT JOIN sales s ON s.product_id = p.id
            """ + whereClause + """
            GROUP BY p.id, p.name, p.category, p.price
            """ + buildOrderBy(pageable);

        System.out.println("---------------------------------------------------");
        System.out.println(sql);
        System.out.println("---------------------------------------------------");

        // 3. Query de conteo (sobre los grupos, no filas)
        String countSql = """
            SELECT COUNT(*) FROM (
                SELECT p.id
                FROM products p
                LEFT JOIN sales s ON s.product_id = p.id
                """ + whereClause + """
                GROUP BY p.id
            ) AS total
            """;

        // 4. Crear y configurar la query principal
        Query query = entityManager.createNativeQuery(sql, "ProductSummaryDTOMapping");
        setParameters(query, category, minPrice, maxPrice, active);
        query.setFirstResult((int) pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        // 5. Crear y configurar la query de conteo
        Query countQuery = entityManager.createNativeQuery(countSql);
        setParameters(countQuery, category, minPrice, maxPrice, active);

        // 6. Ejecutar y retornar el Page
        List<ProductSummaryDTO> content = query.getResultList();
        long total = ((Number) countQuery.getSingleResult()).longValue();

        // 7. Retornamos datos paginados
        PageImpl<ProductSummaryDTO> pageImpl = new PageImpl<>(content, pageable, total);
        return PageResponse.of(pageImpl);
    }

    // --- Métodos privados de apoyo ---

    private String buildWhereClause(String category, Double minPrice, Double maxPrice, Boolean active) {
        List<String> conditions = new ArrayList<>();

        if (category != null && !category.isBlank()) {
            conditions.add("p.category = :category");
        }
        if (minPrice != null) {
            conditions.add("p.price >= :minPrice");
        }
        if (maxPrice != null) {
            conditions.add("p.price <= :maxPrice");
        }
        if (active != null) {
            conditions.add("p.active = :active");
        }

        return conditions.isEmpty()
                ? ""
                : "WHERE " + String.join(" AND ", conditions) + " ";
    }

    private void setParameters(Query query, String category, Double minPrice, Double maxPrice, Boolean active) {
        if (category != null && !category.isBlank()) query.setParameter("category", category);
        if (minPrice  != null)                       query.setParameter("minPrice",  minPrice);
        if (maxPrice  != null)                       query.setParameter("maxPrice",  maxPrice);
        if (active    != null)                       query.setParameter("active",    active);
    }

    private String buildOrderBy(Pageable pageable) {

        System.out.println("entrance to buildOrderBy");

        if (!pageable.getSort().isSorted()) {
            return "ORDER BY p.id ASC";
        }

        String orderBy = pageable.getSort().stream()
                .filter(order -> SORTABLE_COLUMNS.containsKey(order.getProperty()))
                .map(order -> SORTABLE_COLUMNS.get(order.getProperty())
                        + (order.isAscending() ? " ASC" : " DESC"))
                .collect(Collectors.joining(", "));

        return orderBy.isEmpty() ? "ORDER BY p.id ASC" : "ORDER BY " + orderBy;
    }
}