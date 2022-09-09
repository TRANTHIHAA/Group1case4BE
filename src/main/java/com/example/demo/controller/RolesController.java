package com.example.demo.controller;

import com.example.demo.model.Restaurants;
import com.example.demo.model.Roles;
import com.example.demo.service.IRestaurantService;
import com.example.demo.service.IRoleService;
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
@RequestMapping("api/roles")
public class RolesController {
    @Autowired
    private IRoleService iRoleService;

    @GetMapping
    private ResponseEntity<List<Roles>> display() {
        return new ResponseEntity<>(iRoleService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    private ResponseEntity<Roles> create(@RequestBody Roles roles) {
        return new ResponseEntity<>(iRoleService.save(roles), HttpStatus.CREATED);
    }

}
