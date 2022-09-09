package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("api/categories")
public class CategoryController {
    @Autowired
    private ICategoryService iCategoryService;
    @GetMapping
    private ResponseEntity<List<Category>> display(){
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }
    //    @GetMapping
//    private ResponseEntity<Page<Category>> display(@PageableDefault(value = 5) Pageable pageable){
//        return new ResponseEntity<>(iCategoryService.findAll(pageable), HttpStatus.OK);
//    }
    @PostMapping
    private ResponseEntity<Category> createCatelogy(@RequestBody Category category){
        return new ResponseEntity<>(iCategoryService.save(category), HttpStatus.CREATED);
    }
}
