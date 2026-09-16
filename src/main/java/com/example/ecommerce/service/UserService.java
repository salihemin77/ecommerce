package com.example.ecommerce.service;

import com.example.ecommerce.entity.User;

import java.util.List;

public interface UserService {
    User save(User user);
    void deleteById(Integer id);
    List<User> findAll();
    User findById(Integer id);
}
