package com.example.demo.service.impl;

import com.example.demo.model.UserPrincipal;
import com.example.demo.model.Users;
import com.example.demo.repository.IUserRepository;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;

//    @Override
//    public Page<Users> findAll(Pageable pageable) {
//        return userRepository.findAll(pageable);
//    }

    @Override
    public List<Users> findAll() {
        return userRepository.findAll();
    }

    @Override
    public Optional<Users> findById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Users save(Users t) {
        return userRepository.save(t);
    }

    @Override
    public Page<Users> findAllByNameContaining(Pageable pageable, String name) {
        return userRepository.findAllByNameContaining(pageable,"%" + name + "%");
    }

    @Override
    public void removeById(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Users findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public boolean checkRegexPassword(String password) {
        String regex = "^(?=.*[A-Za-z])(?=.*\\\\d)[A-Za-z\\\\d]{6,}$";
        return Pattern.matches(regex, password);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Users user = userRepository.findByEmail(email);
        return UserPrincipal.build(user);
    }

}
