package com.petrov;

import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

public class Config {
    private static final Configuration configuration = new Configuration().configure("hibernate.cfg.xml");

    private static SessionFactory buildSessionFactory() {
        try {
            return configuration.buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory(){
        return buildSessionFactory();
    }
}
