package com.example.ecommerce.service;

import com.example.ecommerce.entity.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderItemService  {
    void deleteById(int id);
    OrderItem findById(int id);
    List<OrderItem> findAll();
    OrderItem save(OrderItem orderItem);

}
