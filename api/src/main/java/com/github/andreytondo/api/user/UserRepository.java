package com.github.andreytondo.api.user;

import com.github.andreytondo.utils.crud.Repository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UserRepository extends Repository<Integer, User> {
}
