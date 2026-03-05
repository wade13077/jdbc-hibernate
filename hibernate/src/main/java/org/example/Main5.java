package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

// Level 2 cache using Ehcache
public class Main5 {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Laptop_L2cache.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        Laptop_L2cache l1 = session.find(Laptop_L2cache.class, 2);
        System.out.println(l1);
        session.close();

        Session session1 = sf.openSession();
        Laptop_L2cache l2 = session1.find(Laptop_L2cache.class, 2);
        System.out.println(l2);

        session1.close();

        sf.close();
    }
}
