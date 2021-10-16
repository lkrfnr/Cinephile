package com.lkrfnr.cinephile.repository

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.lkrfnr.cinephile.data.SharedPreferencesManager
import com.lkrfnr.cinephile.data.firstPageResultKey
import com.lkrfnr.cinephile.network.RetrofitClient
import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailBase
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephile.network.services.movie.MovieDetailService
import com.lkrfnr.cinephile.network.services.movie.MoviePopularService
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.Exception
import java.lang.reflect.Type

class MoviePopularRepository{

    private val tag: String = "MoviePopularRepository"
    private val moviePopularBaseType: Type? = object : TypeToken<MoviePopularBase>(){}.type
    private val movieDetailBaseType: Type? = object : TypeToken<MovieDetailBase>(){}.type
    private val retrofitClient : Retrofit = RetrofitClient.getRetrofitInstance()
    private val popularMoviesService : MoviePopularService = retrofitClient.create(
        MoviePopularService::class.java)
    private val movieDetailService : MovieDetailService = retrofitClient.create(
        MovieDetailService::class.java)


    suspend fun getPopularMovies(page: Int): MoviePopularBase?{

        val firstPageResultJson:String? = SharedPreferencesManager.getFirstPageResultJson()

        val response: MoviePopularBase? = if (firstPageResultJson == null || firstPageResultJson == ""){
            Log.i(tag, "API Requested !" )
            requestAndSaveResult(page)
        }else{
            Log.i(tag, "From cache !" )
            Gson().fromJson(firstPageResultJson, moviePopularBaseType)
        }

        return response
    }

    suspend fun getMovieDetail(movieId : String, pageNum: Int) : MovieDetailBase {
        val response = movieDetailService.getMovieDetail(
             movieId,
            "71ce169c384af73b056e8a587f006b3a",
            "en-US",
             pageNum)

        return response.body() as MovieDetailBase
    }

    private suspend fun requestAndSaveResult(pageNum:Int):MoviePopularBase {

        val response = popularMoviesService
            .getPopularMovies(
                "71ce169c384af73b056e8a587f006b3a",
                "en-US",
                pageNum)

        val firstPageResultJson = Gson().toJson(response.body(), moviePopularBaseType)
        SharedPreferencesManager.saveFirstPageResultJson(firstPageResultJson)

        return response.body() as MoviePopularBase
    }

}