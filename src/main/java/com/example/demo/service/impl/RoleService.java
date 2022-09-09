package com.example.demo.service.impl;

import com.example.demo.model.Roles;
import com.example.demo.repository.IRolesRepository;
import com.example.demo.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements IRoleService {
   @Autowired
   private IRolesRepository rolesRepository;

//    @Override
//    public Page<Roles> findAll(Pageable pageable) {
//        return rolesRepository.findAll(pageable);
//    }

    @Override
    public List<Roles> findAll() {
        return rolesRepository.findAll();
    }

    @Override
    public Optional<Roles> findById(Long id) {
        return rolesRepository.findById(id);
    }

    @Override
    public Roles save(Roles t) {
        return rolesRepository.save(t);
    }

    @Override
    public Page<Roles> findAllByNameContaining(Pageable pageable, String name) {
        return null;
//        return rolesRepository.findAllByNameContaining(pageable,"%" + name + "%");
    }

    @Override
    public void removeById(Long id) {
        rolesRepository.deleteById(id);
    }
}
