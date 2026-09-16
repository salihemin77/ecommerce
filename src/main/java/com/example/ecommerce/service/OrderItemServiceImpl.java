package com.example.ecommerce.service;



import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.repository.OrderItemRepository;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

    @Service
    public class OrderItemServiceImpl implements OrderItemService {

        private final OrderItemRepository orderItemRepository;

        public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
            this.orderItemRepository = orderItemRepository;
        }

        @Override
        public OrderItem save(OrderItem orderItem) {
            return orderItemRepository.save(orderItem);
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
        public void deleteById(int id) {
            orderItemRepository.deleteById(id);
        }
    }

