package com.example.ecommerce.service;

import com.example.ecommerce.entity.CartItem;

import java.util.List;

public interface CartItemService {
    CartItem addCartItem(CartItem cartItem);

    void deleteById(Integer id);

     List<CartItem> findAll();

    CartItem findById(Integer id);
}
