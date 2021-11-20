package com.lkrfnr.cinephile.repository

import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditBase
import com.lkrfnr.cinephile.network.services.movie.MovieCreditService
import javax.inject.Inject

class MovieCreditRepository @Inject constructor(
    private val movieCreditService: MovieCreditService
) {

    suspend fun getMovieCredit(movieId : String) : MovieCreditBase {
        val response = movieCreditService.getMovieCredits(movieId = movieId)
        return response.body() as MovieCreditBase
    }

}