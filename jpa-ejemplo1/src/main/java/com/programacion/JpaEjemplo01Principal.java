package com.programacion;

import com.programacion.db.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

public class JpaEjemplo01Principal {
    public static void main(String[] args) {
//        // Creamos el EntityManagerFactory y el EntityManager
//        EntityManagerFactory emf = Persistence.createEntityManagerFactory("books-db");
//        EntityManager em = emf.createEntityManager();
//
//        // Buscamos un Author por su Id
//        System.out.println("Buscando autor por su Id...");
//        Author author1 = em.find(Author.class, 1);
//        System.out.println(author1);
//
//        // Buscamos todos los autores y los mostramos
//        System.out.println();
//        System.out.println("Buscando todos los autores...");
//        TypedQuery<Author> query = em.createQuery("select o from Author o order by o.nombre asc", Author.class);
//        query.getResultList().forEach(System.out::println);
//
//        emf.close();


        // Para PostgreSQL
        EntityManagerFactory emfPostgres = Persistence.createEntityManagerFactory("books-db-postgres");
        EntityManager emPostgres = emfPostgres.createEntityManager();

        // Buscamos un Author por su Id
        System.out.println("Buscando autor por su Id...");
        Author author1 = emPostgres.find(Author.class, 1);
        System.out.println(author1);

        // Buscamos todos los autores y los mostramos
        System.out.println();
        System.out.println("Buscando todos los autores...");
        TypedQuery<Author> query = emPostgres.createQuery("select o from Author o order by o.nombre asc", Author.class);
        query.getResultList().forEach(System.out::println);

        // Cerramos el EntityManager y EntityManagerFactory
        emPostgres.close();
        emfPostgres.close();

    }
}
