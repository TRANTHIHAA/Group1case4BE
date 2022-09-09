package com.example.demo.repository;

import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ICategoryRepository extends JpaRepository<Category,Long> {
    Page<Category> findAllByNameContaining(Pageable pageable, String name);


}
