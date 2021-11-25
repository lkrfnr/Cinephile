package com.lkrfnr.cinephile.viewmodel.state

import com.lkrfnr.cinephile.network.model.common.MovieResult

data class HomeUpcomingState(
    val upcomingMovies : List<MovieResult>? = ArrayList()
)