package com.example.demo.controller;

import com.example.demo.model.Category;
import com.example.demo.model.Foods;
import com.example.demo.model.JwtResponse;
import com.example.demo.model.Users;
import com.example.demo.service.ICategoryService;
import com.example.demo.service.IFoodService;
import com.example.demo.service.IUserService;
import com.example.demo.service.JwtService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/permitAll")
public class RegisterController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private ICategoryService iCategoryService;

    @Autowired
    private IFoodService iFoodService;

    @Value("C:\\Users\\User\\OneDrive\\Máy tính\\demo17-thangnhom1\\src\\main\\resources\\static\\image\\")
    private String fileUpload;

    @GetMapping
    private ResponseEntity<List<Foods>> displayFood(){

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


    @GetMapping("/{id}")
    private ResponseEntity<Foods> findById(@PathVariable("id") Long id) {
        Optional<Foods> foods = iFoodService.findById(id);
        if (foods.isPresent()) {
            return new ResponseEntity<>(foods.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping("/categories")
    private ResponseEntity<List<Category>> display(){
        return new ResponseEntity<>(iCategoryService.findAll(), HttpStatus.OK);
    }
    @Autowired
    private IUserService iUserService;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody Users user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return new ResponseEntity<>(iUserService.save(user),HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Users user) {
        //Kiểm tra username và pass có đúng hay không
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));

        //Lưu user đang đăng nhập vào trong context của security
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtService.generateTokenLogin(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        Users currentUser = iUserService.findByEmail(user.getEmail());
        return ResponseEntity.ok(new JwtResponse(jwt, currentUser.getId(), userDetails.getUsername(), userDetails.getAuthorities()));
    }
    @GetMapping("/searchByName")
    public ResponseEntity<Iterable<Foods>> findAllByNameContaining(@RequestParam("name") String name, Pageable pageable) {
        return new ResponseEntity<>(iFoodService.findAllByLikeName( name,pageable), HttpStatus.OK);
    }
//    @GetMapping("/search-by-name")
//    public ResponseEntity<Iterable<Foods>> findAllByNameContaining(@RequestParam("name") String name,@PageableDefault(value = 5) Pageable pageable) {
//        return new ResponseEntity<>(iFoodService.findAllByNameContaining(pageable, name), HttpStatus.OK);
//    }

    @GetMapping("/search-category")
    public ResponseEntity<Iterable<Foods>> findFoodByCategoryContaining(@RequestParam("name") String name, Pageable pageable) {
        return new ResponseEntity<>(iFoodService.findFoodByCategoryContaining(name, pageable), HttpStatus.OK);
    }
    @GetMapping("/search_category")
    public ResponseEntity<Iterable<Foods>> findAllByCategory(@RequestParam("id") Long id, Pageable pageable) {
        Optional<Category> category = iCategoryService.findById(id);
        return new ResponseEntity<>(iFoodService.findAllByCategory(category.get(), pageable), HttpStatus.OK);
    }
//    @GetMapping("/searchByCategory")
//    public ResponseEntity<Iterable<Foods>> findAllByCategory(@RequestParam("id") Long id,@PageableDefault(value = 5) Pageable pageable) {
//        Optional<Category> category = iCategoryService.findById(id);
//        return new ResponseEntity<>(iFoodService.findAllByCategory(category.get(), pageable), HttpStatus.OK);
//    }


}
