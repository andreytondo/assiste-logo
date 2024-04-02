package com.github.andreytondo.api.movie;

import com.github.andreytondo.themoviedb.models.movie.TheMovieDBMovie;
import com.github.andreytondo.utils.adapter.Adapter;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class MovieAdapter extends Adapter<Movie, TheMovieDBMovie> {

    public Movie adapt(TheMovieDBMovie external) {
        return Movie.builder()
                .id(external.getId())
                .name(external.getTitle())
                .description(external.getOverview())
                .cover(external.getPoster_path())
                .adult(external.isAdult())
                .releaseDate(parseDate(external.getRelease_date()))
                .runtime(external.getRuntime())
                .backdrop(external.getBackdrop_path())
                .build();
    }
}
