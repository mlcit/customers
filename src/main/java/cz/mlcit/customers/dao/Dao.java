package cz.mlcit.customers.dao;

import cz.mlcit.customers.exceptions.ResourceException;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * Created by Mlcit on 07.02.2017.
 * Dao is a abstract class with common methods and attributes for database access objects.
 */
public abstract class Dao<T> {

    private final Class<T> type;
    EntityManager entityManager;

    Dao(Class<T> type) {
        this.type = type;
    }

    @Transactional
    public T add(T obj) throws Exception {
        validate(obj);
        entityManager.persist(obj);
        entityManager.flush();
        return obj;
    }

    @Transactional
    public T get(long id) throws Exception {
        T obj = entityManager.find(type, id);
        if (obj == null) {
            throw new ResourceException(type.getSimpleName() + " with id[" + id + "] not found.");
        }
        return obj;
    }

    @Transactional
    public void remove(long id) throws Exception {
        T obj = entityManager.find(type, id);
        if (obj == null) {
            throw new ResourceException(type.getSimpleName() + " with id[" + id + "] not found.");
        }
        entityManager.remove(obj);
    }

    void validate(T obj) throws Exception {
        if (obj == null) {
            throw new Exception();
        }
    }
}
