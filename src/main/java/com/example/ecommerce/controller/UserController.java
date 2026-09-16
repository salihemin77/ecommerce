package com.example.ecommerce.controller;

import com.example.ecommerce.entity.User;
import com.example.ecommerce.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

     @GetMapping("/users")
    public List<User> findAll() {
        return userService.findAll();
     }
     @GetMapping("/users/{usersId}")
    public User findById(@PathVariable Integer usersId) {
        return userService.findById(usersId);
     }
     @DeleteMapping("/users/{usersId}")
    public void deleteById(@PathVariable Integer usersId) {
        userService.deleteById(usersId);
     }
     @PostMapping("/users")
    public void save(@RequestBody User user) {
        userService.save(user);
     }


}
