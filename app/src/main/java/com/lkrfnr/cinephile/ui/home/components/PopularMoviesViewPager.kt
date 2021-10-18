package com.lkrfnr.cinephile.ui.home.components

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephile.ui.theme.cardShapes
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage


@Preview
@SuppressLint("UseCompatLoadingForDrawables")
@ExperimentalPagerApi
@Composable
fun PopularMoviesViewPager(dataList: List<MoviePopularResult> = emptyList()) {

    val baseUrl = "https://image.tmdb.org/t/p/w500"

    val pagerState = rememberPagerState(dataList.size)

    HorizontalPager(state = pagerState, modifier = Modifier.fillMaxWidth(1f)) { page ->

        val pageItem = dataList[page]
        // Our page content
        Box(
            modifier = Modifier
                .fillMaxWidth(1f)
        ) {

            CoilImage(
                imageModel = baseUrl + dataList[page].posterPath,
                alignment = Alignment.Center,
                contentScale = ContentScale.FillWidth,
                // shows a shimmering effect when loading an image.
                shimmerParams = ShimmerParams(
                    baseColor = MaterialTheme.colors.background,
                    highlightColor = Color.White,
                    durationMillis = 350,
                    dropOff = 0.65f,
                    tilt = 20f
                ),
                failure = {
                    Text(text = "Loading the image failed.")
                }
            )

            // movie information part
            Column(
                modifier = Modifier
                    .fillMaxWidth(1f)
                    .height(100.dp)
                    .align(Alignment.BottomCenter),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Card(
                    shape = cardShapes.medium,
                    elevation = 0.dp,
                    backgroundColor = Color(0x80000000)
                ) {
                    Text(
                        text = pageItem.originalTitle,
                        fontSize = 22.sp,
                        modifier = Modifier.fillMaxSize(1f),
                        textAlign = TextAlign.Center
                    )
                }

            }

        }
    }
}
