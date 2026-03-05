package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

// Fetching Data using HQL
public class Main4 {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration()
                .configure()
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sf.openSession();


        //   Select * from laptop where ram=32 ->SQL
        //   from Laptop where ram=32 -> HQL


        // Query query = session.createQuery("from Laptop where ram=32");
        // Query query = session.createQuery("from Laptop where brand like 'Asus' ");
        // List<Laptop> laptops = query.getResultList();
        // System.out.println(laptops);


        String brand = "Asus";
        Query query = session.createQuery("select brand, model from Laptop where brand like ?1");
        query.setParameter(1, brand);

        List<Object[]> laptops = query.getResultList();

        for (Object[] data : laptops) {
            System.out.println((String) data[0] + " : " + (String) data[1]);
        }

        session.close();
        sf.close();
    }
}
