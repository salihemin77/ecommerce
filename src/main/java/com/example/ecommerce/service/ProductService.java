package com.example.ecommerce.service;

import com.example.ecommerce.entity.Product;

import java.util.List;

public interface ProductService {
    Product save(Product product);
    List<Product> findAll();
    Product findById(Integer id);
  void deleteById(Integer id);
  List<Product> findByCategoryId(Integer categoryId);



}
