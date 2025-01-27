package com.ecom.productCatalog.controller;

import com.ecom.productCatalog.model.Product;
import com.ecom.productCatalog.repository.ProductRepository;
import com.ecom.productCatalog.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/category/{categoryId}")
    public List<Product> getAAProductsByCategory(@PathVariable Long categoryId){
        return productService.getProductByCategory(categoryId);
    }
}
