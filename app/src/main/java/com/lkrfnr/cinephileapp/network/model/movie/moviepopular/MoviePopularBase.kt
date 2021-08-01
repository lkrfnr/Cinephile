package com.lkrfnr.cinephileapp.network.model.movie.moviepopular

import com.google.gson.annotations.SerializedName

data class MoviePopularBase(
    @SerializedName("page") val page : Int,
    @SerializedName("results") val results : List<MoviePopularResult>,
    @SerializedName("total_results") val totalResults : Int,
    @SerializedName("total_pages") val totalPages : Int
)