package com.lkrfnr.cinephile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import com.google.accompanist.pager.ExperimentalPagerApi
import com.lkrfnr.cinephile.data.SharedPreferencesManager
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephile.ui.theme.CinephileTheme
import com.lkrfnr.cinephile.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.lkrfnr.cinephile.ui.composables.PopularMoviesViewPager

class MainActivity : ComponentActivity() {
    private val TAG: String = "MainActivity"

    private val homeViewModel: HomeViewModel by viewModels()

    @OptIn(ExperimentalPagerApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        SharedPreferencesManager.init(this.applicationContext)

        CoroutineScope(Dispatchers.IO).launch {
            homeViewModel.getPopularMovies()
        }

        setContent {
            CinephileTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {

                    val resultList: State<List<MoviePopularResult>> =
                        homeViewModel.popularMoviesLiveData.observeAsState(listOf())

                    BaseColumnLayout {
                        PopularMoviesViewPager(dataList = resultList.value)
                    }

                }
            }
        }
    }

    @Composable
    private fun BaseColumnLayout(content: @Composable ColumnScope.() -> Unit) {
        Column(
            modifier = Modifier.fillMaxSize(1f),
            verticalArrangement = Arrangement.Top,
            content = content
        )
    }


}