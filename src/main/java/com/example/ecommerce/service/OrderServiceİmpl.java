package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceİmpl implements OrderService  {
    private OrderRepository orderRepository;
    private ProductRepository productRepository;
    private UserRepository userRepository;

    public OrderServiceİmpl(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
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
    public Order save(Order order) {

        if (order.getOrderItems() == null || order.getOrderItems().isEmpty()) {
            throw new RuntimeException("Order items cannot be empty");
        }
        int UserId=order.get



        double totalPrice = 0;

        for (OrderItem orderItem : order.getOrderItems()) {

            int quantity = orderItem.getQuantity();

            if (quantity <= 0) {
                throw new RuntimeException("Quantity must be greater than 0");
            }

            int productId = orderItem.getProduct().getId();

            Product product = productRepository.findById(productId).orElse(null);

            if (product == null) {
                throw new RuntimeException("Product not found");
            }

            if (product.getStock() < quantity) {
                throw new RuntimeException("Product stock is low");
            }

            double price = product.getPrice();

            product.setStock(product.getStock() - quantity);
            productRepository.save(product);

            totalPrice += price * quantity;
        }

        order.setTotalPrice(totalPrice);

        return orderRepository.save(order);
    }
}
