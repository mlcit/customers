package cz.mlcit.customers.api;

import cz.mlcit.customers.dao.CustomerDao;
import cz.mlcit.customers.model.Customer;
import cz.mlcit.customers.utils.DateParam;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Mlcit on 07.02.2017.
 * This class provides an API for customer management.
 */
@Path("/v1/customers")
public class CustomerApi {

    private CustomerDao customerDao;

    @Inject
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Data list(
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName,
            @QueryParam("birthFrom") DateParam birthFrom,
            @QueryParam("birthTo") DateParam birthTo
    ) throws Exception {
        return new Data(customerDao.list(firstName, lastName, birthFrom == null ? null : birthFrom.toCalendar(), birthTo == null ? null : birthTo.toCalendar()));
    }

    @DELETE
    public Data remove(
            @QueryParam("firstName") String firstName,
            @QueryParam("lastName") String lastName,
            @QueryParam("birthFrom") DateParam birthFrom,
            @QueryParam("birthTo") DateParam birthTo
    ) throws Exception {
        customerDao.delete(firstName, lastName, birthFrom == null ? null : birthFrom.toCalendar(), birthTo == null ? null : birthTo.toCalendar());
        return new Data();
    }

    @POST
    @Produces({MediaType.APPLICATION_JSON})
    public Data create(
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("birth") DateParam birth
    ) throws Exception {
        Customer obj = new Customer();
        obj.setFirstName(firstName);
        obj.setLastName(lastName);
        obj.setBirth(birth == null ? null : birth.toCalendar());
        return new Data(customerDao.add(obj));
    }

    @PUT
    @Path("{id}")
    public Data update(
            @PathParam("id") long id,
            @FormParam("firstName") String firstName,
            @FormParam("lastName") String lastName,
            @FormParam("birth") DateParam birth
    ) throws Exception {
        customerDao.update(id, firstName, lastName, birth == null ? null : birth.toCalendar());
        return new Data();
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Data get(
            @PathParam("id") long id
    ) throws Exception {
        return new Data(customerDao.get(id));
    }

    @DELETE
    @Path("{id}")
    public Data remove(
            @PathParam("id") long id
    ) throws Exception {
        customerDao.remove(id);
        return new Data();
    }

}
