package com.lkrfnr.cinephile.viewmodel.state

import com.lkrfnr.cinephile.network.model.common.MovieResult

sealed class SearchState : BaseState() {
    val searchState: MutableList<MovieResult> = ArrayList()
}
