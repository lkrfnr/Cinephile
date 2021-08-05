package com.lkrfnr.cinephileapp.repository

import android.util.Log
import com.lkrfnr.cinephileapp.network.RetrofitClient
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephileapp.network.services.movie.MoviePopularService
import com.lkrfnr.cinephileapp.persistance.LocalDatabase
import retrofit2.Retrofit

class MoviePopularRepository(private var db: LocalDatabase) {

    private val tag: String? = "MoviePopularRepository"
    private val retrofitClient : Retrofit = RetrofitClient.getRetrofitInstance()
    private val popularMoviesService : MoviePopularService = retrofitClient.create(MoviePopularService::class.java)

    suspend fun getPopularMovies():MoviePopularBase?{

        val response = popularMoviesService
                .getPopularMovies(
                        "71ce169c384af73b056e8a587f006b3a",
                        "en-US",
                        1)

        if(response.isSuccessful){
            return response.body()
        }else{
            Log.e(tag, "API Error !")
        }

        return null
    }

}