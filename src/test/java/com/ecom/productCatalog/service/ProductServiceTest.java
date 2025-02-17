package com.ecom.productCatalog.service;

import com.ecom.productCatalog.model.Category;
import com.ecom.productCatalog.model.Product;
import com.ecom.productCatalog.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

class ProductServiceTest {

      //which service I want to test
    @InjectMocks
    private ProductService productService;

    //declare the dependency
    @Mock
    private ProductRepository productRepository;

    @BeforeEach
    void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetProducts() {
        // Mock data
        Category category1 = new Category(1L, "Electronics");
        Product product1 = new Product(1L, "Laptop", "Dell XPS", "600*1200",1500.00, category1);
        Product product2 = new Product(2L, "Phone", "iPhone 13", "600*1200",999.00, category1);
        List<Product> mockProducts = Arrays.asList(product1, product2);

        // Mock repository call
        when(productRepository.findAll()).thenReturn(mockProducts);

        // Call the service method
        List<Product> products = productService.getProducts();

        // Verify and assert
        assertEquals(2, products.size());
        assertEquals("Laptop", products.get(0).getName());
        verify(productRepository, times(1)).findAll();
    }
    @Test
    void testGetProductByCategory() {
        // Mock data
        Category category1 = new Category(1L, "Electronics");
        Product product1 = new Product(1L, "Laptop", "Dell XPS", "600*1200",1500.00, category1);
        List<Product> mockProducts = Arrays.asList(product1);

        // Mock repository call
        when(productRepository.findByCategoryId(1L)).thenReturn(mockProducts);

        // Call the service method
        List<Product> products = productService.getProductByCategory(1L);

        // Verify and assert
        assertEquals(1, products.size());
        assertEquals("Laptop", products.get(0).getName());
        verify(productRepository, times(1)).findByCategoryId(1L);
    }

    @Test
    void testCreateProduct() {
        // Mock data
        Category category1 = new Category(1L, "Electronics");
        Product product1 = new Product(1L, "Laptop", "Dell XPS", "600*1200",1500.00, category1);

        // Mock repository call
        when(productRepository.save(product1)).thenReturn(product1);

        // Call the service method
        Product savedProduct = productService.createProduct(product1);

        // Verify and assert
        assertNotNull(savedProduct);
        assertEquals("Laptop", savedProduct.getName());
        verify(productRepository, times(1)).save(product1);
    }
}