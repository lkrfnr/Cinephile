package com.lkrfnr.cinephile.ui.home.components

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lkrfnr.cinephile.network.model.common.MovieResult

private const val TAG: String = "MoviesRow"

@Composable
fun MoviesRow(movies: List<MovieResult>?, rowTitle: String, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            rowTitle,
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            modifier = Modifier.padding(start = 12.dp)
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            item { Spacer(modifier = Modifier.fillMaxHeight(1f)) }

            movies?.let {
                Log.i(TAG, "Length of movies in row. ${it.size}")
                items(it) { movie ->
                    MovieCard(movie = movie, navController = navController)
                }
            }

        }

    }
}


