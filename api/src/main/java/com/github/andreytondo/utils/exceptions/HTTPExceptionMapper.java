package com.github.andreytondo.utils.exceptions;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;

@Provider
public class HTTPExceptionMapper implements ExceptionMapper<WebApplicationException> {

    private final Logger log = Logger.getLogger(HTTPExceptionMapper.class);

    @Override
    public Response toResponse(WebApplicationException e) {
        if (e.getResponse().getStatus() == 401) {
            return Response.status(Response.Status.UNAUTHORIZED).entity(e.getCause()).build();
        }
        return Response.status(e.getResponse().getStatus()).build();
    }
}
