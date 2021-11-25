package com.lkrfnr.cinephile.network.services.movie


import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditBase
import com.lkrfnr.cinephile.util.apiKeyStr
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieCreditService {

    @GET("movie/{movie_id}")
    suspend fun getMovieCredits(
        @Path("movie_id") movieId : String,
        @Query("api_key") apiKey : String = apiKeyStr,
        @Query("language") language : String = "en-US"
    ) : Response<MovieCreditBase>
}