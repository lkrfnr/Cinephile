package com.lkrfnr.cinephile.viewmodel.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditCast
import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditCrew

data class MovieCreditState(
    val movieId : String? = "",
    val castList : List<MovieCreditCast>? = ArrayList(),
    val crewList : List<MovieCreditCrew>? = ArrayList()
)