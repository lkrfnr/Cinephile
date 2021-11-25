package com.lkrfnr.cinephile.ui.movie

import android.util.Log
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lkrfnr.cinephile.ui.movie.components.MovieDetailContainer
import com.lkrfnr.cinephile.ui.movie.components.MoviePosterContainer
import com.lkrfnr.cinephile.ui.nav.Screen
import com.lkrfnr.cinephile.ui.theme.mainColor
import com.lkrfnr.cinephile.viewmodel.MovieDetailViewModel

const val TAG: String = "MovieDetailScreen"

@Composable
fun MovieDetailScreen(navController: NavController, movieId: String) {

    Log.i(TAG, "New movie detail screen opened, movie id $movieId")

    val movieDetailViewModel: MovieDetailViewModel = hiltViewModel()
    movieDetailViewModel.getMovieDetail(movieId = movieId)
    movieDetailViewModel.getMovieCredit(movieId = movieId)

    BackHandler {
        navController.navigate(Screen.HomeScreen.route) {
            launchSingleTop = true
            popUpTo(Screen.HomeScreen.route) { inclusive = false }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = mainColor),
    ) {
        MoviePosterContainer(
            movieDetailViewModel.movieDetailState.value,
            navController = navController
        )
        MovieDetailContainer(
            movieDetailState = movieDetailViewModel.movieDetailState.value,
            movieCreditState = movieDetailViewModel.movieCreditState.value
        )
    }
}