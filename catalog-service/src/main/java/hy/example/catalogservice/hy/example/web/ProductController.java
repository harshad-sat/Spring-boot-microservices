package hy.example.catalogservice.hy.example.web;

import hy.example.catalogservice.hy.example.domain.PagedResult;
import hy.example.catalogservice.hy.example.domain.Product;
import hy.example.catalogservice.hy.example.domain.ProductNotFoundException;
import hy.example.catalogservice.hy.example.domain.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/products")
class ProductController {

    private final ProductService productService;

    ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    PagedResult<Product> getProducts(@RequestParam(name = "page", defaultValue = "1") int pageno) {
        return productService.getProducts(pageno);
    }

    @GetMapping("/{code}")
    ResponseEntity<Product> getProductByCode(@PathVariable String code) {
        // log.info("Fetching product for code: {}", code);
        return productService
                .getProductByCode(code)
                .map(ResponseEntity::ok)
                .orElseThrow(() -> ProductNotFoundException.forCode(code));
    }
}
