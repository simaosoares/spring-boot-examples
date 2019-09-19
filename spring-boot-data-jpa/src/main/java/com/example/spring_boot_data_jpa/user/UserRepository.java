package com.example.spring_boot_data_jpa.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query( value = "from User where age = ?1")
    List<User> findByAgeAnnotatedQuery(int age);

    @Query( value = "select u from #{#entityName} u where age = :age")
    List<User> findByAgeAnnotatedQueryWithNamedParameter(int age);
}
