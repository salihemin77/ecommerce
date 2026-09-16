package com.example.ecommerce.service;

import com.example.ecommerce.entity.Adress;
import com.example.ecommerce.repository.AdressRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdressServiceİmpl implements AdressService {
    private AdressRepository adressRepository;

    public AdressServiceİmpl(AdressRepository adressRepository) {
        this.adressRepository = adressRepository;
    }

    @Override
    public void deleteById(Integer id) {
        adressRepository.deleteById(id);


    }

    @Override
    public Adress findById(Integer id) {
        return adressRepository.findById(id).orElse(null);
    }

    @Override
    public Adress save(Adress adress) {
        return adressRepository.save(adress);
    }

    @Override
    public List<Adress> findAll() {
        return adressRepository.findAll();
    }

}
