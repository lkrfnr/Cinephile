package com.lkrfnr.cinephile.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lkrfnr.cinephile.data.SharedPreferencesManager
import com.lkrfnr.cinephile.network.RetrofitClient
import com.lkrfnr.cinephile.network.model.common.MovieBase
import com.lkrfnr.cinephile.network.services.movie.MovieDetailService
import com.lkrfnr.cinephile.network.services.movie.MoviePopularService
import retrofit2.Retrofit
import java.lang.reflect.Type

class MoviePopularRepository {

    private val tag: String = "MoviePopularRepository"
    private val movieBaseType: Type? = object : TypeToken<MovieBase>() {}.type
    private val retrofitClient: Retrofit = RetrofitClient.getRetrofitInstance()
    private val popularMoviesService: MoviePopularService = retrofitClient.create(
        MoviePopularService::class.java
    )
    private val movieDetailService: MovieDetailService = retrofitClient.create(
        MovieDetailService::class.java
    )


    suspend fun getPopularMovies(page: Int): MovieBase? {

        val firstPageResultJson: String? = SharedPreferencesManager.getFirstPageResultJson()

        val response: MovieBase? = if (firstPageResultJson == null || firstPageResultJson == "") {
            Log.i(tag, "API Requested !")
            requestAndSaveResult(page)
        } else {
            Log.i(tag, "From cache !")
            Gson().fromJson(firstPageResultJson, movieBaseType)
        }

        return response
    }

    suspend fun getMovieDetail(movieId: String, pageNum: Int): MovieBase {
        val response = movieDetailService.getMovieDetail(
            movieId,
            "71ce169c384af73b056e8a587f006b3a",
            "en-US",
            pageNum
        )

        return response.body() as MovieBase
    }

    private suspend fun requestAndSaveResult(pageNum: Int): MovieBase {

        val response = popularMoviesService
            .getPopularMovies(
                "71ce169c384af73b056e8a587f006b3a",
                "en-US",
                pageNum
            )

        val firstPageResultJson = Gson().toJson(response.body(), movieBaseType)
        SharedPreferencesManager.saveFirstPageResultJson(firstPageResultJson)

        return response.body() as MovieBase
    }

}