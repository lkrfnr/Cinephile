package com.lkrfnr.cinephile.repository

import com.lkrfnr.cinephile.network.RetrofitClient
import com.lkrfnr.cinephile.network.model.common.MovieBase
import com.lkrfnr.cinephile.network.services.SearchMovieService
import retrofit2.Retrofit

class SearchMovieRepository {

    private val tag: String = "SearchMovieRepository"
    private val retrofitClient : Retrofit = RetrofitClient.getRetrofitInstance()
    private val popularMoviesService : SearchMovieService = retrofitClient.create(SearchMovieService::class.java)

    suspend fun searchMovie(queryStr : String, pageNum: Int): MovieBase?{

        val response = popularMoviesService
                .searchMovie(apiKey = "71ce169c384af73b056e8a587f006b3a", query = queryStr, page = pageNum)

        return response.body()
    }

}