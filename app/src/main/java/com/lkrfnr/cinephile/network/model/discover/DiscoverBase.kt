package com.lkrfnr.cinephile.network.model.discover

import com.google.gson.annotations.SerializedName
import com.lkrfnr.cinephile.network.model.discover.DiscoverResult

data class DiscoverBase(
    @SerializedName("page") val page : Int,
    @SerializedName("results") val results : List<DiscoverResult>,
    @SerializedName("total_results") val totalResults : Int,
    @SerializedName("total_pages") val totalPages : Int
)
