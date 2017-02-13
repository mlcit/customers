package cz.mlcit.customers.dao;

import cz.mlcit.customers.criteria.Criteria;
import cz.mlcit.customers.criteria.CustomerCriteria;
import cz.mlcit.customers.exceptions.ValidationException;
import cz.mlcit.customers.exceptions.ResourceException;
import cz.mlcit.customers.model.Customer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * Created by Mlcit on 07.02.2017.
 * CustomerDao class provides methods for access customers stored in database.
 */
@ApplicationScoped
public class CustomerDao extends Dao<Customer> {

    public CustomerDao() {
        super(Customer.class);
    }

    @Inject
    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Customer add(Customer obj) throws Exception {
        if (obj == null) obj = new Customer();

        if (obj.getFirstName() == null) obj.setFirstName("");
        if (obj.getLastName() == null) obj.setLastName("");
        if (obj.getBirth() == null) obj.setBirth(new GregorianCalendar());

        validate(obj);
        entityManager.persist(obj);
        entityManager.flush();
        return obj;
    }

    @Transactional
    public void update(long id, String firstName, String lastName, Calendar birth) throws Exception {
        Customer obj = entityManager.find(Customer.class, id);
        if (obj == null) {
            throw new ResourceException((Customer.class).getSimpleName() + " with id[" + id + "] not found.");
        }
        if (firstName != null) obj.setFirstName(firstName);
        if (lastName != null) obj.setLastName(lastName);
        if (birth != null) obj.setBirth(birth);
        validate(obj);
    }

    @Transactional
    public List<Customer> list(String firstName, String lastName, Calendar birthFrom, Calendar birthTo) {
        CustomerCriteria criteria = new CustomerCriteria(entityManager).orderByLastName().firstNameStartWith(firstName).lastNameStartWith(lastName).birthFrom(birthFrom).birthTo(birthTo);
        return criteria.list();
    }

    @Transactional
    public void delete(String firstName, String lastName, Calendar birthFrom, Calendar birthTo) {
        CustomerCriteria criteria = new CustomerCriteria(entityManager, Criteria.TYPE.DELETE).firstNameStartWith(firstName).lastNameStartWith(lastName).birthFrom(birthFrom).birthTo(birthTo);
        criteria.delete();
    }

    @Override
    void validate(Customer obj) throws Exception {
        if (obj == null) {
            throw new Exception();
        }
        if (obj.getFirstName() == null || obj.getFirstName().length() < 3) {
            throw new ValidationException("First name must have more than 2 letters.");
        }
        if (obj.getLastName() == null || obj.getLastName().length() < 3) {
            throw new ValidationException("Last name must have more than 2 letters.");
        }
        Calendar today = new GregorianCalendar();
        today.set(today.get(Calendar.YEAR) - 18, today.get(Calendar.MONTH), today.get(Calendar.DAY_OF_MONTH));
        if (obj.getBirth() == null || obj.getBirth().after(today)) {
            throw new ValidationException("Customer must be at least 18 years old.");
        }
    }
}
