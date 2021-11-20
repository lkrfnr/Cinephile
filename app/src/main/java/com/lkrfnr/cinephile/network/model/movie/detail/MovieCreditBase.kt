package com.lkrfnr.cinephile.network.model.movie.detail

data class MovieCreditBase(
    val movieCreditCast: List<MovieCreditCast>,
    val movieCreditCrew: List<MovieCreditCrew>,
    val id: Int
)