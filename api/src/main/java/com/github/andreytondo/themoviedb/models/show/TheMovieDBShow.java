package com.github.andreytondo.themoviedb.models.show;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TheMovieDBShow {

    private Integer id;
    private boolean adult;
    private String name;
    private String first_air_date;
    private List<TheMovieDBSeason> seasons;
    private String overview;
    private String poster_path;
    private String backdrop_path;
}
