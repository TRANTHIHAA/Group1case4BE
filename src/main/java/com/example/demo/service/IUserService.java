package com.example.demo.service;

import com.example.demo.common.IGeneral;
import com.example.demo.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface IUserService extends IGeneral<Users>, UserDetailsService {
    Users findByEmail(String email);

    boolean checkRegexPassword(String password);
}
