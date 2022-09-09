package com.example.demo.repository;

import com.example.demo.model.Cart;
import com.example.demo.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IItemRepository extends JpaRepository<Item, Long> {

    @Query(value = "select * from item where cart_id = (select  cart.users_id from cart where users_id = ?1)", nativeQuery = true)
    List<Item> findItemByUsersId(@Param("id") Long id);
    void deleteAllByCart(Cart cart);
}