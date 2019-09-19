package com.example.spring_boot_data_jpa.user;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@DataJpaTest
@RunWith(SpringRunner.class)
public class UserRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UserRepository userRepository;

    @Before
    public void setUp() throws Exception {
        entityManager.persist(new User("Jeff Loomis", 666));
        entityManager.persist(new User("Chris Broderick", 777));
    }

    @Test
    public void findByNameAnnotatedQuery_shouldReturnData() {
        final List<User> result = this.userRepository.findByAgeAnnotatedQuery(666);

        assertEquals(result.size(), 1);
    }

    @Test
    public void findByAgeAnnotatedQueryWithNamedParameter_shouldReturnData() {
        final List<User> result = this.userRepository.findByAgeAnnotatedQueryWithNamedParameter(777);

        assertEquals(result.size(), 1);
    }
}