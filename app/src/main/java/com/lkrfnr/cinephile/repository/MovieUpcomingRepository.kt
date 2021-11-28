package com.lkrfnr.cinephile.repository

import android.util.Log
import com.lkrfnr.cinephile.network.model.common.MovieBase
import com.lkrfnr.cinephile.network.services.movie.MovieUpcomingService
import retrofit2.Response
import javax.inject.Inject

class MovieUpcomingRepository @Inject constructor(
    private val movieUpcomingService: MovieUpcomingService
) {

    private val tag: String = "MovieUpcomingRepository"

    suspend fun getUpcomingMovies(page: Int = 1): MovieBase? {

        val upcomingBaseResponse: Response<MovieBase> =
            movieUpcomingService.getUpcomingMovies(
                page = page
            )


        Log.i(tag, "Request Finished !")

        return upcomingBaseResponse.body()

    }

}