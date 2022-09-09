package com.example.demo.service;

import com.example.demo.common.IGeneral;
import com.example.demo.model.Cart;
import com.example.demo.model.Item;

import java.util.List;

public interface IItemService extends IGeneral<Item>{
    List<Item> findItemByCustomerId(Long id);
    void deleteAllByCart(Cart cart);
}