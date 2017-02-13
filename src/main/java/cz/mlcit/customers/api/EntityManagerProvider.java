package cz.mlcit.customers.api;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Mlcit on 07.02.2017.
 * Provide new EntityManager for each request.
 */
@RequestScoped
public class EntityManagerProvider {

    @PersistenceContext
    private EntityManager entityManager;

    @Produces
    public EntityManager getEntityManager() {
        return entityManager;
    }

}
