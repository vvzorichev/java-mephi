package com.vvzorichev;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryUtil {
    private static SessionFactory SessionFactory;
    private SessionFactoryUtil() {}
    public static SessionFactory GetSessionFactory() {
        if (SessionFactory == null) {
            SessionFactory = new Configuration().configure().buildSessionFactory();
        }
        return SessionFactory;
    }
}
