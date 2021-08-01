package com.lkrfnr.cinephileapp.network.services.movie

import com.lkrfnr.cinephileapp.R
import com.lkrfnr.cinephileapp.network.model.movie.moviedetail.MovieDetailBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailService {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: String,
                               @Query("api_key") apiKey : String,
                               @Query("language") language : String,
                               @Query("page") page : Int) : Response<MovieDetailBase>
}