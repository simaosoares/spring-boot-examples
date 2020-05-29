package com.example.spring_boot_data_jpa_tests.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestEntityManager;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Data Jpa unit tests without the {@link DataJpaTest} annotation.
 *
 * Important: in order to use {@link TestEntityManager} to persist sample test data
 * the {@link AutoConfigureTestEntityManager} must be added to the test class.
 */
@Transactional
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserRepositoryNonDataJpaAnnotationTest {

    @Autowired
    protected UserRepository userRepository;

    @Test
    public void findDistinctNames_shouldReturnData() {
        final List<String> allDistinctNames = userRepository.findAllDistinctNames();
        assertThat(allDistinctNames.size()).isEqualTo(2);
    }
}
