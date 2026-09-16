package com.example.ecommerce.controller;

import com.example.ecommerce.entity.OrderItem;
import com.example.ecommerce.service.OrderItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderItemController {
    private OrderItemService orderItemService;

    public OrderItemController(OrderItemService orderItemService) {
        this.orderItemService = orderItemService;
    }

    @GetMapping("/order-items")
    public List<OrderItem> getOrderItems() {
        return orderItemService.findAll();
    }
    @GetMapping("/order-items/{id}")
    public OrderItem getOrderItem(@PathVariable int id) {
        return orderItemService.findById(id);
    }
    @PostMapping("/order-items")
    public OrderItem createOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.save(orderItem);
    }
    @DeleteMapping("/order-items/{id}")
    public void deleteOrderItem(@PathVariable int id) {
        orderItemService.deleteById(id);
    }


}
