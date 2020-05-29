package com.example.spring_boot_data_rest;

import com.example.spring_boot_data_rest.user.User;
import com.example.spring_boot_data_rest.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    public @PostConstruct void init() {
        userRepository.save(new User("Jeff Loomis", 666));
        userRepository.save(new User("Chris Broderick", 777));
    }

}
