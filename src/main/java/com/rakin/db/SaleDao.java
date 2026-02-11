package com.rakin.db;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.time.LocalDate;
import java.time.LocalDateTime;
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
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            LocalDate today = LocalDate.now();
            LocalDateTime start = today.atStartOfDay();
            LocalDateTime end = today.plusDays(1).atStartOfDay();

            String hql = """
                    from Sale sale
                    where sale.createdAt >= :start
                    and sale.createdAt < :end
                    order by sale.createdAt
                    """;

            Query<Sale> query = session.createQuery(hql, Sale.class);
            query.setParameter("start", start);
            query.setParameter("end", end);

            return query.list();
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