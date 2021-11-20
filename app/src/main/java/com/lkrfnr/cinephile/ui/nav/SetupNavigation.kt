package com.lkrfnr.cinephile.ui.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.lkrfnr.cinephile.ui.home.HomeScreen
import com.lkrfnr.cinephile.ui.movie.MovieDetailScreen
import com.lkrfnr.cinephile.ui.nav.Screen

@Composable
fun SetupNavigation(navController: NavHostController) {

    NavHost(navController = navController, startDestination = Screen.HomeScreen.route) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }
        composable(
            route = Screen.MovieDetailScreen.route,
            /*arguments = listOf(
                navArgument("movie_detail_json"){
                    type = NavType.StringType
                    nullable = false
                }
            )*/
        ) {
            MovieDetailScreen(navController = navController, )
        }
    }
}