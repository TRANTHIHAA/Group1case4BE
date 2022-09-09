package com.example.demo.service;

import com.example.demo.common.IGeneral;
import com.example.demo.model.Cart;

import java.util.List;

public interface ICartService extends IGeneral<Cart> {
    public List<Cart> findAllByCustomerId(Long id);

}