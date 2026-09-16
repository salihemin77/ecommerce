package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.service.CartService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {
    private CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }
    @GetMapping("/carts")
    public List<Cart> findAll() {
        return cartService.findAll();
    }
    @GetMapping("/carts/{cartsId}")
    public Cart findById(@PathVariable("cartsId") Integer cartsId) {
        return cartService.findById(cartsId);
    }
    @PostMapping("/carts")
    public Cart save(@RequestBody Cart cart) {
        return cartService.addCart(cart);
    }

    @DeleteMapping("/carts/{cartsId}")
    public void deleteById(@PathVariable("cartsId") Integer cartsId) {
        cartService.deleteById(cartsId);
    }



}
