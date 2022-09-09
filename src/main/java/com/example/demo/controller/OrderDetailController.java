package com.example.demo.controller;

import com.example.demo.model.OrderDetail;
import com.example.demo.model.Restaurants;
import com.example.demo.model.Roles;
import com.example.demo.service.IOrderDetailService;
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
@RequestMapping("api/orderdetail")
public class OrderDetailController {
    @Autowired
    private IOrderDetailService iOrderDetailService;

    @GetMapping
    private ResponseEntity<List<OrderDetail>> display() {
        return new ResponseEntity<>(iOrderDetailService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<OrderDetail> create(@RequestBody OrderDetail orderDetail) {
        return new ResponseEntity<>(iOrderDetailService.save(orderDetail), HttpStatus.CREATED);
    }
}