package com.lkrfnr.cinephile.viewmodel.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailGenre

data class MovieDetailState(
    val movieId : String? = "",
    val posterUrl : String? = "",
    val originalTitle : String? = "",
    val overview : String? = "",
    val releaseDate : String? = "",
    val runtime : String? = "",
    val genres : List<MovieDetailGenre>? = ArrayList()
)