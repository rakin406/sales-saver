package com.rakin.db;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

class SaleTest {
    private static final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @AfterAll
    static void teardown() {
        HibernateUtil.shutdown();
    }

    @Test
    void getId() {
    }

    @Test
    void getCreatedAt() {
    }

    @Test
    void getProduct() {
    }

    @Test
    void setProduct() {
    }

    @Test
    void getPrice() {
    }

    @Test
    void setPrice() {
    }
}