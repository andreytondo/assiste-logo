package com.github.andreytondo.api.user.media;

import com.github.andreytondo.utils.crud.Repository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class UserMediaRepository extends Repository<Integer, UserMedia> {

    public UserMedia findUserMedia(Integer userId, Integer mediaId) {
        String sql = "SELECT * FROM usermedia WHERE userid = :userId AND mediaid = :mediaId";
        return (UserMedia) getEm().createNativeQuery(sql, UserMedia.class)
                .setParameter("userId", userId)
                .setParameter("mediaId", mediaId)
                .getSingleResult();
    }
}
