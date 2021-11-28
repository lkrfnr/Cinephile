package com.lkrfnr.cinephile.viewmodel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lkrfnr.cinephile.common.movieIdKey
import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditBase
import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailBase
import com.lkrfnr.cinephile.repository.MovieCreditRepository
import com.lkrfnr.cinephile.repository.MovieDetailRepository
import com.lkrfnr.cinephile.viewmodel.state.MovieCreditState
import com.lkrfnr.cinephile.viewmodel.state.MovieDetailState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MovieDetailViewModel @Inject constructor(
    private val movieDetailRepository: MovieDetailRepository,
    private val movieCreditRepository: MovieCreditRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val TAG: String = "MovieDetailViewModel"

    private val _movieDetailUiState: MutableStateFlow<MovieDetailState> =
        MutableStateFlow(MovieDetailState.Loading())
    val movieDetailUiState: StateFlow<MovieDetailState> = _movieDetailUiState

    private val _movieCreditUiState: MutableStateFlow<MovieCreditState> =
        MutableStateFlow(MovieCreditState.Loading())
    val movieCreditUiState: StateFlow<MovieCreditState> = _movieCreditUiState


    init {
        savedStateHandle.get<String>(movieIdKey)?.let {
            getMovieDetail(movieId = it)
            getMovieCredit(movieId = it)
        }
    }

    private fun getMovieDetail(movieId: String) {

        _movieDetailUiState.update {
            MovieDetailState.Loading()
        }

        viewModelScope.launch {

            val movieDetail: MovieDetailBase =
                movieDetailRepository.getMovieDetail(movieId = movieId)

            movieDetail.let {
                val newMovieDetailState = MovieDetailState.Success(
                    it.id.toString(),
                    it.posterPath,
                    it.originalTitle,
                    it.overview,
                    it.releaseDate,
                    it.runtime.toString(),
                    it.genres
                )

                Log.i(TAG, "New movie title : ${it.originalTitle}")

                _movieDetailUiState.update {
                    newMovieDetailState
                }
            }
        }
    }

    private fun getMovieCredit(movieId: String) {

        _movieCreditUiState.update {
            MovieCreditState.Loading()
        }

        viewModelScope.launch {

            val movieCredit: MovieCreditBase =
                movieCreditRepository.getMovieCredit(movieId = movieId)



            movieCredit.let {
                val newMovieCreditState = MovieCreditState.Success(
                    it.id.toString(),
                    it.movieCreditCast,
                    it.movieCreditCrew
                )

                _movieCreditUiState.update {
                    newMovieCreditState
                }

            }
        }

    }
}