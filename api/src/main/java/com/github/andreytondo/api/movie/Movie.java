package com.github.andreytondo.api.movie;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Movie {

    private Integer id;
    private String name;
    private boolean adult;
    private String cover;
    private String description;
    private Integer runtime;
    private LocalDate releaseDate;
    private String backdrop;
}
