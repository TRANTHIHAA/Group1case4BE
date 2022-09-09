package com.example.demo.service.impl;

import com.example.demo.model.Cart;
import com.example.demo.repository.ICartRepository;
import com.example.demo.service.ICartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartService implements ICartService {
    @Autowired
    ICartRepository cartRepository;

    @Override
    public List<Cart> findAllByCustomerId(Long id) {
        return cartRepository.findCartByUsersId(id);
    }

    @Override
    public List<Cart> findAll() {
        return cartRepository.findAll();
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return cartRepository.findById(id);
    }

    @Override
    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    @Override
    public Page<Cart> findAllByNameContaining(Pageable pageable, String name) {
        return null;
    }

    @Override
    public void removeById(Long id) {

    }


}