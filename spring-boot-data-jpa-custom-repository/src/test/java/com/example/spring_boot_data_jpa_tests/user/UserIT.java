package com.example.spring_boot_data_jpa_tests.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * User Integration tests
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIT {

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Test
    public void findDistinctNames_shouldReturnData() {
        // act
        final ResponseEntity<List<String>> responseEntity = testRestTemplate.exchange("/user/findAllDistinctNames",
                HttpMethod.GET, null, new ParameterizedTypeReference<List<String>>() {});

        // assert
        assertThat(responseEntity.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(responseEntity.getBody()).isNotNull();
        assertThat(responseEntity.getBody().size()).isEqualTo(2);
    }
}
