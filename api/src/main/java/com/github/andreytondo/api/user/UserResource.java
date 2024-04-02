package com.github.andreytondo.api.user;

import com.github.andreytondo.api.enums.UserFriendStatus;
import com.github.andreytondo.api.user.friend.UserFriend;
import com.github.andreytondo.api.user.friend.UserFriendService;
import com.github.andreytondo.api.user.media.UserMedia;
import com.github.andreytondo.api.user.media.UserMediaService;
import com.github.andreytondo.utils.crud.Resource;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/v1/users")
public class UserResource extends Resource<Integer, User, UserService> {

    @Inject
    UserFriendService friendService;

    @Inject
    UserMediaService mediaService;


    @Override
    protected UserService createService() {
        return new UserService();
    }

    @GET
    @Path("/{userId}/friends")
    public List<UserFriend> getFriends(@PathParam("userId") Integer userId) {
        return friendService.getRepository().getFriends(userId);
    }

    @POST
    @Path("/{userId}/friends/{friendId}/{status}")
    public Integer createFriendship(
            @PathParam("userId") Integer userId,
            @PathParam("friendId") Integer friendId,
            @PathParam("status") UserFriendStatus status) {
        return friendService.create(userId, friendId, status);
    }

    @PUT
    @Path("/{userId}/friends/{friendId}/{status}")
    public Integer updateFriendship(
            @PathParam("userId") Integer userId,
            @PathParam("friendId") Integer friendId,
            @PathParam("status") UserFriendStatus status) {
        return friendService.updateFriendship(userId, friendId, status);
    }

    @GET
    @Path("/{userId}/media/{mediaId}")
    public UserMedia getMedia(@PathParam("userId") Integer userId, @PathParam("mediaId") Integer mediaId) {
        return mediaService.getRepository().findUserMedia(userId, mediaId);
    }

    @POST
    @Path("/{userId}/media")
    public Integer addMedia(UserMedia media) {
        return mediaService.create(media);
    }

    @PUT
    @Path("/{userId}/media")
    public Integer updateMedia(UserMedia media) {
        return mediaService.update(media);
    }

}
