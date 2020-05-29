package com.example.spring_boot_data_jpa_tests.user;

import javax.persistence.*;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(nullable = false)
    private String name;

    private User() {
        // thank you JPA \m/
    }

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
