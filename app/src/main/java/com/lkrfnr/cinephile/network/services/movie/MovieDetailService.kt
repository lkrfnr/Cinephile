package com.lkrfnr.cinephile.network.services.movie

import android.content.res.Resources
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailBase
import com.lkrfnr.cinephile.util.apiKeyStr
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailService {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(
        @Path("movie_id") movieId: String,
        @Query("api_key") apiKey: String = apiKeyStr,
        @Query("language") language: String = "en-US"
    ): Response<MovieDetailBase>
}