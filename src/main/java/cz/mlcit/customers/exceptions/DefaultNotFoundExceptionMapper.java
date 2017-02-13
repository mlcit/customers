package cz.mlcit.customers.exceptions;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Mlcit on 07.02.2017.
 * DefaultNotFoundExceptionMapper catch NotFoundExceptions.
 */
@Provider
public class DefaultNotFoundExceptionMapper implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
