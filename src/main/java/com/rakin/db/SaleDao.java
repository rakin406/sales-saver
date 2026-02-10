package com.rakin.db;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class SaleDao {
    // Create
    public void save(Sale sale) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(sale);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    // Read
    public List<Sale> getTodaySales() {
        // TODO: Query all sales of current date.
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Sale", Sale.class).list();
        }
    }

    // Update
    public void update(Sale sale) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.merge(sale);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }

    // Delete
    public void delete(Long id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Sale sale = session.find(Sale.class, id);
            if (sale != null) {
                session.remove(sale);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
        }
    }
}