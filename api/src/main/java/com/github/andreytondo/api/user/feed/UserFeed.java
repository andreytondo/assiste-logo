package com.github.andreytondo.api.user.feed;

import com.github.andreytondo.api.enums.MediaType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserFeed {

    private Integer userId;
    private byte[] userImage;
    private String userName;
    private Integer mediaId;
    private MediaType mediaType;
    private String mediaCover;
    private String mediaName;
    private String mediaReview;
    private Integer mediaRating;
}
