package com.lkrfnr.cinephile.viewmodel

import android.content.SharedPreferences
import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephile.network.model.search.SearchMovieBase
import com.lkrfnr.cinephile.network.model.search.SearchMovieResult
import com.lkrfnr.cinephile.repository.MoviePopularRepository
import com.lkrfnr.cinephile.repository.SearchMovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(
    private val moviePopularRepository: MoviePopularRepository = MoviePopularRepository(),
    private val searchMovieRepository : SearchMovieRepository = SearchMovieRepository())
    : ViewModel() {

    private val tag : String = "HomeViewModel"


    val moviesState: MutableState<List<MoviePopularResult>> = mutableStateOf(emptyList())
    val searchState: MutableState<List<SearchMovieResult>> = mutableStateOf(emptyList())

    private val movies: MutableList<MoviePopularResult> = ArrayList()
    private val searchResults: MutableList<SearchMovieResult> = ArrayList()

    init {
        getPopularMovies()
    }

    fun getPopularMovies(pageNum: Int = 1){

        viewModelScope.launch(Dispatchers.IO) {
            Log.i(tag, "In getPopularMovies ")
            try {
                val moviePopularBase: MoviePopularBase? = moviePopularRepository.getPopularMovies(pageNum)
                for(  m in moviePopularBase?.results!!){
                    movies.add(m)
                }
            }catch (e:Exception){
                e.printStackTrace()
            }

            moviesState.value = movies

            Log.i(tag, "movies state length ${moviesState.value.size} ")

        }

    }


    fun getSearchResults(queryStr: String, pageNum:Int = 1) {

        viewModelScope.launch(Dispatchers.IO){
            try {
                val searchMovieBase : SearchMovieBase? = searchMovieRepository.searchMovie(queryStr,pageNum)
                for(m in searchMovieBase?.results!!){
                    searchResults.add(m)
                }
            }catch (e:Exception){
                e.printStackTrace()
            }

            searchState.value = searchResults

        }
    }
}