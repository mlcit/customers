package cz.mlcit.customers.exceptions;

import cz.mlcit.customers.api.Data;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * Created by Mlcit on 07.02.2017.
 * ResourceExceptionMapper catch ResourceException.
 */
@Provider
public class ResourceExceptionMapper implements ExceptionMapper<ResourceException> {

    @Override
    public Response toResponse(ResourceException e) {
        return Response.ok(new Data(new Error("not found", e.getMessage())), MediaType.APPLICATION_JSON_TYPE).build();
    }
}
