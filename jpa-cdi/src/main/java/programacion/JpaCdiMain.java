package programacion;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import programacion.db.Book;
import programacion.repositorio.interfaces.AuthorRepository;
import programacion.repositorio.interfaces.BookRepository;

import java.math.BigDecimal;
import java.util.List;

public class JpaCdiMain {

    public static void main(String[] args) {

        //Version 1------------
//        SeContainer container = SeContainerInitializer.newInstance().initialize();
//
//        var repoBooks = container.select(BookRepository.class).get();
//        var book = repoBooks.findById(1);
//        System.out.println(book);
//
//        var repoAuthors = container.select(AuthorRepository.class).get();
//        repoAuthors.findAll().forEach(System.out::println);


        //Version DeltaSpike------------
        SeContainer container = SeContainerInitializer.newInstance().initialize();
        var repoBooks = container.select(BookRepository.class).get();

        List<Book> librosMayor10 = repoBooks.findByPrecioGreaterThan(BigDecimal.TEN);
        librosMayor10.forEach(System.out::println);


    }
}
