package com.example.ecommerce.service;

import com.example.ecommerce.entity.Cart;
import com.example.ecommerce.repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceİmpl implements CartService {
    private CartRepository cartRepository;

    public CartServiceİmpl(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }


    @Override
    public Cart addCart(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public void deleteById(Integer id) {
cartRepository.deleteById(id);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Cart findById(Integer id) {
        return cartRepository.findById(id).get();
    }

}
