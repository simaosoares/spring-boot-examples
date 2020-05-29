package com.example.spring_boot_data_jpa_tests.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.data.repository.Repository;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;


/**
 * Data Jpa unit tests with custom repository.
 *
 * No need to tell spring to load our custom repository since {@link UserCustomRepository} is implemented by {@link Repository}
 * the {@link DataJpaTest} will automatically pickup our custom repository.
 */
@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryDataJpaAnnotationTest {

    @Autowired
    protected UserRepository userRepository;

    @Test
    public void findDistinctNames_shouldReturnData() {
        final List<String> allDistinctNames = userRepository.findAllDistinctNames();
        assertThat(allDistinctNames.size()).isEqualTo(2);
    }
}