package com.lkrfnr.cinephile.repository

import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailBase
import com.lkrfnr.cinephile.network.services.movie.MovieDetailService
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(
    private val movieDetailService: MovieDetailService
) {

    suspend fun getMovieDetail(movieId: String): MovieDetailBase {
        val response = movieDetailService.getMovieDetail(movieId = movieId,
        apiKey = "71ce169c384af73b056e8a587f006b3a",
        language = "en-US")

        return response.body() as MovieDetailBase
    }

}