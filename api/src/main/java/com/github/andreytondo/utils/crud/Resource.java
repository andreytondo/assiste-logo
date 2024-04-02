package com.github.andreytondo.utils.crud;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import lombok.Getter;

@Getter
@Produces("application/json")
@Consumes("application/json")
public abstract class Resource<T, E extends Identifiable<T>, S extends Service<T, E>> {

    private final S service;

    public Resource() {
        service = createService();
    }

    @POST
    @Transactional
    public T create(E entity) {
        return service.create(entity);
    }

    @GET
    @Path("/{id}")
    public E read(@PathParam("id") T id) {
        return service.read(id);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public T update(E entity) {
        return service.update(entity);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public void delete(T id) {
        service.delete(id);
    }

    protected abstract S createService();
}
