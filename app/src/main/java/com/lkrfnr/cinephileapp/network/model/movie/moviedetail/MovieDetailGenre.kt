package com.lkrfnr.cinephileapp.network.model.movie.moviedetail

import com.google.gson.annotations.SerializedName

data class MovieDetailGenre(
    @SerializedName("id") val id : Int,
    @SerializedName("name") val name : String
)