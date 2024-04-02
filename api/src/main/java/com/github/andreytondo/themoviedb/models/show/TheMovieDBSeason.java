package com.github.andreytondo.themoviedb.models.show;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TheMovieDBSeason {

    private Integer id;
    private Integer episode_count;
    private String air_date;
    private String name;
}
