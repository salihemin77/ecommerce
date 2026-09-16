package com.example.ecommerce.service;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.entity.Product;
import com.example.ecommerce.entity.User;
import com.example.ecommerce.repository.OrderItemRepository;
import com.example.ecommerce.repository.OrderRepository;
import com.example.ecommerce.repository.ProductRepository;
import com.example.ecommerce.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public OrderServiceImpl(OrderRepository orderRepository, ProductRepository productRepository, UserRepository userRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Order save(Order order) {
        User user = userRepository.findById(order.getUserId()).orElseThrow();
        order.setUser(user);

        double totalPrice = 0;

        for (OrderItem orderItem : order.getOrderItems()) {

            Product product = productRepository
                    .findById(orderItem.getProductId())
                    .orElseThrow(() ->
                            new RuntimeException(
                                    "Product bulunamadı ID: "
                                            + orderItem.getProductId()
                            )
                    );

            // OrderItem -> Product bağlantısı
            orderItem.setProduct(product);

            // OrderItem -> Order bağlantısı
            orderItem.setOrder(order);

            // Toplam fiyat hesaplama
            totalPrice += product.getPrice()
                    * orderItem.getQuantity();
        }

        // Siparişin toplam fiyatını ayarla
        order.setTotalPrice(totalPrice);

        // Order + OrderItem'ları kaydet
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