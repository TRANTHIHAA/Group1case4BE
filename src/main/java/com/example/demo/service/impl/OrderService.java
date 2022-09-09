package com.example.demo.service.impl;

import com.example.demo.model.Orders;
import com.example.demo.repository.IOrdersRepository;
import com.example.demo.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrdersRepository ordersRepository;

//    @Override
//    public Page<Orders> findAll(Pageable pageable) {
//        return ordersRepository.findAll(pageable);
//    }

    @Override
    public List<Orders> findAll() {
        return ordersRepository.findAll();
    }

    @Override
    public Optional<Orders> findById(Long id) {
        return ordersRepository.findById(id);
    }

    @Override
    public Orders save(Orders t) {
        return ordersRepository.save(t);
    }

    @Override
    public Page<Orders> findAllByNameContaining(Pageable pageable, String name) {
//        return ordersRepository.findAllByNameContaining(pageable,"%" + name + "%");
        return null;
    }

    @Override
    public void removeById(Long id) {
        ordersRepository.deleteById(id);
    }
}
