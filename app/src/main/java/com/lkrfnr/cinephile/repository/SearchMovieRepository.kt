package com.lkrfnr.cinephile.repository

import com.lkrfnr.cinephile.network.model.common.MovieBase
import com.lkrfnr.cinephile.network.services.SearchMovieService
import javax.inject.Inject

class SearchMovieRepository @Inject constructor(
    private val popularMoviesService: SearchMovieService
) {

    private val tag: String = "SearchMovieRepository"

    suspend fun searchMovie(queryStr: String, pageNum: Int): MovieBase? {

        val response = popularMoviesService
            .searchMovie(
                query = queryStr,
                page = pageNum
            )

        return response.body()
    }

}