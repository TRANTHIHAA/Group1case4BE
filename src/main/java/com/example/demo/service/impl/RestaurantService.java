package com.example.demo.service.impl;

import com.example.demo.model.Restaurants;
import com.example.demo.repository.IRestaurantRepository;
import com.example.demo.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService implements IRestaurantService {

    @Autowired
    private IRestaurantRepository restaurantRepository;
//    @Override
//    public Page<Restaurants> findAll(Pageable pageable) {
//        return restaurantRepository.findAll(pageable);
//    }

    @Override
    public List<Restaurants> findAll() {
        return restaurantRepository.findAll();
    }

    @Override
    public Optional<Restaurants> findById(Long id) {
        return restaurantRepository.findById(id);
    }

    @Override
    public Restaurants save(Restaurants t) {
        return restaurantRepository.save(t);
    }

    @Override
    public Page<Restaurants> findAllByNameContaining(Pageable pageable, String name) {
        return restaurantRepository.findAllByNameContaining(pageable,"%" + name + "%");
    }

    @Override
    public void removeById(Long id) {
        restaurantRepository.deleteById(id);

    }
}
