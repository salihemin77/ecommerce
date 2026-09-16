package com.example.ecommerce.service;

import com.example.ecommerce.entity.Adress;

import java.util.List;

public interface AdressService {
    void deleteById(Integer id);
    Adress findById(Integer id);
    Adress save(Adress adress);
    List<Adress> findAll();

}
