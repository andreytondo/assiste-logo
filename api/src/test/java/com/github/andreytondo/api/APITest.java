package com.github.andreytondo.api;

import jakarta.enterprise.inject.spi.CDI;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;

public class APITest {

    @BeforeEach
    public void clearData() {
    }

    @AfterAll
    public void close() {
        EntityManager em = CDI.current().select(EntityManager.class).get();
        em.createQuery("DELETE FROM User").executeUpdate();
        em.close();
    }
}
