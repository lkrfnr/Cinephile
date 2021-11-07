package com.lkrfnr.cinephile.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lkrfnr.cinephile.ui.home.components.Contents
import com.lkrfnr.cinephile.ui.home.components.Greetings
import com.lkrfnr.cinephile.ui.home.components.SearchBar
import com.lkrfnr.cinephile.ui.theme.mainColor

@Composable
fun HomeView() {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(color = mainColor)
    ) {

        item {
            Greetings()
        }
        item {
            SearchBar()
        }
        item {
            Contents()
        }
    }
}