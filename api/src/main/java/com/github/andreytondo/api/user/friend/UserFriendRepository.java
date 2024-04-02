package com.github.andreytondo.api.user.friend;

import com.github.andreytondo.utils.crud.Repository;
import jakarta.enterprise.context.RequestScoped;

import java.util.List;

@RequestScoped
public class UserFriendRepository extends Repository<Integer, UserFriend> {

    public List<UserFriend> getFriends(Integer userId) {
        String sql = "SELECT * FROM userfriend WHERE userid = :userId";
        return getEm().createNativeQuery(sql, UserFriend.class)
                .setParameter("userId", userId)
                .getResultList();
    }

    public UserFriend findFriendship(Integer userId, Integer friendId) {
        String sql = "SELECT * FROM userfriend WHERE userid = :userId AND friendid = :friendId";
        return (UserFriend) getEm().createNativeQuery(sql, UserFriend.class)
                .setParameter("userId", userId)
                .setParameter("friendId", friendId)
                .getSingleResult();
    }
}
