package com.github.andreytondo.api.user.media;

import com.github.andreytondo.utils.crud.Service;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import lombok.Getter;

@Getter
@RequestScoped
public class UserMediaService extends Service<Integer, UserMedia> {

    @Inject
    UserMediaRepository repository;

    public UserMediaService() {
        super(UserMedia.class);
    }
}
