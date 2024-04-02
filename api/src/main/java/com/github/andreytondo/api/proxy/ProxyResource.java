package com.github.andreytondo.api.proxy;

import com.github.andreytondo.api.movie.Movie;
import com.github.andreytondo.api.show.Show;
import com.github.andreytondo.themoviedb.models.search.TheMovieDBSearchRequest;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;

import java.util.List;

@Path("/v1/proxy")
public class ProxyResource {

    @Inject
    ProxyService service;

    @POST
    @Path("/search/movie")
    public List<Movie> searchMovies(TheMovieDBSearchRequest request) {
        return service.searchMovies(request);
    }

    @POST
    @Path("/search/show")
    public List<Show> searchShows(TheMovieDBSearchRequest request) {
        return service.searchShows(request);
    }

    @GET
    @Path("/details/movie")
    public Movie getMovie(@QueryParam("externalId") Integer externalId, @QueryParam("language") String language) {
        return service.getMovie(externalId, language);
    }

    @GET
    @Path("/details/show")
    public Show getShow(@QueryParam("externalId") Integer externalId, @QueryParam("language") @DefaultValue("pt-BR") String language) {
        return service.getShow(externalId, language);
    }
}
