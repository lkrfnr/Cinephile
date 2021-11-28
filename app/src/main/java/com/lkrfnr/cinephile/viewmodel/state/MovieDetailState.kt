package com.lkrfnr.cinephile.viewmodel.state

import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailGenre


sealed class MovieDetailState : BaseState() {
    class Loading(val message: String = "Loading..") : MovieDetailState()
    class Success(
        val movieId: String? = "",
        val posterUrl: String? = "",
        val originalTitle: String? = "",
        val overview: String? = "",
        val releaseDate: String? = "",
        val runtime: String? = "",
        val genres: List<MovieDetailGenre>? = ArrayList()
    ) : MovieDetailState()

    class Error(val movieCreditState: MovieCreditState) : MovieDetailState()
}