package com.lkrfnr.cinephile.ui.home.components

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.lkrfnr.cinephile.viewmodel.HomeViewModel
import com.lkrfnr.cinephile.viewmodel.state.HomePopularState
import com.lkrfnr.cinephile.viewmodel.state.HomeUpcomingState

private const val TAG: String = "Contents"

@Composable
fun Contents(
    homeViewModel: HomeViewModel,
    navController: NavController,
) {


    val popularMovieState = homeViewModel.homePopularState.collectAsState()
    val upcomingMovieState = homeViewModel.homeUpcomingState.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(
                vertical = 24.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        PopularMoviesRow(homePopularState = popularMovieState.value, navController = navController)
        UpcomingMoviesRow(
            homeUpcomingState = upcomingMovieState.value,
            navController = navController
        )

    }
}

@Composable
fun PopularMoviesRow(homePopularState: HomePopularState, navController: NavController) {
    Log.i("Contents", "In Popular Movies")

    when (homePopularState) {
        is HomePopularState.Loading -> {
            Log.i(TAG, "In Loading State..")
        }
        is HomePopularState.Success -> {
            Log.i(TAG, "In Success state. ")
            MoviesRow(
                movies = homePopularState.popularMovies,
                "Popular",
                navController = navController
            )
        }
        is HomePopularState.Error -> {
            Log.i(TAG, "In Error State !")
        }
    }
}


@Composable
fun UpcomingMoviesRow(homeUpcomingState: HomeUpcomingState, navController: NavController) {

    when (homeUpcomingState) {
        is HomeUpcomingState.Loading -> { }
        is HomeUpcomingState.Success -> {
            MoviesRow(
                movies = homeUpcomingState.upcomingMovies,
                "Upcoming",
                navController = navController
            )
        }
        is HomeUpcomingState.Error -> { }
    }
}