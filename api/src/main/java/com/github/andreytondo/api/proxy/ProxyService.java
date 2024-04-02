package com.github.andreytondo.api.proxy;

import com.github.andreytondo.api.movie.Movie;
import com.github.andreytondo.api.movie.MovieAdapter;
import com.github.andreytondo.api.show.Show;
import com.github.andreytondo.api.show.ShowAdapter;
import com.github.andreytondo.themoviedb.models.movie.TheMovieDBMovie;
import com.github.andreytondo.themoviedb.models.search.TheMovieDBSearchRequest;
import com.github.andreytondo.themoviedb.models.search.TheMovieDBSearchResponse;
import com.github.andreytondo.themoviedb.models.show.TheMovieDBShow;
import com.github.andreytondo.themoviedb.rest.TheMovieDBMovieService;
import com.github.andreytondo.themoviedb.rest.TheMovieDBShowService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import java.util.List;

@RequestScoped
public class ProxyService {

    @Inject
    MovieAdapter movieAdapter;

    @Inject
    ShowAdapter showAdapter;

    @RestClient
    TheMovieDBMovieService theMovieDBMovieService;

    @RestClient
    TheMovieDBShowService theMovieDBShowService;

    public List<Movie> searchMovies(TheMovieDBSearchRequest request) {
        TheMovieDBSearchResponse<TheMovieDBMovie> movies = theMovieDBMovieService
                .search(request.getQuery(), request.isInclude_adult(), request.getLanguege(), request.getPage());
        return movieAdapter.adaptResponse(movies);
    }

    public Movie getMovie(Integer movie_id, String language) {
        TheMovieDBMovie movie = theMovieDBMovieService.get(movie_id, language);
        return movieAdapter.adapt(movie);
    }

    public List<Show> searchShows(TheMovieDBSearchRequest request) {
        TheMovieDBSearchResponse<TheMovieDBShow> movies = theMovieDBShowService
                .search(request.getQuery(), request.isInclude_adult(), request.getLanguege(), request.getPage());
        return showAdapter.adaptResponse(movies);
    }

    public Show getShow(Integer show_id, String language) {
        TheMovieDBShow show = theMovieDBShowService.get(show_id, language);
        return showAdapter.adapt(show);
    }
}
