package com.ecom.productCatalog.service;

import com.ecom.productCatalog.model.Category;
import com.ecom.productCatalog.repository.CategoryRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceTest {

    @InjectMocks
    private CategoryService categoryService;

    @Mock
    private CategoryRepository categoryRepository;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetCategories() {
        // Mock data
        Category category1 = new Category(1L, "Electronics");

        Category category2 = new Category(2L,"Fashion");


        List<Category> mockCategories = Arrays.asList(category1, category2);

        // Mock repository call
        when(categoryRepository.findAll()).thenReturn(mockCategories);

        // Call the service method
        List<Category> categories = categoryService.getCategories();

        // Verify and assert
        assertEquals(2, categories.size());
        assertEquals("Electronics", categories.get(0).getName());
        verify(categoryRepository, times(1)).findAll();
    }

    @Test
    void testCreateCategory() {
        // Mock data
        Category category = new Category(1L, "Sports");

        // Mock repository call
        when(categoryRepository.save(category)).thenReturn(category);

        // Call the service method
        Category savedCategory = categoryService.createCategory(category);

        // Verify and assert
        assertNotNull(savedCategory);
        assertEquals("Sports", savedCategory.getName());
        verify(categoryRepository, times(1)).save(category);
    }
}
