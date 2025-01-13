package programacion.repositorio.impl;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import programacion.db.Book;
import programacion.repositorio.interfaces.BookRepository;

import java.util.List;

@ApplicationScoped
public class BookRepositoryImpl implements BookRepository {

    @Inject
    private EntityManager em;

    @Override
    public Book findById(Integer id) {
        return em.find(Book.class, id);
    }

    @Override
    public List<Book> findAll() {
        return em.createQuery("select o from Book o", Book.class).getResultList();
    }

    @Override
    public void save(Book obj) {
        try {
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

    @Override
    public void update(Book obj) {
        try {
            em.getTransaction().begin();
            var tmp = em.find(Book.class, obj.getId());

            tmp.setIsbn(obj.getIsbn());
            tmp.setTitulo(obj.getTitulo());
            tmp.setPrecio(obj.getPrecio());
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

    }

    @Override
    public void delete(Integer id) {
        try {
            em.getTransaction().begin();
            var tmp = em.find(Book.class, id);
            em.remove(tmp);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
    }

}
