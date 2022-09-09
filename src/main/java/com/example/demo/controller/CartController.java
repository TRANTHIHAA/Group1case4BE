package com.example.demo.controller;

import com.example.demo.model.Cart;
import com.example.demo.model.Item;
import com.example.demo.service.ICartService;
import com.example.demo.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/api/carts")
public class CartController {
    @Autowired
    private ICartService iCartService;
    @Autowired
    private IItemService itemService;

    @GetMapping("/{id}")
    private ResponseEntity<?> findByCustomerId(@PathVariable Long id) {
        return new ResponseEntity<>(iCartService.findAllByCustomerId(id), HttpStatus.OK);
    }
    @GetMapping
    private ResponseEntity<List<Cart>> getAll() {
        return new ResponseEntity<>(iCartService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/item")
    private ResponseEntity<List<Item>> getAllItem() {
        return new ResponseEntity<>(itemService.findAll(), HttpStatus.OK);
    }


    // Tìm kiếm List Item theo Id người dùng
    @GetMapping("/item/{idCustomer}")
    private ResponseEntity<List<Item>> findItemByCustomerId(@PathVariable Long idCustomer) {
        return new ResponseEntity<>(itemService.findItemByCustomerId(idCustomer), HttpStatus.OK);
    }


    // Xóa Item khỏi giỏ hàng
    @DeleteMapping("/item/{idItem}")
    private ResponseEntity<Void> deleteItemById(@PathVariable Long idItem) {
        itemService.removeById(idItem);
        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PostMapping("/item")
    private ResponseEntity<Item> addItemToCart(@RequestBody Item item){
        return new ResponseEntity<>(itemService.save(item),HttpStatus.CREATED);
    }
    @PutMapping("/item")
    private ResponseEntity<Item> updateProduct(@RequestBody Item item){
        Optional<Item> optionalItem = itemService.findById(item.getId());
        if(optionalItem.isPresent()){
            return new ResponseEntity<>(itemService.save(item),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  @PostMapping
    private ResponseEntity<Cart> create(@RequestBody Cart cart){
        return new ResponseEntity<>(iCartService.save(cart),HttpStatus.CREATED);
  }

    @DeleteMapping("/delete/{idUser}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long idUser) {
        Optional<Cart> cart = iCartService.findById(idUser);
        cart.ifPresent(value -> itemService.deleteAllByCart(value));
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

}
