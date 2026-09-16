package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Category;
import com.example.ecommerce.service.CategoryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }
    @GetMapping("/categories")
    public List<Category> getCategories() {
        return categoryService.findAll();

    }
    @PostMapping("/" +
            "categories")
    public Category addCategory(@RequestBody Category category) {
    return categoryService.save(category);
    }
    @DeleteMapping("/categories/{categoriesId}")
    public void deleteCategory(@PathVariable("categoriesId") int categoriesId) {
        categoryService.deleteById(categoriesId);
    }
    @GetMapping("/categories/{categoriesId}")
    public Category getCategory(@PathVariable("categoriesId") int categoriesId) {
        return categoryService.findById(categoriesId);
    }




}
