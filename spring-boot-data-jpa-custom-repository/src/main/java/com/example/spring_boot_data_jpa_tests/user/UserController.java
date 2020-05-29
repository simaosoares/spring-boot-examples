package com.example.spring_boot_data_jpa_tests.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    @ResponseBody
    public List<User> findAll() {
        return this.userRepository.findAll();
    }

    @ResponseBody
    @GetMapping("/findAllDistinctNames")
    public List<String> findAllDistinctNames() {
        return this.userRepository.findAllDistinctNames();
    }
}
