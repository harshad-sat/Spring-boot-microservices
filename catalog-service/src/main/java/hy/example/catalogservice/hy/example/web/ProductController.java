package hy.example.catalogservice.hy.example.web;

import hy.example.catalogservice.hy.example.domain.PagedResult;
import hy.example.catalogservice.hy.example.domain.Product;
import hy.example.catalogservice.hy.example.domain.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
}
