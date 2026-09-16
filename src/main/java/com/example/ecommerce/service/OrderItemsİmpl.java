package com.example.ecommerce.service;

import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.repository.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderItemsİmpl implements OrderItemService {
    private OrderItemRepository orderItemRepository;

    public OrderItemsİmpl(OrderItemRepository orderItemRepository) {
        this.orderItemRepository = orderItemRepository;
    }

    @Override
    public void deleteById(int id) {
        orderItemRepository.deleteById(id);

    }

    @Override
    public OrderItem findById(int id) {
        return orderItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<OrderItem> findAll() {
        return orderItemRepository.findAll();
    }

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
