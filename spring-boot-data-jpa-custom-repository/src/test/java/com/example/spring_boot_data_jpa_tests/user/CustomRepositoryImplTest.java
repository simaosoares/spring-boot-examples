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
 * Since {@link CustomRepository} is not implemented by any {@link Repository} the {@link DataJpaTest} won't pickup the custom repository.
 * We need to tell spring to load our custom repository with {@link Import}.
 */
@DataJpaTest
@RunWith(SpringRunner.class)
@Import(CustomRepositoryImpl.class)
public class CustomRepositoryImplTest {

    @Autowired
    protected CustomRepository customRepository;

    @Test
    public void findAllDistinctNames_shouldReturnData() {
        final List<String> allDistinctNames = this.customRepository.findAllDistinctNames();
        assertThat(allDistinctNames.size()).isEqualTo(2);
    }
}