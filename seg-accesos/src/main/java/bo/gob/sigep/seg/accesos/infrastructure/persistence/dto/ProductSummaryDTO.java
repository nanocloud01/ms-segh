package bo.gob.sigep.seg.accesos.infrastructure.persistence.dto;

import java.util.Date;

public record ProductSummaryDTO(
        Long id,
        String name,
        String category,
        Double price,
        Long totalSold,
        Date lastSale
) {
//    public ProductSummaryDTO {
//        if (price != null && price < 0) {
//            throw new IllegalArgumentException("Price cannot be negative");
//        }
//    }
}