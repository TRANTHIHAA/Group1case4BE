package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Foods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double price;
    private String imageUrl;
    private String description;
    private Long countLike;
    private Long countBuys;

    @Transient
    private MultipartFile image;

    @ManyToOne
    @JoinColumn(name="id_cate")
    private Category category;

    @ManyToOne
    private Users users;

    public Foods(Long id, String name, double price, String imageUrl, String description, Long countLike, Long countBuys, Category category) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        this.countLike = countLike;
        this.countBuys = countBuys;
        this.category = category;
    }

    public Foods(Long id, String name, double price, String imageUrl, String description, Long countLike, Long countBuys, Category category, Users users) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.imageUrl = imageUrl;
        this.description = description;
        this.countLike = countLike;
        this.countBuys = countBuys;
        this.category = category;
        this.users = users;
    }
}
