package com.lkrfnr.cinephile.network.model.movie.moviedetail

import com.google.gson.annotations.SerializedName

data class MovieDetailProductionCountry(
    @SerializedName("iso_3166_1") val iso_3166_1 : String,
    @SerializedName("name") val name : String
)