package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Item> items;

    @ManyToOne
    private Users users;


    public Cart(Long id, List<Item> items) {
        this.id = id;
        this.items = items;
    }



    public Cart(List<Item> items) {
        this.items = items;
    }

    public Cart() {
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }


}

