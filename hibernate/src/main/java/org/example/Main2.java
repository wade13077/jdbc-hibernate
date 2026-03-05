package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// 只建一張表laptop 合在 alien 裡
public class Main2 {
    public static void main(String[] args) {

        Laptop_Emb l1 = new Laptop_Emb();
        l1.setBrand("Asus");
        l1.setModel("Rog");
        l1.setRam(16);

        Alien_Emb a1 = new Alien_Emb();
        a1.setAid(101);
        a1.setAname("Navin");
        a1.setTech("Java");
        a1.setLaptop(l1);

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(org.example.Alien_Emb.class)
                .buildSessionFactory();

        Session session = sf.openSession();

        Transaction transaction = session.beginTransaction();
        session.persist(a1);
        transaction.commit();


        Alien_Emb a2 = session.find(Alien_Emb.class, 101);
        System.out.println(a2);


        session.close();
        sf.close();
    }
}