package com.lkrfnr.cinephile.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditBase
import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailBase
import com.lkrfnr.cinephile.repository.MovieCreditRepository
import com.lkrfnr.cinephile.repository.MovieDetailRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository,
    private val movieCreditRepository: MovieCreditRepository
) : ViewModel() {

    private val tag: String = "MovieDetailViewModel"

    val movieDetailState : MutableState<List<MovieDetailBase>> = mutableStateOf(listOf())
    val movieCreditState : MutableState<List<MovieCreditBase>> = mutableStateOf(listOf())

    private val _movieDetailBaseList : MutableList<MovieDetailBase> = ArrayList()
    private val _movieCreditBaseList : MutableList<MovieCreditBase> = ArrayList()

    suspend fun getMovieDetail(movieId : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val movieDetailBase : MovieDetailBase = movieDetailRepository.getMovieDetail(movieId = movieId)
            _movieDetailBaseList.add(movieDetailBase)
            movieDetailState.value = _movieDetailBaseList
        }
    }

    suspend fun getMovieCredit(movieId : String) {
        viewModelScope.launch(Dispatchers.IO) {
            val movieCreditBase : MovieCreditBase = movieCreditRepository.getMovieCredit(movieId = movieId)
            _movieCreditBaseList.add(movieCreditBase)
            movieCreditState.value = _movieCreditBaseList
        }
    }


}