package com.lkrfnr.cinephile.ui.home.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.*
import androidx.navigation.NavController

@Composable
fun Contents(
    navController: NavController,
) {

    // TODO figure out instantiating the view models using dagger hilt

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(
                vertical = 24.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        MoviesRow(movies = viewModel.popularMoviesState.value, "Popular", navController = navController)
        MoviesRow(movies = viewModel.upcomingMoviesState.value, "Upcoming", navController = navController)
    }

}