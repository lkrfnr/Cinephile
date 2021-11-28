package com.lkrfnr.cinephile.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.lkrfnr.cinephile.ui.home.components.Contents
import com.lkrfnr.cinephile.ui.home.components.Greetings
import com.lkrfnr.cinephile.ui.home.components.SearchBar
import com.lkrfnr.cinephile.ui.theme.mainColor
import com.lkrfnr.cinephile.viewmodel.HomeViewModel

private const val TAG: String = "HomeScreen"

@Composable
fun HomeScreen(homeViewModel: HomeViewModel, navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(1f)
            .background(color = mainColor),
        verticalArrangement = Arrangement.Top
    ) {
        item {
            Greetings()
        }
        item {
            SearchBar()
        }
        item {
            Contents(homeViewModel = homeViewModel, navController = navController)
        }
    }
}