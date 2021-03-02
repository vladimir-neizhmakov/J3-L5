package com.flamexander.hibernate.HW5;

import com.flamexander.hibernate.crud.SimpleItem;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class HW5 {
    private static SessionFactory factory;

    public static void init() {
        factory = new Configuration()
                .configure("configs/HW5/hibernate.cfg.xml")
                .buildSessionFactory();
    }

    public static void createTableProducts(){

        try (Session session = factory.getCurrentSession()){
            session.beginTransaction();
            session.createNativeQuery(Files.lines(Paths.get("create_products.sql")).collect(Collectors.joining(" "))).executeUpdate();
            session.getTransaction().commit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void create() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            session.save(new Product("newProduct",45.00));
            session.getTransaction().commit();
        }
    }

    public static void read() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = session.createQuery("from Product").getResultList();
            System.out.println(products);
            session.getTransaction().commit();
        }
    }

    public static void update() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 1L);
            product.setCost(23.56);
            session.getTransaction().commit();
        }
    }

    public static void delete() {
        try (Session session = factory.getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, 3L);
            session.delete(product);
            session.getTransaction().commit();
        }
    }


    public static void shutdown() {
        factory.close();
    }

    public static void main(String[] args) {
        try {
            init();
            createTableProducts();
          //  create();
          //  read();
          // update();
          // delete();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            shutdown();
        }
    }
}
