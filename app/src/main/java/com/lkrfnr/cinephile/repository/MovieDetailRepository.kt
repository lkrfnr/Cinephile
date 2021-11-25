package com.lkrfnr.cinephile.repository

import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailBase
import com.lkrfnr.cinephile.network.services.movie.MovieDetailService
import javax.inject.Inject

class MovieDetailRepository @Inject constructor(
    private val movieDetailService: MovieDetailService
) {

    suspend fun getMovieDetail(movieId: String): MovieDetailBase {
        val response = movieDetailService.getMovieDetail(movieId = movieId)
        return response.body() as MovieDetailBase
    }

}