package com.lkrfnr.cinephileapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lkrfnr.cinephileapp.network.RetrofitClient
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephileapp.persistance.LocalDatabase
import com.lkrfnr.cinephileapp.persistance.entities.dao.FilmDao
import com.lkrfnr.cinephileapp.repository.MoviePopularRepository

class HomeViewModelFactory(private val db: LocalDatabase) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
            modelClass.getConstructor(LocalDatabase::class.java)
                    .newInstance(db)
}


class HomeViewModel( db : LocalDatabase) : ViewModel() {

    private var moviePopularBase: MoviePopularBase? = null
    private val popularMoviesList : MutableList<MoviePopularResult> = ArrayList()
    private var moviePopularRepository: MoviePopularRepository = MoviePopularRepository(db)

    suspend fun getPopularMovies() : MutableList<MoviePopularResult> {

        moviePopularBase = moviePopularRepository.getPopularMovies()

        for( movie in moviePopularBase?.results!!){
            popularMoviesList.add(movie)
        }

        return popularMoviesList
    }
}