package bo.gob.sigep.seg.accesos.infrastructure.persistence.controller;

import bo.gob.sigep.seg.accesos.infrastructure.persistence.dto.ProductSummaryDTO;
import bo.gob.sigep.seg.accesos.infrastructure.persistence.service.ProductService;
import bo.gob.sigep.seg.shared.dto.PageResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/summaries")
    public ResponseEntity<PageResponse<ProductSummaryDTO>> getSummaries(
            @RequestParam(required = false)                   String  category,
            @RequestParam(required = false)                   Double  minPrice,
            @RequestParam(required = false)                   Double  maxPrice,
            @RequestParam(required = false)                   Boolean active,
            @RequestParam(defaultValue = "0")                 int     page,
            @RequestParam(defaultValue = "10")                int     size,
            @RequestParam(defaultValue = "name")              String  sortBy,
            @RequestParam(defaultValue = "asc")               String  sortDir) {

        System.out.println("maxPrice: " + maxPrice);
        System.out.println("active: " + active);
        System.out.println("page: " + page);
        System.out.println("size: " + size);
        System.out.println("sortBy: " + sortBy);
        System.out.println("sortDir: " + sortDir);

        return ResponseEntity.ok(
                productService.getProductSummaries(
                        category, minPrice, maxPrice, active, page, size, sortBy, sortDir
                )
        );
    }

    @GetMapping("/test")
    public String getHello() {
        System.out.println("hello 0000000000000000000000000000000000000000000");
        return "Hello-16";
    }


}
