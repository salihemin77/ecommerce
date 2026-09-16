package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Product;
import com.example.ecommerce.service.CategoryService;
import com.example.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProducts()
    {
        return productService.findAll();
    }
    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product)
    {
        return productService.save(product);
    }
    @DeleteMapping("/products/{productId}")
    public void deleteProduct(@PathVariable("productId") Integer productId)
    {
        productService.deleteById(productId);
    }
    @GetMapping("/products/{productId}")
    public Product getProductById(@PathVariable("productId") Integer productId)
    {
        return productService.findById(productId);
    }
    @GetMapping("/products/category/{categoryId}")
    public List<Product> getProductByCategoryId(
            @PathVariable("categoryId") Integer categoryId)
    {
        return productService.findByCategoryId(categoryId);
    }






}
