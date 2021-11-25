package com.lkrfnr.cinephile.network.services

import android.content.res.Resources
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.util.apiKeyStr
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverService {

    @GET("discover/movie")
    suspend fun discoverMovies(@Query("api_key") apiKey : String = apiKeyStr,
                               @Query("language") language : String = "en-US",
                               @Query("page") page : Int = 1,
                               @Query("sort_by") sortBy : String,
                               @Query("include_adult") includeAdult : Boolean = false,
                               @Query("include_video") includeVideo : Boolean = true,
                               @Query("with_watch_monetization_types") monetizationType : String = "flatrate"
    ) :Response<DiscoverService>

}