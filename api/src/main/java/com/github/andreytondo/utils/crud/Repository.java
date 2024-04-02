package com.github.andreytondo.utils.crud;

import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import lombok.Getter;

@Getter
public class Repository<T, E extends Identifiable<T>> {

    @Inject
    protected EntityManager em;

}
