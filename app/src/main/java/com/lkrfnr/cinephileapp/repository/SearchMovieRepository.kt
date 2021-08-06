package com.lkrfnr.cinephileapp.repository

import android.util.Log
import com.lkrfnr.cinephileapp.network.RetrofitClient
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephileapp.network.model.search.SearchMovieBase
import com.lkrfnr.cinephileapp.network.services.SearchMovieService
import com.lkrfnr.cinephileapp.network.services.movie.MoviePopularService
import retrofit2.Retrofit

class SearchMovieRepository {

    private val tag: String = "SearchMovieRepository"
    private val retrofitClient : Retrofit = RetrofitClient.getRetrofitInstance()
    private val popularMoviesService : SearchMovieService = retrofitClient.create(SearchMovieService::class.java)

    suspend fun searchMovie(queryStr : String): SearchMovieBase?{

        val response = popularMoviesService
                .searchMovie(apiKey = "71ce169c384af73b056e8a587f006b3a", query = queryStr)

        if(response.isSuccessful){
            return response.body()
        }else{
            Log.e(tag, "API Error !")
        }

        return null
    }

}