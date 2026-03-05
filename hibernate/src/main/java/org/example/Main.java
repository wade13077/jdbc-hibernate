package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Student s1 = new Student();
        s1.setRollNo(102);
        s1.setsName("Navin");
        s1.setsAge(30);

        Student s2 = new Student();

        SessionFactory sf = new Configuration()
                .addAnnotatedClass(org.example.Student.class).configure().buildSessionFactory();
        Session session = sf.openSession();


        // insert,update,delete
        // Transaction transaction = session.beginTransaction();

        // session.persist(s1);     //insert
        // session.merge(s1);      // update

        // delete
        // s1 = session.find(Student.class, 102); // 給刪除用的
        // session.remove(s1);

        // transaction.commit();


        // select
        session.find(Student.class, 102);

        session.close();
        sf.close();

        System.out.println(s1);
        System.out.println(s2);
    }
}