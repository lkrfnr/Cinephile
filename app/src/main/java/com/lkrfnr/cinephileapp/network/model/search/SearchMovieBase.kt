package com.lkrfnr.cinephileapp.network.model.search

import com.google.gson.annotations.SerializedName

data class SearchMovieBase (
        @SerializedName("page") val page : Int,
        @SerializedName("results") val results : List<SearchMovieResult>,
        @SerializedName("total_results") val total_results : Int,
        @SerializedName("total_pages") val total_pages : Int
        )