package com.example.demo.repository;

import com.example.demo.model.Foods;
import com.example.demo.model.Orders;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders,Long> {
//    Page<Orders> findAllByNameContaining(Pageable pageable, String name);
}
