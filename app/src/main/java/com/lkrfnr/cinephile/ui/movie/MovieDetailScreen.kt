package com.lkrfnr.cinephile.ui.movie

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.lkrfnr.cinephile.ui.movie.components.ActionBar
import com.lkrfnr.cinephile.ui.theme.mainColor
import com.lkrfnr.cinephile.viewmodel.HomeViewModel
import com.lkrfnr.cinephile.viewmodel.MovieDetailViewModel

const val TAG : String  = "MovieDetailScreen"

@Composable
fun MovieDetailScreen(navController: NavController){

    val viewModel : MovieDetailViewModel = hiltViewModel()

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = mainColor)
            .padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 24.dp),
    ) {

        item{
            ActionBar()
        }

    }
}