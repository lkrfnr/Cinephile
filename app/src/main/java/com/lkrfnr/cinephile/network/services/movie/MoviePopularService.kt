package com.lkrfnr.cinephile.network.services.movie

import android.content.res.Resources
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.network.model.common.MovieBase
import com.lkrfnr.cinephile.util.apiKeyStr
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviePopularService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey : String = apiKeyStr,
                                 @Query("language") language : String = "en-US",
                                 @Query("page") page : Int = 1
    ) : Response<MovieBase>

}