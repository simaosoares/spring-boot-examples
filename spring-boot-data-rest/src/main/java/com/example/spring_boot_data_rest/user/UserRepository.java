package com.example.spring_boot_data_rest.user;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

    Iterable<User> findAllByNameIn(String[] names);
}