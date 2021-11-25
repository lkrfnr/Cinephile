package com.lkrfnr.cinephile.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditBase
import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditCast
import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditCrew
import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailBase
import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailGenre
import com.lkrfnr.cinephile.repository.MovieCreditRepository
import com.lkrfnr.cinephile.repository.MovieDetailRepository
import com.lkrfnr.cinephile.viewmodel.state.MovieCreditState
import com.lkrfnr.cinephile.viewmodel.state.MovieDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository,
    private val movieCreditRepository: MovieCreditRepository
) : ViewModel() {

    private val TAG: String = "MovieDetailViewModel"

    val movieDetailState : MutableState<MovieDetailState> = mutableStateOf(MovieDetailState())
    val movieCreditState : MutableState<MovieCreditState> = mutableStateOf(MovieCreditState())

    private val _movieDetailStateList : MutableList<MovieDetailState> = ArrayList()
    private val _movieCreditStateList : MutableList<MovieCreditState> = ArrayList()

    fun getMovieDetail(movieId : String) {

        Log.i(TAG, "Will fetch movie id : $movieId")
        val cachedMovieDetailState : MovieDetailState? = _movieDetailStateList.find { _movieDetailState -> _movieDetailState.movieId == movieId }

        cachedMovieDetailState?.let {
            Log.i(TAG, "In cached ! ${it.movieId}")
            movieDetailState.value = it
            return
        }

        viewModelScope.launch(Dispatchers.IO) {
            Log.i(TAG, "In net request ! $movieId")
            val movieDetail : MovieDetailBase = movieDetailRepository.getMovieDetail(movieId = movieId)

            movieDetail.let {
                val newMovieDetailState = MovieDetailState(
                    it.id.toString(),
                    it.posterPath,
                    it.originalTitle,
                    it.overview,
                    it.releaseDate,
                    it.runtime.toString(),
                    it.genres
                )
                _movieDetailStateList.add(newMovieDetailState)
                movieDetailState.value = newMovieDetailState
            }
        }


    }

    fun getMovieCredit(movieId : String) {

        val cachedMovieCreditState : MovieCreditState? = _movieCreditStateList.find { _movieCreditState -> _movieCreditState.movieId == movieId }

        cachedMovieCreditState?.let {
            movieCreditState.value = it
            return
        }

        viewModelScope.launch(Dispatchers.IO ){

            val movieCredit : MovieCreditBase = movieCreditRepository.getMovieCredit(movieId = movieId)

            movieCredit.let {
                val newMovieCreditState = MovieCreditState(
                    it.id.toString(),
                    it.movieCreditCast,
                    it.movieCreditCrew
                )
                _movieCreditStateList.add(newMovieCreditState)
                movieCreditState.value = newMovieCreditState
            }

        }

    }


}