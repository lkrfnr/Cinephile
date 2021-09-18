package com.lkrfnr.cinephile.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephile.network.model.search.SearchMovieBase
import com.lkrfnr.cinephile.network.model.search.SearchMovieResult
import com.lkrfnr.cinephile.repository.MoviePopularRepository
import com.lkrfnr.cinephile.repository.SearchMovieRepository

class HomeViewModel : ViewModel() {

    private var moviePopularBase: MoviePopularBase? = null
    private var searchMovieBase: SearchMovieBase? = null

    var popularMoviesList : MutableLiveData<MutableList<MoviePopularResult>> = MutableLiveData()
    var searchMovieResultList : MutableLiveData<MutableList<SearchMovieResult>> = MutableLiveData()


    private var moviePopularRepository: MoviePopularRepository = MoviePopularRepository()
    private var searchMovieRepository : SearchMovieRepository = SearchMovieRepository()

    suspend fun getPopularMovies() {

        val list : MutableList<MoviePopularResult> = ArrayList()


        moviePopularBase = moviePopularRepository.getPopularMovies(1)

        val totalPages = moviePopularBase?.totalPages

        for ( pageNum in 2..totalPages!! ){
            moviePopularBase = moviePopularRepository.getPopularMovies(pageNum)
            addMoviesToList(moviePopularBase, list)
        }

        popularMoviesList.postValue(list)

    }

    private fun addMoviesToList(movie: MoviePopularBase?, list : MutableList<MoviePopularResult>){
        for(  movie in moviePopularBase?.results!!){
            list.add(movie)
        }
    }

    suspend fun searchMovie(queryStr : String) : MutableList<SearchMovieResult>? {

        searchMovieBase = searchMovieRepository.searchMovie(queryStr)

        for (movie in searchMovieBase?.results!!){
            searchMovieResultList.value?.add(movie)
        }

        return  searchMovieResultList.value

    }
}