package com.github.andreytondo.api.show.season;

import com.github.andreytondo.themoviedb.models.show.TheMovieDBSeason;
import com.github.andreytondo.utils.adapter.Adapter;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class TheMovieDBSeasonAdapter extends Adapter<Season, TheMovieDBSeason> {

    public Season adapt(TheMovieDBSeason external) {
        return Season.builder()
                .id(external.getId())
                .episodes(external.getEpisode_count())
                .aired(parseDate(external.getAir_date()))
                .name(external.getName())
                .build();
    }
}
