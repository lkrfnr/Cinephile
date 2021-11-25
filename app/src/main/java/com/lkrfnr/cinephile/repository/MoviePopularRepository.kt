package com.lkrfnr.cinephile.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lkrfnr.cinephile.local.SharedPreferencesManager
import com.lkrfnr.cinephile.network.RetrofitClient
import com.lkrfnr.cinephile.network.model.common.MovieBase
import com.lkrfnr.cinephile.network.services.movie.MovieDetailService
import com.lkrfnr.cinephile.network.services.movie.MoviePopularService
import retrofit2.Retrofit
import java.lang.reflect.Type
import javax.inject.Inject

class MoviePopularRepository @Inject constructor (
    private val popularMoviesService: MoviePopularService,
) {

    private val tag: String = "MoviePopularRepository"
    private val movieBaseType: Type? = object : TypeToken<MovieBase>() {}.type


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

    private suspend fun requestAndSaveResult(pageNum: Int): MovieBase {

        val response = popularMoviesService
            .getPopularMovies(
                page = pageNum
            )

        val firstPageResultJson = Gson().toJson(response.body(), movieBaseType)
        SharedPreferencesManager.saveFirstPageResultJson(firstPageResultJson)

        return response.body() as MovieBase
    }

}