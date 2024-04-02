package com.github.andreytondo.themoviedb.models.search;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TheMovieDBSearchResponse<T> {

    private Integer page;
    private Integer total_pages;
    private Integer total_results;
    private List<T> results;
}
