package com.example.ecommerce.controller;

import com.example.ecommerce.entity.Adress;
import com.example.ecommerce.service.AdressService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AdressController {
    private AdressService adressService;

    public AdressController(AdressService adressService) {
        this.adressService = adressService;
    }

    @GetMapping("/adress")
    public List<Adress> findAll() {
        return adressService.findAll();
    }
    @PostMapping("/adress")
    public Adress save(@RequestBody Adress adress) {
        return adressService.save(adress);
    }
    @DeleteMapping("/adress/{adressId}")
    public void deleteById(@PathVariable Integer adressId) {
        adressService.deleteById(adressId);
    }
    @GetMapping("/adress/{adressId}")
    public Adress findById(@PathVariable Integer adressId) {
        return adressService.findById(adressId);
    }




}
