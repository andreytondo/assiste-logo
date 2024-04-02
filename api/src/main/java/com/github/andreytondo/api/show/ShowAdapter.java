package com.github.andreytondo.api.show;

import com.github.andreytondo.api.show.season.TheMovieDBSeasonAdapter;
import com.github.andreytondo.themoviedb.models.show.TheMovieDBShow;
import com.github.andreytondo.utils.adapter.Adapter;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class ShowAdapter extends Adapter<Show, TheMovieDBShow> {

    public Show adapt(TheMovieDBShow external) {
        return Show.builder()
                .id(external.getId())
                .name(external.getName())
                .description(external.getOverview())
                .cover(external.getPoster_path())
                .adult(external.isAdult())
                .releaseDate(parseDate(external.getFirst_air_date()))
                .seasons(new TheMovieDBSeasonAdapter().adaptObjects(external.getSeasons()))
                .backdrop(external.getBackdrop_path())
                .build();
    }
}
