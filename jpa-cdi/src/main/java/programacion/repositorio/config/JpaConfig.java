package programacion.repositorio.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

@ApplicationScoped
public class JpaConfig {
    //permite crear instancias del contenedor
    private EntityManagerFactory emf;

    @PostConstruct
    void init() {
        System.out.println("JpaConfig init");
        emf = Persistence.createEntityManagerFactory("books-db");
    }

    @Produces
    @RequestScoped
    public EntityManager entityManager() {
        System.out.println("JpaConfig entityManager");
        return emf.createEntityManager();
    }
}