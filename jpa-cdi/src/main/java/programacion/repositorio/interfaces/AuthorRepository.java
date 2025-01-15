package programacion.repositorio.interfaces;

import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;
import programacion.db.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends EntityRepository <Author, Integer> {

    // Version 1------------
//    Author findById(Integer id);
//    List<Author> findAll();
//    void save(Author author);
//    void update(Author author);
//    void delete(Integer id);

    Author findBy(Integer id);
    List<Author> findAll();
}
