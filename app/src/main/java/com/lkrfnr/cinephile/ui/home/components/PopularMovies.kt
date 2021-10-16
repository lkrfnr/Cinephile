package com.lkrfnr.cinephile.ui.home.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.*
import com.lkrfnr.cinephile.ui.theme.searchTextColor
import com.lkrfnr.cinephile.viewmodel.HomeViewModel

@Composable
fun PopularMovies(
    viewModel: HomeViewModel = viewModel()
){

    Box(modifier = Modifier
        .fillMaxSize(1f)
        .padding(
            horizontal = 16.dp,
            vertical = 24.dp
        )
    ){

        val movies = viewModel.moviesState.value

        LazyColumn{
            items(items = movies){ movie ->
                Text(text = movie.title, style = TextStyle(color = searchTextColor))
            }
        }
    }
}