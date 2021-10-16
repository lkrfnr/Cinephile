package com.lkrfnr.cinephile.network.model.upcoming

data class UpcomingBase(
    val dates: Dates,
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)