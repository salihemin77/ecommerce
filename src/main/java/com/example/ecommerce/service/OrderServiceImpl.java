package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(
            OrderRepository orderRepository,
            ProductRepository productRepository,
            UserRepository userRepository) {

        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    @Override
    public Order save(Order order) {

        // 1. Sipariş boş mu?
        if (order.getOrderItems() == null ||
                order.getOrderItems().isEmpty()) {

            throw new RuntimeException("Order items cannot be empty");
        }

        // 2. User var mı?
        User user = userRepository
                .findById(order.getUserId())
                .orElseThrow(() ->
                        new RuntimeException(
                                "User not found ID: " + order.getUserId()
                        )
                );

        order.setUser(user);

        double totalPrice = 0;

        // 3. Sipariş ürünlerini kontrol et
        for (OrderItem orderItem : order.getOrderItems()) {

            // 3.1 Quantity kontrolü
            int quantity = orderItem.getQuantity();

            if (quantity <= 0) {
                throw new RuntimeException(
                        "Quantity must be greater than 0"
                );
            }

            // 3.2 Product var mı?
            Product product = productRepository
                    .findById(orderItem.getProductId())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Product not found ID: "
                                            + orderItem.getProductId()
                            )
                    );

            // 3.3 Stok yeterli mi?
            if (product.getStock() < quantity) {
                throw new RuntimeException(
                        "Product stock is low. Product ID: "
                                + product.getId()
                );
            }

            // 3.4 OrderItem -> Product
            orderItem.setProduct(product);

            // 3.5 OrderItem -> Order
            orderItem.setOrder(order);

            // 3.6 Stoktan düş
            product.setStock(
                    product.getStock() - quantity
            );

            productRepository.save(product);

            // 3.7 Toplam fiyat
            totalPrice += product.getPrice() * quantity;
        }

        // 4. Order'ın toplam fiyatı
        order.setTotalPrice(totalPrice);

        // 5. Order + OrderItem'ları kaydet
        return orderRepository.save(order);
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findById(int id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }
}