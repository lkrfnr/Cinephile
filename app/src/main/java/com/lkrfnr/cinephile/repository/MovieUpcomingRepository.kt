package com.lkrfnr.cinephile.repository

import com.lkrfnr.cinephile.network.model.common.MovieBase
import com.lkrfnr.cinephile.network.services.movie.MovieUpcomingService
import retrofit2.Response
import javax.inject.Inject

class MovieUpcomingRepository @Inject constructor(
    private val movieUpcomingService: MovieUpcomingService
) {

    private val tag: String = "MoviePopularRepository"

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