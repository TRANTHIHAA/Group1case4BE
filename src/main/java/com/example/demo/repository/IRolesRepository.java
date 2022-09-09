package com.example.demo.repository;

import com.example.demo.model.Foods;
import com.example.demo.model.Roles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRolesRepository extends JpaRepository<Roles,Long> {
//    Page<Roles> findAllByNameContaining(Pageable pageable, String name);
}
