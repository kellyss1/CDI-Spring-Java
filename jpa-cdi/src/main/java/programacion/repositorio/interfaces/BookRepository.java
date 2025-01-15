package programacion.repositorio.interfaces;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import programacion.db.Book;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends EntityRepository<Book, Integer> {

    //Version 1------------
//    Book findById(Integer id);
//    List<Book> findAll();
//    void save(Book author);
//    void update(Book author);
//    void delete(Integer id);

    Book findByIsbn(String isbn);

    Optional<Book> findOptionalByIsbn(Integer integer);

    List<Book> findByPrecioGreaterThan(BigDecimal precio);
}
