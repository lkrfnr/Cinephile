package com.lkrfnr.cinephile.viewmodel.state

import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditCast
import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditCrew

sealed class MovieCreditState : BaseState() {
    class Loading(val message: String = "Loading..") : MovieCreditState()
    class Success(
        val movieId: String = "",
        val castList: List<MovieCreditCast>? = ArrayList(),
        val crewList: List<MovieCreditCrew>? = ArrayList()
    ) : MovieCreditState()

    class Error(val message: String = "Something went wrong") : MovieCreditState()
}