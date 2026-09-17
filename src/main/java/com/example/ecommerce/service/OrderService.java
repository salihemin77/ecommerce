package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;

import java.util.List;

public interface OrderService {

    void deleteById(int id);

    Order findById(int id);

    List<Order> findAll();

    Order save(Order order);
    Order update(Order order);

}