package com.lkrfnr.cinephileapp.network.services

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DiscoverService {

    @GET("discover/movie")
    suspend fun discoverMovies(@Query("api_key") apiKey : String,
                               @Query("language") language : String,
                               @Query("page") page : Int,
                               @Query("sort_by") sortBy : String,
                               @Query("include_adult") includeAdult : Boolean,
                               @Query("include_video") includeVideo : Boolean,
                               @Query("with_watch_monetization_types") monetizationType : String
    ) :Response<DiscoverService>

}