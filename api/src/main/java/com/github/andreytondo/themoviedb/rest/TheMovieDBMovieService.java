package com.github.andreytondo.themoviedb.rest;

import com.github.andreytondo.themoviedb.models.movie.TheMovieDBMovie;
import com.github.andreytondo.themoviedb.models.search.TheMovieDBSearchResponse;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.wildfly.common.annotation.NotNull;

@RegisterRestClient(configKey = "tmdb-api")
@Consumes("application/json")
@Produces("application/json")
@ClientHeaderParam(name = "Authorization", value = "Bearer ${tmdb-api.key}")
public interface TheMovieDBMovieService {

    @GET
    @Path("/search/movie")
    TheMovieDBSearchResponse<TheMovieDBMovie> search(
            @NotNull @QueryParam("query") String query,
            @QueryParam("include_adult") boolean includeAdult,
            @QueryParam("language") String language,
            @QueryParam("page") Integer page);

    @GET
    @Path("/movie/{movieId}")
    TheMovieDBMovie get(@PathParam("movieId") Integer movieId, @QueryParam("language") String language);

}
