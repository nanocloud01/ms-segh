package bo.gob.sigep.seg.accesos.infrastructure.persistence.repository;

import bo.gob.sigep.seg.accesos.infrastructure.persistence.dto.ProductSummaryDTO;
import bo.gob.sigep.seg.shared.dto.PageResponse;
import org.springframework.data.domain.Pageable;

public interface CustomProductRepository {

    PageResponse<ProductSummaryDTO> findProductSummaries(
            String  category,
            Double  minPrice,
            Double  maxPrice,
            Boolean active,
            Pageable pageable
    );
}