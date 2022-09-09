package com.example.demo.controller;

import com.example.demo.model.OrderDetail;
import com.example.demo.model.Orders;
import com.example.demo.service.IOrderDetailService;
import com.example.demo.service.IOrderService;
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
@RequestMapping("api/order")
public class OrderController {
    @Autowired
    private IOrderService iOrderService;

    @GetMapping
    private ResponseEntity<List<Orders>> display() {
        return new ResponseEntity<>(iOrderService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Orders> create(@RequestBody Orders orders) {
        return new ResponseEntity<>(iOrderService.save(orders), HttpStatus.CREATED);
    }
}