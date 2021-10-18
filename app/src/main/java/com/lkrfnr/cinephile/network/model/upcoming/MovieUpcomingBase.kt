package com.lkrfnr.cinephile.network.model.upcoming

data class MovieUpcomingBase(
    val movieUpcomingDates: MovieUpcomingDates,
    val page: Int,
    val movieUpcomingResults: List<MovieUpcomingResult>,
    val total_pages: Int,
    val total_results: Int
)