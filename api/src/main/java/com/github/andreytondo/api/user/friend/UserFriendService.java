package com.github.andreytondo.api.user.friend;

import com.github.andreytondo.api.enums.UserFriendStatus;
import com.github.andreytondo.api.user.User;
import com.github.andreytondo.utils.crud.Service;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@RequestScoped
public class UserFriendService extends Service<Integer, UserFriend> {

    @Inject
    UserFriendRepository repository;

    public UserFriendService() {
        super(UserFriend.class);
    }

    public Integer updateFriendship(Integer userId, Integer friendId, UserFriendStatus status) {
        UserFriend userFriend = repository.findFriendship(userId, friendId);
        userFriend.setStatus(status);
        return update(userFriend);
    }

    public Integer create(Integer userId, Integer friendId, UserFriendStatus status) {
        UserFriend userFriend = UserFriend.builder()
                .user(new User(userId))
                .friend(new User(friendId))
                .status(status)
                .createdAt(LocalDateTime.now())
                .build();
        return create(userFriend);
    }
}
