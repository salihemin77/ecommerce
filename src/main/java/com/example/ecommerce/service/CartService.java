package com.example.ecommerce.service;

import com.example.ecommerce.entity.Cart;

import java.util.List;

public interface CartService {
    Cart addCart(Cart cart);
    void  deleteById(Integer id);
    List<Cart> findAll();
    Cart findById(Integer id);

}
