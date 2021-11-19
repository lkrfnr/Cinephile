package com.lkrfnr.cinephile.ui.nav

sealed class Screen(val route : String){
    object HomeScreen :  Screen("home_screen")
    object MovieDetailScreen :  Screen("movie_detail_screen")

    fun withArgs(vararg args: String?) : String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }

}
