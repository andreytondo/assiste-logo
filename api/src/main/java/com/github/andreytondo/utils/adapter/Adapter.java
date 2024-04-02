package com.github.andreytondo.utils.adapter;

import com.github.andreytondo.themoviedb.models.search.TheMovieDBSearchResponse;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
public abstract class Adapter<T, K> {

    public static LocalDate parseDate(String date) {
        if (date == null || date.isBlank()) return null;
        return LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }

    public List<T> adaptResponse(TheMovieDBSearchResponse<K> results) {
        if (results == null || results.getResults() == null) return List.of();

        return results.getResults().stream()
                .map(this::adapt)
                .collect(Collectors.toList());
    }

    public List<T> adaptObjects(List<K> objects) {
        if (objects == null) return List.of();

        return objects.stream()
                .map(this::adapt)
                .collect(Collectors.toList());
    }

    public abstract T adapt(K external);

}
