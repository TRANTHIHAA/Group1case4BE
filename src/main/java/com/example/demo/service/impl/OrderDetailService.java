package com.example.demo.service.impl;

import com.example.demo.model.OrderDetail;
import com.example.demo.repository.IOrderDetailRepository;
import com.example.demo.service.IOrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderDetailService implements IOrderDetailService {
    @Autowired
    private IOrderDetailRepository orderDetailRepository;

//    @Override
//    public Page<OrderDetail> findAll(Pageable pageable) {
//        return orderDetailRepository.findAll(pageable);
//    }

    @Override
    public List<OrderDetail> findAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public Optional<OrderDetail> findById(Long id) {
        return orderDetailRepository.findById(id);
    }

    @Override
    public OrderDetail save(OrderDetail t) {
        return orderDetailRepository.save(t);
    }

    @Override
    public Page<OrderDetail> findAllByNameContaining(Pageable pageable, String name) {
//        return orderDetailRepository.findAllByNameContaining(pageable,"%" + name + "%");
        return null;
    }

    @Override
    public void removeById(Long id) {
        orderDetailRepository.deleteById(id);

    }
}
