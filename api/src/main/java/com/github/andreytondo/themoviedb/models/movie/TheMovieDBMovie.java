package com.github.andreytondo.themoviedb.models.movie;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheMovieDBMovie {

    private Integer id;
    private boolean adult;
    private String title;
    private String poster_path;
    private String overview;
    private Integer runtime;
    private String release_date;
    private String backdrop_path;
}
