package com.github.andreytondo.api.enums;

import lombok.Getter;

@Getter
public enum MediaStatus {

    WATCHED("Watched"),
    WATCHING("Watching"),
    PLANNED("Planned"),
    DROPPED("Dropped");

    private final String description;

    MediaStatus(String description) {
        this.description = description;
    }
}
