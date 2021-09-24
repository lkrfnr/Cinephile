package com.lkrfnr.cinephile.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephile.network.model.search.SearchMovieBase
import com.lkrfnr.cinephile.network.model.search.SearchMovieResult
import com.lkrfnr.cinephile.repository.MoviePopularRepository
import com.lkrfnr.cinephile.repository.SearchMovieRepository
import java.lang.Exception

class HomeViewModel : ViewModel() {

    private var moviePopularBase: MoviePopularBase? = null
    private var searchMovieBase: SearchMovieBase? = null


    private val _popularMoviesLiveData: MutableLiveData<List<MoviePopularResult>> = MutableLiveData()
    val popularMoviesLiveData: LiveData<List<MoviePopularResult>> = _popularMoviesLiveData

    private val _searchMovieResultList : MutableLiveData<List<SearchMovieResult>> = MutableLiveData()
    val searchMovieResultList:LiveData<List<SearchMovieResult>> = _searchMovieResultList

    private var moviePopularRepository: MoviePopularRepository = MoviePopularRepository()
    private var searchMovieRepository : SearchMovieRepository = SearchMovieRepository()

    suspend fun getPopularMovies() {


        val movieList : MutableList<MoviePopularResult> = ArrayList()

        requestAndFillMovieResults(1, movieList)

        _popularMoviesLiveData.postValue(movieList)

    }

    suspend fun searchMovie(queryStr : String) {

        val list : MutableList<SearchMovieResult> = ArrayList()

        requestAndFillSearchResults(queryStr, 1, list)
    }

    private suspend fun requestAndFillMovieResults(pageNum: Int, willFilledList : MutableList<MoviePopularResult>){
        try {
            moviePopularBase = moviePopularRepository.getPopularMovies(pageNum)
            for(  m in moviePopularBase?.results!!){
                willFilledList.add(m)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private suspend fun requestAndFillSearchResults(queryStr: String, pageNum:Int, willFilledList: MutableList<SearchMovieResult>) : Int {
        try {
            searchMovieBase = searchMovieRepository.searchMovie(queryStr,pageNum)
            for(m in searchMovieBase?.results!!){
                willFilledList.add(m)
            }
        }catch (e:Exception){
            e.printStackTrace()
        }

        return searchMovieBase?.total_pages!!
    }
}