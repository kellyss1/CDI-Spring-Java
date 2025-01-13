package programacion;

import jakarta.enterprise.inject.se.SeContainer;
import jakarta.enterprise.inject.se.SeContainerInitializer;
import programacion.repositorio.interfaces.AuthorRepository;
import programacion.repositorio.interfaces.BookRepository;

import java.math.BigDecimal;

public class JpaCdiMain {

    public static void main(String[] args) {

        SeContainer container = SeContainerInitializer.newInstance().initialize();

        var repoBooks = container.select(BookRepository.class).get();
        var book = repoBooks.findById(1);
        System.out.println(book);

        var repoAuthors = container.select(AuthorRepository.class).get();
        repoAuthors.findAll().forEach(System.out::println);
    }
}
