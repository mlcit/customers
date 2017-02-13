package cz.mlcit.customers.exceptions;

import cz.mlcit.customers.api.Data;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Mlcit on 07.02.2017.
 * ValidationExceptionMapper catch ValidationExceptions.
 */
@Provider
public class ValidationExceptionMapper implements ExceptionMapper<ValidationException> {

    @Override
    public Response toResponse(ValidationException e) {
        return Response.ok(new Data(new Error("validation failed", e.getMessage())), MediaType.APPLICATION_JSON_TYPE).build();
    }
}
