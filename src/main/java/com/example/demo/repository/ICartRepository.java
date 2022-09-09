package com.example.demo.repository;

import com.example.demo.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ICartRepository extends JpaRepository<Cart,Long> {
    @Query(value = "select * from cart where users_id = ?1", nativeQuery = true)
    List<Cart> findCartByUsersId(@Param("id") Long id);
}