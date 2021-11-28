package com.lkrfnr.cinephile.ui.nav

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.lkrfnr.cinephile.ui.home.HomeScreen
import com.lkrfnr.cinephile.ui.movie.MovieDetailScreen
import com.lkrfnr.cinephile.viewmodel.HomeViewModel
import com.lkrfnr.cinephile.viewmodel.MovieDetailViewModel

private const val TAG = "Nav"

@Composable
fun SetupNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {

            val homeViewModel: HomeViewModel = hiltViewModel()

            HomeScreen(homeViewModel, navController = navController)
        }
        composable(
            route = Screen.MovieDetailScreen.route + "/{movie_id}",
            arguments = listOf(
                navArgument("movie_id") {
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) {
            val movieDetailViewModel: MovieDetailViewModel = hiltViewModel()

            MovieDetailScreen(
                movieDetailViewModel = movieDetailViewModel,
                navController = navController
            )
        }

    }
}