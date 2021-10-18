package com.lkrfnr.cinephile.repository

import android.content.res.Resources
import com.google.gson.reflect.TypeToken
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.network.RetrofitClient
import com.lkrfnr.cinephile.network.model.common.MovieBase
import com.lkrfnr.cinephile.network.model.upcoming.MovieUpcomingBase
import com.lkrfnr.cinephile.network.services.movie.MovieUpcomingService
import retrofit2.Response
import retrofit2.Retrofit
import java.lang.reflect.Type

class MovieUpcomingRepository {

    private val tag: String = "MoviePopularRepository"
    private val retrofitClient : Retrofit = RetrofitClient.getRetrofitInstance()
    private val movieUpcomingService : MovieUpcomingService = retrofitClient.create(
        MovieUpcomingService::class.java)

    suspend fun getUpcomingMovies(page: Int = 1): MovieBase? {

        val upcomingBaseResponse: Response<MovieBase> =
            movieUpcomingService.getUpcomingMovies(
                apiKey = "71ce169c384af73b056e8a587f006b3a",
                page = page,
                language = "en-US"
            )

        return upcomingBaseResponse.body()

    }

}