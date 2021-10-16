package com.lkrfnr.cinephile.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.lkrfnr.cinephile.ui.home.components.Contents
import com.lkrfnr.cinephile.ui.home.components.Greetings
import com.lkrfnr.cinephile.ui.home.components.SearchBar
import com.lkrfnr.cinephile.ui.theme.mainColor

@Composable
fun HomeView(){
    Column(modifier = Modifier
        .fillMaxWidth(1f)
        .background(color = mainColor)) {
        Greetings()
        SearchBar()
        Contents()
    }
}