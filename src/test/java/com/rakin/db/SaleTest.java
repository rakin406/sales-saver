package com.rakin.db;

import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;

class SaleTest {
    private final SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    @AfterAll
    protected static void teardown() {
        HibernateUtil.shutdown();
    }

    @org.junit.jupiter.api.Test
    void getId() {
    }

    @org.junit.jupiter.api.Test
    void getCreatedAt() {
    }

    @org.junit.jupiter.api.Test
    void getProduct() {
    }

    @org.junit.jupiter.api.Test
    void setProduct() {
    }

    @org.junit.jupiter.api.Test
    void getPrice() {
    }

    @org.junit.jupiter.api.Test
    void setPrice() {
    }
}