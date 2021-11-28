package com.lkrfnr.cinephile.ui.movie

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.lkrfnr.cinephile.ui.movie.components.MovieDetailContainer
import com.lkrfnr.cinephile.ui.movie.components.MoviePosterContainer
import com.lkrfnr.cinephile.ui.nav.Screen
import com.lkrfnr.cinephile.ui.theme.mainColor
import com.lkrfnr.cinephile.viewmodel.MovieDetailViewModel

const val TAG: String = "MovieDetailScreen"

@Composable
fun MovieDetailScreen(movieDetailViewModel: MovieDetailViewModel, navController: NavController) {

    val movieDetailUiState = movieDetailViewModel.movieDetailUiState.collectAsState()
    val movieCreditUiState = movieDetailViewModel.movieCreditUiState.collectAsState()

    BackHandler {
        navController.navigate(Screen.HomeScreen.route) {
            launchSingleTop = true
            popUpTo(Screen.HomeScreen.route) { inclusive = false }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = mainColor)
            .verticalScroll(rememberScrollState()),
    ) {

        MoviePosterContainer(
            movieDetailUiState.value,
            navController = navController
        )
        MovieDetailContainer(
            movieDetailState = movieDetailUiState.value,
            movieCreditState = movieCreditUiState.value
        )
    }
}