package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String password;


    @Column(nullable = false, unique = true,
            columnDefinition = "varchar(50)")
    private String name;

    private String address;
     private String email;

    private String phone;

    @ManyToOne
    private Roles roles;

    public Users(String email , String password) {
        this.email = email;
        this.password = password;

    }

    public Users( String name, String email,String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }
}
