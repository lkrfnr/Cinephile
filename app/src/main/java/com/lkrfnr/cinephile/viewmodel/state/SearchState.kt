package com.lkrfnr.cinephile.viewmodel.state

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.lkrfnr.cinephile.network.model.common.MovieResult

data class SearchState(
    val searchState: MutableList<MovieResult>? = ArrayList()
)
