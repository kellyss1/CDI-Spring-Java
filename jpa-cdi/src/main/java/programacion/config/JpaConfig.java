package programacion.config;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;

@ApplicationScoped
public class JpaConfig {

    // Versión 1
    //permite crear instancias del contenedor
//    private EntityManagerFactory emf;
//
//    @PostConstruct
//    void init() {
//        System.out.println("JpaConfig init");
//        emf = Persistence.createEntityManagerFactory("books-db");
//    }
//
//    @Produces
//    @RequestScoped
//    public EntityManager entityManager() {
//        System.out.println("JpaConfig entityManager");
//        return emf.createEntityManager();
//    }

    //Versión DeltaSpike
    @PersistenceUnitName("books-db")
    @Inject
    EntityManagerFactory emf;

    @Produces
    public EntityManager entityManager() {
        System.out.println("Creando EntityManager...");
        return emf.createEntityManager();
    }

    protected void closeEntityManager(@Disposes EntityManager entityManager) {
        System.out.println("Cerrando EntityManager...");
        if(entityManager.isOpen()){
            entityManager.close();
        }
    }

}