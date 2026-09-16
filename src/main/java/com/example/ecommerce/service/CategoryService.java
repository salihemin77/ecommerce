package com.example.ecommerce.service;

import com.example.ecommerce.entity.Category;

import java.util.List;

public interface CategoryService {
    Category save(Category category);
    List<Category> findAll();
    Category findById(Integer id);
    void deleteById(Integer id);




}
