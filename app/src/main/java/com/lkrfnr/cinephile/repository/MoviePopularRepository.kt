package com.lkrfnr.cinephile.repository

import android.util.Log
import com.lkrfnr.cinephile.network.RetrofitClient
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephile.network.services.movie.MoviePopularService
import retrofit2.Retrofit

class MoviePopularRepository{

    private val tag: String = "MoviePopularRepository"
    private val retrofitClient : Retrofit = RetrofitClient.getRetrofitInstance()
    private val popularMoviesService : MoviePopularService = retrofitClient.create(
        MoviePopularService::class.java)

    suspend fun getPopularMovies(page: Int): MoviePopularBase?{

        val response = popularMoviesService
                .getPopularMovies(
                        "71ce169c384af73b056e8a587f006b3a",
                        "en-US",
                        page)

        if(response.isSuccessful){
            return response.body()
        }else{
            Log.e(tag, "API Error !")
        }

        return null
    }

}