package com.rakin.db;

import io.github.cdimascio.dotenv.Dotenv;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final SessionFactory sessionFactory = buildSessionFactory();

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public static void shutdown() {
        sessionFactory.close();
    }

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            Configuration cfg = new Configuration().configure();

            // Load environment variables
            Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

            // Set connection URL
            String connUrl = "jdbc:" + dotenv.get("DB_URL");
            cfg.setProperty("hibernate.connection.url", connUrl);

            // Set credentials
            cfg.setProperty("hibernate.connection.username", dotenv.get("DB_USER"));
            cfg.setProperty("hibernate.connection.password", dotenv.get("DB_PASSWORD"));

            return cfg.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
}