package com.example.demo.common;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IGeneral<E> {
//    Page<E> findAll(Pageable pageable);

    List<E> findAll();

    Optional<E> findById(Long id);

    E save(E t);
    Page<E> findAllByNameContaining(Pageable pageable, String name);

    void removeById(Long id);
}
