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
import com.lkrfnr.cinephile.repository.SearchMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(
    private val moviePopularRepository: MoviePopularRepository = MoviePopularRepository(),
    private val movieUpcomingRepository: MovieUpcomingRepository = MovieUpcomingRepository(),
    private val searchMovieRepository: SearchMovieRepository = SearchMovieRepository(),
) : ViewModel() {

    private val tag: String = "HomeViewModel"


    val popularMoviesState: MutableState<List<MovieResult>> = mutableStateOf(emptyList())
    val upcomingMoviesState: MutableState<List<MovieResult>> = mutableStateOf(emptyList())
    val searchState: MutableState<List<MovieResult>> = mutableStateOf(emptyList())

    private val popularMovies: MutableList<MovieResult> = ArrayList()
    private val upcomingMovies: MutableList<MovieResult> = ArrayList()
    private val searchResults: MutableList<MovieResult> = ArrayList()

    init {
        getPopularMovies()
        getUpcomingMovies()
    }

    fun getPopularMovies(pageNum: Int = 1) {

        viewModelScope.launch(Dispatchers.IO) {
            Log.i(tag, "In getPopularMovies ")
            try {
                val moviePopularBase: MovieBase? = moviePopularRepository.getPopularMovies(pageNum)
                for (m in moviePopularBase?.results!!) {
                    popularMovies.add(m)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            popularMoviesState.value = popularMovies

            Log.i(tag, "movies state length ${popularMoviesState.value.size} ")

        }

    }

    fun getUpcomingMovies(pageNum: Int = 1) {

        viewModelScope.launch(Dispatchers.IO) {
            Log.i(tag, "In getPopularMovies ")
            try {
                val movieUpcomingBase: MovieBase? =
                    movieUpcomingRepository.getUpcomingMovies(pageNum)
                for (m in movieUpcomingBase?.results!!) {
                    upcomingMovies.add(m)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            upcomingMoviesState.value = upcomingMovies

            Log.i(tag, "movies state length ${popularMoviesState.value.size} ")

        }

    }


    fun getSearchResults(queryStr: String, pageNum: Int = 1) {

        viewModelScope.launch(Dispatchers.IO) {
            try {
                val searchMovieBase: MovieBase? =
                    searchMovieRepository.searchMovie(queryStr, pageNum)
                for (m in searchMovieBase?.results!!) {
                    searchResults.add(m)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            searchState.value = searchResults

        }
    }
}