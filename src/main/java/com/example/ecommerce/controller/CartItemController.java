package com.example.ecommerce.controller;

import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.service.CartItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartItemController {
    private CartItemService cartItemService;

    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @GetMapping("/cart-items")
    public List<CartItem> findAll() {
        return cartItemService.findAll();
    }

    @GetMapping("/cart-items/{cartItemId}")
    public CartItem findById(@PathVariable("cartItemId") Integer cartItemId) {
        return cartItemService.findById(cartItemId);
    }

    @PostMapping("/cart-items")
    public CartItem save(@RequestBody CartItem cartItem) {
        return cartItemService.addCartItem(cartItem);
    }

    @DeleteMapping("/cart-items/{cartItemId}")
    public void deleteById(@PathVariable("cartItemId") Integer cartItemId) {
        cartItemService.deleteById(cartItemId);
    }
}
