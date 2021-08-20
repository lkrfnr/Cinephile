package com.lkrfnr.cinephileapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lkrfnr.cinephileapp.network.RetrofitClient
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephileapp.network.model.search.SearchMovieBase
import com.lkrfnr.cinephileapp.network.model.search.SearchMovieResult
import com.lkrfnr.cinephileapp.persistance.LocalDatabase
import com.lkrfnr.cinephileapp.persistance.entities.dao.FilmDao
import com.lkrfnr.cinephileapp.repository.MoviePopularRepository
import com.lkrfnr.cinephileapp.repository.SearchMovieRepository

class HomeViewModel : ViewModel() {

    private var moviePopularBase: MoviePopularBase? = null
    private var searchMovieBase: SearchMovieBase? = null

    var popularMoviesList : MutableLiveData<MutableList<MoviePopularResult>> = MutableLiveData()
    var searchMovieResultList : MutableLiveData<MutableList<SearchMovieResult>> = MutableLiveData()


    private var moviePopularRepository: MoviePopularRepository = MoviePopularRepository()
    private var searchMovieRepository : SearchMovieRepository = SearchMovieRepository()

    suspend fun getPopularMovies() {

        var list : MutableList<MoviePopularResult> = ArrayList()

        moviePopularBase = moviePopularRepository.getPopularMovies()
        for( movie in moviePopularBase?.results!!){
            list.add(movie)
        }

        popularMoviesList.postValue(list)

    }

    suspend fun searchMovie(queryStr : String) : MutableList<SearchMovieResult>? {

        searchMovieBase = searchMovieRepository.searchMovie(queryStr)

        for (movie in searchMovieBase?.results!!){
            searchMovieResultList.value?.add(movie)
        }

        return  searchMovieResultList.value

    }
}