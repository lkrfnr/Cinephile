package com.lkrfnr.cinephileapp.network.services.movie

import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviePopularService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey : String,
                                @Query("language") language : String,
                                 @Query("page") page : Int) : Response<MoviePopularBase>

}