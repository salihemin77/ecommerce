package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.repository.OrderRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceİmpl implements OrderService  {
    private OrderRepository orderRepository;

    public OrderServiceİmpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);

    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll() ;
    }


    @Override
    public Order save(Order order)

    {
        double totalPrice=0;

        for (OrderItem orderItem : order.getOrderItems()) {
            double price = orderItem.getProduct().getPrice();
            int quantity = orderItem.getQuantity();

            totalPrice += price * quantity;
        }

        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }
}
