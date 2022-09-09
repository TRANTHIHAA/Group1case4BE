package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.repository.ICategoryRepository;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;
//    @Override
//    public Page<Category> findAll(Pageable pageable) {
//        return categoryRepository.findAll(pageable);
//    }


    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category t) {
        return categoryRepository.save(t);
    }

    @Override
    public Page<Category> findAllByNameContaining(Pageable pageable, String name) {
        return categoryRepository.findAllByNameContaining(pageable,"%" + name + "%");
    }

    @Override
    public void removeById(Long id) {
            categoryRepository.deleteById(id);
    }
}
