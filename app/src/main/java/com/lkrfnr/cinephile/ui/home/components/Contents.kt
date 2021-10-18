package com.lkrfnr.cinephile.ui.home.components

import androidx.compose.foundation.layout.*
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
fun Contents(
    viewModel: HomeViewModel = viewModel()
) {

    Column(
        modifier = Modifier
            .fillMaxSize(1f)
            .padding(
                vertical = 24.dp
            ),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        MoviesRow(movies = viewModel.popularMoviesState.value, "Popular")
        MoviesRow(movies = viewModel.upcomingMoviesState.value, "Upcoming")
    }

}