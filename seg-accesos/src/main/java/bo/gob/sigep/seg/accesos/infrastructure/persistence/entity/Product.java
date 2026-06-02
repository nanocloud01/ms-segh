package bo.gob.sigep.seg.accesos.infrastructure.persistence.entity;

import bo.gob.sigep.seg.accesos.infrastructure.persistence.dto.ProductSummaryDTO;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "products")
@SqlResultSetMapping(
        name = "ProductSummaryDTOMapping",
        classes = @ConstructorResult(
                targetClass = ProductSummaryDTO.class,
                columns = {
                        @ColumnResult(name = "id",           type = Long.class),
                        @ColumnResult(name = "name",         type = String.class),
                        @ColumnResult(name = "category",     type = String.class),
                        @ColumnResult(name = "price",        type = Double.class),
                        @ColumnResult(name = "total_sold",   type = Long.class),
                        @ColumnResult(name = "last_sale",    type = Date.class)
                }
        )
)

public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private Double price;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}