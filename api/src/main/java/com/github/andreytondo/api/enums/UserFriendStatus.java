package com.github.andreytondo.api.enums;

import lombok.Getter;

@Getter
public enum UserFriendStatus {

    PENDING("Pending"),
    ACCEPTED("Accepted"),
    REJECTED("Rejected"),
    BLOCKED("Blocked");

    private final String description;

    UserFriendStatus(String description) {
        this.description = description;
    }
}
