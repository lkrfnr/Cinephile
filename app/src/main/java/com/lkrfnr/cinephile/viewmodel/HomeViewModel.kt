package com.lkrfnr.cinephile.viewmodel

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
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
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class HomeViewModel @Inject constructor(
    private val moviePopularRepository: MoviePopularRepository,
    private val movieUpcomingRepository: MovieUpcomingRepository,
) : ViewModel() {

    private val tag: String = "HomeViewModel"

    val homePopularState : MutableState<HomePopularState> = mutableStateOf(HomePopularState())
    val homeUpcomingState : MutableState<HomeUpcomingState> = mutableStateOf(HomeUpcomingState())

    init {
        getPopularMovies()
        getUpcomingMovies()
    }

    private fun getPopularMovies(pageNum: Int = 1) {

        viewModelScope.launch(Dispatchers.IO) {
            Log.i(tag, "In getPopularMovies ")

            val popularMovieResults : MutableList<MovieResult> = ArrayList()

            try {
                val moviePopularBase: MovieBase? = moviePopularRepository.getPopularMovies(pageNum)
                for (m in moviePopularBase?.results!!) {
                    popularMovieResults.add(m)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            homePopularState.value = HomePopularState(popularMovieResults)

        }

    }

    private fun getUpcomingMovies(pageNum: Int = 1) {

        viewModelScope.launch(Dispatchers.IO) {
            Log.i(tag, "In getPopularMovies ")

            val upcomingMovieResults : MutableList<MovieResult> = ArrayList()

            try {
                val movieUpcomingBase: MovieBase? =
                    movieUpcomingRepository.getUpcomingMovies(pageNum)
                for (m in movieUpcomingBase?.results!!) {
                    upcomingMovieResults.add(m)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            homeUpcomingState.value = HomeUpcomingState(upcomingMovieResults)

        }

    }
}