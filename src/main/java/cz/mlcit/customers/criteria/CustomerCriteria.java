package cz.mlcit.customers.criteria;

import cz.mlcit.customers.model.Customer;
import cz.mlcit.customers.model.Customer_;

import javax.persistence.EntityManager;
import java.util.Calendar;

/**
 * Created by Mlcit on 07.02.2017.
 * CustomerCriteria is a customized class for building criteria for listing or removing entities.
 */
public class CustomerCriteria extends Criteria<Customer> {

    public CustomerCriteria(EntityManager em) {
        this(em, TYPE.GET);
    }

    public CustomerCriteria(EntityManager em, Criteria.TYPE type) {
        super(em, Customer.class, type);
    }

    public CustomerCriteria orderByLastName() {
        cq.orderBy(cb.asc(root.get(Customer_.firstName)));
        return this;
    }

    public CustomerCriteria lastNameStartWith(String string) {
        if (string != null) {
            predicates.add(cb.like(root.get(Customer_.lastName), string + "%"));
        }
        return this;
    }

    public CustomerCriteria firstNameStartWith(String string) {
        if (string != null) {
            predicates.add(cb.like(root.get(Customer_.firstName), string + "%"));
        }
        return this;
    }

    public CustomerCriteria birthTo(Calendar calendar) {
        if (calendar != null) {
            predicates.add(cb.lessThanOrEqualTo(root.get(Customer_.birth), calendar));
        }
        return this;
    }

    public CustomerCriteria birthFrom(Calendar calendar) {
        if (calendar != null) {
            predicates.add(cb.greaterThanOrEqualTo(root.get(Customer_.birth), calendar));
        }
        return this;
    }
}
