package com.programacion;

import com.programacion.db.Author;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;

import com.programacion.db.Book;
import java.util.List;

public class JpaEjemplo01Principal {

    public static void main1(String[] args) {
////        // Creamos el EntityManagerFactory y el EntityManager
////        EntityManagerFactory emf = Persistence.createEntityManagerFactory("books-db");
////        EntityManager em = emf.createEntityManager();
////
////        // Buscamos un Author por su Id
////        System.out.println("Buscando autor por su Id...");
////        Author author1 = em.find(Author.class, 1);
////        System.out.println(author1);
////
////        // Buscamos todos los autores y los mostramos
////        System.out.println();
////        System.out.println("Buscando todos los autores...");
////        TypedQuery<Author> query = em.createQuery("select o from Author o order by o.nombre asc", Author.class);
////        query.getResultList().forEach(System.out::println);
////
////        emf.close();
//
//
//        // Para PostgreSQL
//        EntityManagerFactory emfPostgres = Persistence.createEntityManagerFactory("books-db-postgres");
//        EntityManager emPostgres = emfPostgres.createEntityManager();
//
//        // Buscamos un Author por su Id
//        System.out.println("Buscando autor por su Id...");
//        Author author1 = emPostgres.find(Author.class, 1);
//        System.out.println(author1);
//
//        // Buscamos todos los autores y los mostramos
//        System.out.println();
//        System.out.println("Buscando todos los autores...");
//        TypedQuery<Author> query = emPostgres.createQuery("select o from Author o order by o.nombre asc", Author.class);
//        query.getResultList().forEach(System.out::println);
//
//        // Cerramos el EntityManager y EntityManagerFactory
//        emPostgres.close();
//        emfPostgres.close();
//
    }

    public static void main2(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("books-db");
        EntityManager em = emf.createEntityManager();

        //---------------------------------
        System.out.println();
        System.out.println("--Autores");
        Author aut1 = em.find(Author.class, 1);
        Author aut2 = em.find(Author.class, 2);

        System.out.println(aut1);
        System.out.println(aut2);

        System.out.println();
        System.out.println("TypedQuery");

        TypedQuery<Author> qry = em.createQuery("select o from Author o order by o.nombre asc", Author.class);
        qry.getResultStream().forEach(System.out::println);

        //---------------------------------
        System.out.println();
        System.out.println("--Libros");

        var book1 = em.find(Book.class, 1);
        System.out.println( book1);

        var qry2 = em.createQuery("select o.isbn from Book o order by o.id asc",String.class);
        List<String> isbns = qry2.getResultList();
        isbns.stream()
                .map(s -> "ISBN: " + s)
                .forEach(System.out::println);

//        var qry3 = em.createQuery("select o.isbn, o.titulo from Book o order by o.titulo asc", String[].class);
//        List<String[]> datos3 = qry3.getResultList();
//        datos3.stream()
//                .map(s -> "ISBN: " + s[0] + ", Titulo: " + s[1])
//                .forEach(System.out::println);
//
//        var qry4 = em.createQuery("select o.isbn, o.precio, o.titulo from Book o order by o.titulo asc", Object[].class);
//        List<Object[]> datos4 = qry4.getResultList();
//        datos4.stream()
//                .map(s -> "ISBN: " + s[0] + ", Precio: " + s[1] + ", Titulo: " + s[2])
//                .forEach(System.out::println);
    }

    public static void main3(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("books-db");
        EntityManager em = emf.createEntityManager();

//        var book1 = em.find(Book.class, 1);
//        System.out.println(book1);
//
//        System.out.println(book1.getAuthor());

        //var author = em.find(Author.class, book1.getAuthorId());
        //System.out.println(author);

        //ISBN, TITULO, APELLIDO
//        em.createQuery("select o.isbn, o.titulo, o.author.apellido from Book o", Object[].class)
//                .getResultStream()
//                .map(s -> "ISBN: " + s[0] + ", Titulo: " + s[1] + ", Apellido: " + s[2])
//                .forEach(System.out::println);
        ;

        em.createQuery("select o, o.author from Book o", Object[].class)
                .getResultList().
                stream()
                .map(s -> "ISBN: " + ((Book)s[0]).getIsbn() + ", Titulo: " + ((Book)s[0]).getTitulo() + ", Apellido: " + ((Author)s[1]).getApellido())
                .forEach(System.out::println);

    }

    public static void main4(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("books-db");
        EntityManager em = emf.createEntityManager();

        var autor = em.find(Author.class,1);

        System.out.println("Author ------");
        System.out.println(autor.getNombreCompleto());
        System.out.println();

        System.out.println("Libros del autor: "+ autor.getApellido());
        autor.getLibros().forEach(System.out::println);




    }

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("books-db");
        EntityManager em = emf.createEntityManager();

//        for(int i = 0; i < 10; i++){ //Hace una sola vez la consulta, no sobrecarga la DB
//            var autor = em.find(Author.class,1);
//            autor.calcularNombreCompleto();
//            System.out.println(autor);
//        }

        var autor = em.find(Author.class,1);
        var autor2 = em.find(Author.class,2);

        em.getTransaction().begin(); //Necesario para que se actualice en la base de datos
        autor.setNombre("Nombre 1");
        //autor.setNombre("Nombre 11"); solo hace el update del ultimo set

        autor2.setNombre("Nombre 2"); //Detecta que ya tiene el mismo nombre y no lo sube
        em.getTransaction().commit();

        System.out.println(autor2);
    }
}
