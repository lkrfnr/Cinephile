package com.lkrfnr.cinephile.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.lkrfnr.cinephile.ui.home.HomeScreen
import com.lkrfnr.cinephile.ui.movie.MovieDetailScreen

@Composable
fun SetupNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.MovieDetailScreen.route + "/{movie_id}",
            arguments = listOf(
                navArgument("movie_id"){
                    type = NavType.StringType
                    nullable = true
                }
            )
        ) { entry ->
            MovieDetailScreen(navController = navController, movieId = entry.arguments?.getString("movie_id") ?: "")
        }
        /*composable(route = Screen.MovieDetailScreen.route){
            MovieDetailScreen(navController = navController, movieId = "566525")
        }*/

    }
}