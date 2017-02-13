package cz.mlcit.customers.criteria;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mlcit on 07.02.2017.
 * Criteria is abstract class which contains common attributes and methods for entities.
 */
public abstract class Criteria<T> {

    final CriteriaBuilder cb;
    final CriteriaQuery cq;
    final List<Predicate> predicates;
    private final EntityManager em;
    private final CriteriaDelete<T> cd;
    final Root<T> root;

    @SuppressWarnings("unchecked")
    Criteria(EntityManager em, Class<T> classType, TYPE type) {
        this.em = em;
        cb = em.getCriteriaBuilder();
        cq = cb.createQuery(classType);
        cd = cb.createCriteriaDelete(classType);
        predicates = new ArrayList<>();
        switch (type) {
            case DELETE:
                root = cd.from(classType);
                break;
            default:
                root = cq.from(classType);
        }
    }

    public void delete() {
        cd.where(predicates.toArray(new Predicate[]{}));
        em.createQuery(cd).executeUpdate();
    }

    @SuppressWarnings("unchecked")
    public T getFirst() {
        cq.where(predicates.toArray(new Predicate[]{}));
        List<T> list = em.createQuery(cq).setMaxResults(1).getResultList();
        if (list.isEmpty()) {
            return null;
        }
        return list.get(0);
    }

    @SuppressWarnings("unchecked")
    public List<T> list() {
        cq.where(predicates.toArray(new Predicate[]{}));
        return em.createQuery(cq).getResultList();
    }

    public enum TYPE {GET, DELETE}
}

