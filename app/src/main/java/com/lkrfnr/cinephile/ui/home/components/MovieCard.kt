package com.lkrfnr.cinephile.ui.home.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.network.model.common.MovieResult
import com.lkrfnr.cinephile.ui.nav.Screen
import com.lkrfnr.cinephile.ui.theme.movieCardBackground
import com.lkrfnr.cinephile.ui.theme.popularMovieCardRateColor
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

private const val TAG = "MovieCard"

@Composable
fun MovieCard(movie: MovieResult, navController: NavController) {

    Card(
        modifier = Modifier
            .size(320.dp, 180.dp)
            .clip(RoundedCornerShape(12.dp))
            .clickable {

                Log.i(TAG, "Before routing, movieId : ${movie.id}")

                navController.navigate(Screen.MovieDetailScreen.route + "/${movie.id}") {
                    launchSingleTop = true
                }
            },
        backgroundColor = movieCardBackground,
    ) {

        Row(Modifier.padding(10.dp)) {
            // movie poster
            PosterImageBox(posterImageUrl = movie.posterPath)

            // movie details part
            Column(
                Modifier
                    .fillMaxHeight(1f)
                    .padding(horizontal = 12.dp),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                // movie title
                Text(
                    movie.title,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp
                    )
                )
                // movie rate
                MovieRateBox(movieRate = movie.voteAverage.toString())
                // movie overview
                MovieOverviewBox(movieOverview = movie.overview)
            }
        }

    }
}


@Composable
fun MovieOverviewBox(movieOverview: String) {

    Row(verticalAlignment = Alignment.Bottom) {
        // movie overview
        Text(
            text = movieOverview,
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(fontSize = 12.sp, color = Color.White)
        )
    }

}

@Composable
fun MovieRateBox(movieRate: String) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(id = R.drawable.star),
            contentDescription = "Movie rate star",
            modifier = Modifier.size(16.dp)
        )
        Text(
            movieRate,
            style = TextStyle(
                color = popularMovieCardRateColor,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun PosterImageBox(posterImageUrl: String) {

    val baseUrl = "https://image.tmdb.org/t/p/w500"

    Box(
        modifier = Modifier
            .fillMaxHeight(1f)
            .fillMaxWidth(0.35f)
    ) {

        CoilImage(
            modifier = Modifier.clip(RoundedCornerShape(12.dp)),
            imageModel = baseUrl + posterImageUrl,
            contentScale = ContentScale.Crop,
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

    }
}
