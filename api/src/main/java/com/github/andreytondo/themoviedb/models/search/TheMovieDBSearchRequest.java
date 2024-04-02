package com.github.andreytondo.themoviedb.models.search;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheMovieDBSearchRequest {

    private String query;
    private boolean include_adult = true;
    private String languege = "pt-BR";
    private Integer page = 1;
}
