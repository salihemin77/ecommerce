package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderItem;

import java.util.List;

public interface OrderService {
    void deleteById(int id);
    Order findById(int id);
    List<Order> findAll();
    Order save(Order order);


}
