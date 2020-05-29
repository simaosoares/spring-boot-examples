package com.example.spring_boot_data_jpa_tests.user;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserCustomRepositoryImpl implements UserCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @SuppressWarnings("unchecked")
    public List<String> findAllDistinctNames() {
        return (List<String>) this.entityManager.createNativeQuery("select distinct(name) from user")
                .getResultList();
    }
}
