package com.example.spring_boot_data_jpa_tests.user;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer>, UserCustomRepository {
}
