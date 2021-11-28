package com.lkrfnr.cinephile.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lkrfnr.cinephile.network.model.common.MovieBase
import com.lkrfnr.cinephile.network.model.common.MovieResult
import com.lkrfnr.cinephile.repository.MoviePopularRepository
import com.lkrfnr.cinephile.repository.MovieUpcomingRepository
import com.lkrfnr.cinephile.viewmodel.state.HomePopularState
import com.lkrfnr.cinephile.viewmodel.state.HomeUpcomingState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val moviePopularRepository: MoviePopularRepository,
    private val movieUpcomingRepository: MovieUpcomingRepository,
) : ViewModel() {

    private val TAG: String = "HomeViewModel"

    private var _homePopularState: MutableStateFlow<HomePopularState> =
        MutableStateFlow(HomePopularState.Loading())
    val homePopularState: StateFlow<HomePopularState> = _homePopularState

    private var _homeUpcomingState: MutableStateFlow<HomeUpcomingState> =
        MutableStateFlow(HomeUpcomingState.Loading())
    val homeUpcomingState: StateFlow<HomeUpcomingState> = _homeUpcomingState

    init {
        getPopularMovies()
        getUpcomingMovies()
    }

    private fun getPopularMovies(pageNum: Int = 1) {

        _homePopularState.update {
            HomePopularState.Loading()
        }

        viewModelScope.launch(Dispatchers.IO) {

            val popularMovieResults: MutableList<MovieResult> = ArrayList()

            try {
                val moviePopularBase: MovieBase? = moviePopularRepository.getPopularMovies(pageNum)
                for (m in moviePopularBase?.results!!) {
                    popularMovieResults.add(m)
                }
            } catch (e: Exception) {
                e.printStackTrace()

                _homePopularState.update {
                    HomePopularState.Error("Ups!, Error message : ${e.localizedMessage}")
                }
            }


            _homePopularState.update {
                HomePopularState.Success(
                    popularMovies = popularMovieResults
                )
            }


            val value = homePopularState.value as HomePopularState.Success

            Log.i(TAG, "${value.popularMovies.size}")


        }

    }

    private fun getUpcomingMovies(pageNum: Int = 1) {

        _homeUpcomingState.update {
            HomeUpcomingState.Loading()
        }

        viewModelScope.launch(Dispatchers.IO) {

            val upcomingMovieResults: MutableList<MovieResult> = ArrayList()

            try {
                val movieUpcomingBase: MovieBase? =
                    movieUpcomingRepository.getUpcomingMovies(pageNum)
                for (m in movieUpcomingBase?.results!!) {
                    upcomingMovieResults.add(m)
                }
            } catch (e: Exception) {
                e.printStackTrace()

                _homeUpcomingState.update {
                    HomeUpcomingState.Error()
                }
            }

            Log.i(TAG, "Data fetched, length of movies list : ${upcomingMovieResults.size}")

            _homeUpcomingState.update {
                HomeUpcomingState.Success(
                    upcomingMovies = upcomingMovieResults
                )
            }

            val value = homeUpcomingState.value as HomeUpcomingState.Success

            Log.i(TAG, "${value.upcomingMovies.size}")

        }

    }
}