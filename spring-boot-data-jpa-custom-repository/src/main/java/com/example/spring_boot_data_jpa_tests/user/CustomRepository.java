package com.example.spring_boot_data_jpa_tests.user;

import java.util.List;

public interface CustomRepository {
    List<String> findAllDistinctNames();
}
