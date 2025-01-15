package programacion.repositorio.impl;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import programacion.db.Author;
import programacion.repositorio.interfaces.AuthorRepository;

import java.util.List;

//@ApplicationScoped
//public class AuthorRepositoryImpl implements AuthorRepository {

public class AuthorRepositoryImpl {

//    @Inject
//    private EntityManager em;
//
//    @Override
//    public Author findById(Integer id) {
//        return em.find(Author.class, id);
//    }
//
//    @Override
//    public List<Author> findAll() {
//        return em.createQuery("select o from Author o", Author.class).getResultList();
//    }
//
//    @Override
//    public void save(Author author) {
//        try {
//            em.getTransaction().begin();
//            em.persist(author);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void update(Author author) {
//        try {
//            em.getTransaction().begin();
//            var tmp = em.find(Author.class, author.getId());
//
//            tmp.setNombre(author.getNombre());
//            tmp.setApellido(author.getApellido());
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
//        }
//    }
//
//    @Override
//    public void delete(Integer id) {
//        try {
//            em.getTransaction().begin();
//            var tmp = em.find(Author.class, id);
//            em.remove(tmp);
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            em.getTransaction().rollback();
//            e.printStackTrace();
//        }
//    }
}
