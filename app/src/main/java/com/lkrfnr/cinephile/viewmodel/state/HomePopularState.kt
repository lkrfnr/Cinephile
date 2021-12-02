package com.lkrfnr.cinephile.viewmodel.state

import com.lkrfnr.cinephile.network.model.common.MovieResult

sealed class HomePopularState : BaseState() {
    class Loading(val message: String = "Loading..") : HomePopularState()
    class Success(val popularMovies: List<MovieResult> = ArrayList()) : HomePopularState()
    class Error(val errorMessage: String = "Loading..") : HomePopularState()
}