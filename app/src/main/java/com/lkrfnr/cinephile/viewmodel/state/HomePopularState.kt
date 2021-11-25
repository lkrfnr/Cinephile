package com.lkrfnr.cinephile.viewmodel.state

import com.lkrfnr.cinephile.network.model.common.MovieResult

data class HomePopularState(
    val popularMovies : List<MovieResult>? = ArrayList()
)