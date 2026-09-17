package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Order;
import com.example.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {
    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/orders")
    public List<Order> findAll() {
       return orderService.findAll();
    }

    @GetMapping("/orders/{id}")
    public Order findById(@PathVariable int id) {
        return orderService.findById(id);
    }
    @PostMapping("/orders")
    public Order save(@RequestBody Order order) {
        return orderService.save(order);
    }
    @PutMapping("/orders/{id}")
    public Order update(@PathVariable int id, @RequestBody Order order) {
       order.setId(id);
       return orderService.update(order);

    }
    @DeleteMapping("/orders/{id}")
    public void deleteById(@PathVariable int id) {
        orderService.deleteById(id);
    }



}
