package com.ecom.productCatalog.controller;

import com.ecom.productCatalog.model.Category;
import com.ecom.productCatalog.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> getCategories() {
        return categoryService.getCategories();
    }

    @PostMapping("/create")
    public Category createCategory(@RequestBody Category category) {
        return categoryService.createCategory(category);

    }


}
