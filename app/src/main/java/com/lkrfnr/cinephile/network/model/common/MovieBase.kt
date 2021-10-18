package com.lkrfnr.cinephile.network.model.common

import com.google.gson.annotations.SerializedName

data class MovieBase(
    @SerializedName("page") val page : Int,
    @SerializedName("results") val results : List<MovieResult>,
    @SerializedName("total_results") val totalResults : Int,
    @SerializedName("total_pages") val totalPages : Int
)
