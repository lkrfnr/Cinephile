package com.lkrfnr.cinephile.viewmodel.state

import com.lkrfnr.cinephile.network.model.common.MovieResult

sealed class HomeUpcomingState : BaseState() {
    class Loading(val message: String = "Loading..") : HomeUpcomingState()
    class Success(val upcomingMovies: List<MovieResult> = ArrayList()) : HomeUpcomingState()
    class Error(val errorMessage: String = "Loading..") : HomeUpcomingState()
}