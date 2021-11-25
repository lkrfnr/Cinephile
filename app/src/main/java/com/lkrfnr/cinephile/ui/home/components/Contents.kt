package com.lkrfnr.cinephile.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lkrfnr.cinephile.viewmodel.HomeViewModel

@Composable
fun Contents(
    navController: NavController,
) {

    val viewModel : HomeViewModel = hiltViewModel()

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(
                vertical = 24.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        MoviesRow(movies = viewModel.homePopularState.value.popularMovies, "Popular", navController = navController)
        MoviesRow(movies = viewModel.homeUpcomingState.value.upcomingMovies, "Upcoming", navController = navController)
    }

}