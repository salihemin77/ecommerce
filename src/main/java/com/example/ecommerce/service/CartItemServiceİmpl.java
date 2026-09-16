package com.example.ecommerce.service;

import com.example.ecommerce.entity.CartItem;
import com.example.ecommerce.repository.CartItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CartItemServiceİmpl implements CartItemService {
    private CartItemRepository cartItemRepository;

    public CartItemServiceİmpl(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    @Override
    public CartItem addCartItem(CartItem cartItem) {
        if (cartItem.getQuantity() > cartItem.getProduct().getStock()) {
            throw new RuntimeException("Yetersiz stok!");
        }

        return cartItemRepository.save(cartItem);
    }

    @Override
    public void deleteById(Integer id) {
        cartItemRepository.deleteById(id);

    }

    @Override
    public List<CartItem> findAll() {
        return (List<CartItem>) cartItemRepository.findAll();
    }

    @Override
    public CartItem findById(Integer id) {
        return cartItemRepository.findById(id).get();
    }
}
