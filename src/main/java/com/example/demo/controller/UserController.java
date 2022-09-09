package com.example.demo.controller;

import com.example.demo.model.Users;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private IUserService iUserService;

    @GetMapping
    private ResponseEntity<List<Users>> display(){
        return new ResponseEntity<>(iUserService.findAll(), HttpStatus.OK);
    }@PostMapping
    private ResponseEntity<Users> create(@RequestBody Users user){
        return new ResponseEntity<>(iUserService.save(user), HttpStatus.CREATED);
    }
}
