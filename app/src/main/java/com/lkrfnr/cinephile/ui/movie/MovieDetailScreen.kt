package com.lkrfnr.cinephile.ui.movie

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.gson.Gson
import com.lkrfnr.cinephile.network.model.common.MovieResult
import com.lkrfnr.cinephile.ui.movie.components.ActionBar
import com.lkrfnr.cinephile.ui.theme.mainColor

const val TAG : String  = "MovieDetailScreen"

@Composable
fun MovieDetailScreen(navController: NavController, movieDetailJson : String?){

    val movie = Gson().fromJson(movieDetailJson, MovieResult::class.java)

    Log.i(TAG, "Movie title : ${movie.title}")
    Log.i(TAG, "Movie detail json : $movieDetailJson")

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = mainColor),
    ) {

        item{
            ActionBar()
        }

    }
}