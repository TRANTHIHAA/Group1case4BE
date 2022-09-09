package com.example.demo.controller;

import com.example.demo.model.Restaurants;
import com.example.demo.service.IRestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/restaurants")
public class RestaurantsController {
    @Autowired
    private IRestaurantService iRestaurantService;

    @GetMapping
    private ResponseEntity<List<Restaurants>> display() {
        return new ResponseEntity<>(iRestaurantService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Restaurants> create(@RequestBody Restaurants restaurants) {
        return new ResponseEntity<>(iRestaurantService.save(restaurants), HttpStatus.CREATED);
    }
}
