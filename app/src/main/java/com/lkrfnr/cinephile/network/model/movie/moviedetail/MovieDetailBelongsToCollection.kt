package com.lkrfnr.cinephile.network.model.movie.moviedetail

import com.google.gson.annotations.SerializedName

data class MovieDetailBelongsToCollection(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("backdrop_path") val backdropPath: Any? = null
)