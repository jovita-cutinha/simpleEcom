package com.ecom.productCatalog.service;

import com.ecom.productCatalog.model.Product;
import com.ecom.productCatalog.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public List<Product> getProductByCategory(Long categoryId) {
        return productRepository.findByCategoryId(categoryId);
    }

    public Product createProduct(Product product) {
        return productRepository.save(product);
    }
}
