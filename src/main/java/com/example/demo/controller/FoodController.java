package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.IFoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("api/food")
public class FoodController {
    @Autowired
    private IFoodService iFoodService;
    @Autowired
    private ICategoryService iCategoryService;
    @Value("C:\\Users\\User\\OneDrive\\Máy tính\\demo17-thangnhom1\\src\\main\\resources\\static\\image\\")
    private String fileUpload;

    @GetMapping
    private ResponseEntity<List<Foods>> display(){
        return new ResponseEntity<>(iFoodService.findAll(), HttpStatus.OK);
    }
//    @GetMapping
//    private ResponseEntity<Page<Foods>> display(@PageableDefault(value = 5) Pageable pageable){
//        return new ResponseEntity<>(iFoodService.findAll(pageable), HttpStatus.OK);
//    }

//    @PostMapping
//    public ResponseEntity<Product> createProduct(@RequestBody Product product, @RequestPart("file") MultipartFile image) throws IOException {
//        String fileName = image.getOriginalFilename();
//        FileCopyUtils.copy(image.getBytes(), new File("D:\\Clone Gif\\Clone Gif module4\\minitest30_08\\src\\main\\resources\\static\\image\\" + fileName));
//        return new ResponseEntity<>(iProductService.save(product), HttpStatus.CREATED);
//    }


    @GetMapping("/foodInUser")
    private ResponseEntity<Iterable<Foods>> findForMerchant(@RequestParam("id") Long id,@PageableDefault(value = 5) Pageable pageable) {
        return new ResponseEntity<>(iFoodService.findFoodsByUsersInThat(id, pageable), HttpStatus.OK);
    }


    @GetMapping("/foodNoUser")
    private ResponseEntity<Iterable<Foods>> findForUser(@RequestParam("id") Long id,@PageableDefault(value = 5) Pageable pageable) {
        return new ResponseEntity<>(iFoodService.findFoodsByUsersNotInThat(id, pageable), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    private ResponseEntity<Foods> findById(@PathVariable("id") Long id) {
        Optional<Foods> foods = iFoodService.findById(id);
        if (foods.isPresent()) {
            return new ResponseEntity<>(foods.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<Foods> delete(@PathVariable("id") Long id) {
        Optional<Foods> optionalFoods = iFoodService.findById(id);
        if (optionalFoods.isPresent()) {
            iFoodService.removeById(id);
            return new ResponseEntity<>(optionalFoods.get(), HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/searchByName")
    public ResponseEntity<List<Foods>> findAllByNameContainingNotUser(@RequestParam("id") Long id,
                                                                      @RequestParam("name") String name) {
        return new ResponseEntity<>(iFoodService.findAllByLikeNameNotUser( id,name), HttpStatus.OK);
    }

    @GetMapping("/search-category")
    public ResponseEntity<Iterable<Foods>> findFoodByCategoryContaining(@RequestParam("name") String name,@PageableDefault(value = 5) Pageable pageable) {
        return new ResponseEntity<>(iFoodService.findFoodByCategoryContaining(name, pageable), HttpStatus.OK);
    }

    @GetMapping("/searchByCategory")
    public ResponseEntity<Iterable<Foods>> findAllByCategory(@RequestParam("id") Long id,@PageableDefault(value = 5) Pageable pageable) {
        Optional<Category> category = iCategoryService.findById(id);
        return new ResponseEntity<>(iFoodService.findAllByCategory(category.get(), pageable), HttpStatus.OK);
    }


    @GetMapping("/searchByCategoryNotUser")
    public ResponseEntity<Page<Foods>> findAllByCategoryNotUser(@RequestParam("id") Long id,@RequestParam("idC") Long idC, Pageable pageable) {

        return new ResponseEntity<>(iFoodService.findAllByCategoryNotUser(id,idC, pageable), HttpStatus.OK);
    }


    @PostMapping
    private ResponseEntity<Foods> setFileUpload(@RequestPart("food") Foods foods
            , @RequestPart("file") MultipartFile image) throws IOException {
        foods.setImageUrl(image.getOriginalFilename());
        try {
            FileCopyUtils.copy(image.getBytes(), new File(fileUpload + image.getOriginalFilename()));
        } catch (IOException ex) {
            System.err.println("Error");
        }
        return new ResponseEntity<>(iFoodService.save(foods), HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    private ResponseEntity<Foods> update(@RequestPart("food") Foods foods
            , @RequestPart("file") MultipartFile image) throws IOException {
        foods.setImageUrl(image.getOriginalFilename());
        try {
            FileCopyUtils.copy(image.getBytes(), new File(fileUpload + image.getOriginalFilename()));
        } catch (IOException ex) {
            System.err.println("Error");
        }
        return new ResponseEntity<>(iFoodService.save(foods), HttpStatus.CREATED);
    }
}
