package com.lkrfnr.cinephileapp.network.model.discover

import com.google.gson.annotations.SerializedName

data class DiscoverBase(
    @SerializedName("page") val page : Int,
    @SerializedName("results") val results : List<DiscoverResult>,
    @SerializedName("total_results") val totalResults : Int,
    @SerializedName("total_pages") val totalPages : Int
)
