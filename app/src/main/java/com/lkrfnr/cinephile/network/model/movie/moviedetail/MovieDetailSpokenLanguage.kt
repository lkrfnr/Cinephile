package com.lkrfnr.cinephile.network.model.movie.moviedetail

import com.google.gson.annotations.SerializedName

data class MovieDetailSpokenLanguage(
    @SerializedName("iso_639_1") val iso_639_1 : String,
    @SerializedName("name") val name : String
)