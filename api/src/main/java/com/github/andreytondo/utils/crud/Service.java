package com.github.andreytondo.utils.crud;


import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.Getter;

@Getter
public abstract class Service<T, E extends Identifiable<T>> {

    @Inject
    EntityManager em;

    private final Class<E> entityClass;

    public Service(Class<E> clazz) {
        this.entityClass = clazz;
    }

    @Transactional
    public T create(E entity) {
        em.persist(entity);
        return entity.getId();
    }

    public E read(T id) {
        return em.find(entityClass, id);
    }

    @Transactional
    public T update(E entity) {
        em.merge(entity);
        return entity.getId();
    }

    @Transactional
    public void delete(T id) {
        E entity = read(id);
        em.remove(entity);
    }

}
