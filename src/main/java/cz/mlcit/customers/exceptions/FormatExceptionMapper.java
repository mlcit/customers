package cz.mlcit.customers.exceptions;

import cz.mlcit.customers.api.Data;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Mlcit on 07.02.2017.
 * FormatExceptionMapper catch FormatExceptions.
 */
@Provider
public class FormatExceptionMapper implements ExceptionMapper<FormatException> {

    @Override
    public Response toResponse(FormatException e) {
        return Response.ok(new Data(new Error("bad format", e.getMessage())), MediaType.APPLICATION_JSON_TYPE).build();
    }
}
