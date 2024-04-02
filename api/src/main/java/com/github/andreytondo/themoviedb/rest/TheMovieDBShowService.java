package com.github.andreytondo.themoviedb.rest;

import com.github.andreytondo.themoviedb.models.search.TheMovieDBSearchResponse;
import com.github.andreytondo.themoviedb.models.show.TheMovieDBShow;
import jakarta.ws.rs.*;
import org.eclipse.microprofile.rest.client.annotation.ClientHeaderParam;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import org.wildfly.common.annotation.NotNull;

@RegisterRestClient(configKey = "tmdb-api")
@Consumes("application/json")
@Produces("application/json")
@ClientHeaderParam(name = "Authorization", value = "Bearer ${tmdb-api.key}")
public interface TheMovieDBShowService {

    @GET
    @Path("/search/tv")
    TheMovieDBSearchResponse<TheMovieDBShow> search(
            @NotNull @QueryParam("query") String query,
            @QueryParam("include_adult") boolean includeAdult,
            @QueryParam("language") String language,
            @QueryParam("page") Integer page);

    @GET
    @Path("/tv/{showId}")
    TheMovieDBShow get(@PathParam("showId") Integer showId, @QueryParam("language") String language);
}
