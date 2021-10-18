package com.lkrfnr.cinephile.network.services.movie

import android.content.res.Resources
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.network.model.common.MovieBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieDetailService {

    @GET("movie/{movie_id}")
    suspend fun getMovieDetail(@Path("movie_id") movieId: String,
                               @Query("api_key") apiKey : String = Resources.getSystem().getString(R.string.api_key),
                               @Query("language") language : String = "en-US",
                               @Query("page") page : Int = 1) : Response<MovieBase>
}