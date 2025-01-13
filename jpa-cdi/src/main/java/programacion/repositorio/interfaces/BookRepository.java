package programacion.repositorio.interfaces;

import programacion.db.Book;

import java.util.List;

public interface BookRepository {
    Book findById(Integer id);
    List<Book> findAll();
    void save(Book author);
    void update(Book author);
    void delete(Integer id);
}
