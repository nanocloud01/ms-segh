package bo.gob.sigep.seg.accesos.infrastructure.persistence.service;

import bo.gob.sigep.seg.accesos.infrastructure.persistence.dto.ProductSummaryDTO;
import bo.gob.sigep.seg.accesos.infrastructure.persistence.repository.ProductRepository;
import bo.gob.sigep.seg.shared.dto.PageResponse;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public PageResponse<ProductSummaryDTO> getProductSummaries(
            String  category,
            Double  minPrice,
            Double  maxPrice,
            Boolean active,
            int     page,
            int     size,
            String  sortBy,
            String  sortDir) {

        Sort sort = Sort.by(
                sortDir.equalsIgnoreCase("desc") ? Sort.Direction.DESC : Sort.Direction.ASC,
                sortBy
        );

        Pageable pageable = PageRequest.of(page, size, sort);

        return productRepository.findProductSummaries(
                category, minPrice, maxPrice, active, pageable
        );
    }
}