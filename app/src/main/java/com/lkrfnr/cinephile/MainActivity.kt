package com.lkrfnr.cinephile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LiveData
import com.lkrfnr.cinephile.data.SharedPreferencesManager
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephile.ui.theme.CinephileTheme
import com.lkrfnr.cinephile.viewmodel.HomeViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private val homeViewModel:HomeViewModel by viewModels()

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
                    
                    val resultList: State<List<MoviePopularResult>> = homeViewModel.popularMoviesLiveData.observeAsState(listOf())

                    BaseLayout {

                    }

                }
            }
        }
    }


    @Composable
    private fun BaseLayout(content: @Composable ColumnScope.() -> Unit){
        Column(modifier = Modifier.fillMaxSize(1f),
            verticalArrangement = Arrangement.Top,
            content = content)
    }
}