package com.lkrfnr.cinephile.network.services

import com.lkrfnr.cinephile.network.model.search.SearchMovieBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchMovieService {

    @GET("search/movie")
    suspend fun searchMovie(@Query("api_key") apiKey : String,
                            @Query("language") language : String = "en-US",
                            @Query("query") query : String,
                            @Query("page") page : Int = 1,
                            @Query("include_adult") includeAdult : Boolean = false
    ) : Response<SearchMovieBase>



}