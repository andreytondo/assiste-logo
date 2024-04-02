package com.github.andreytondo.api.user;

import com.github.andreytondo.utils.crud.Service;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UserService extends Service<Integer, User> {

    public UserService() {
        super(User.class);
    }
}
