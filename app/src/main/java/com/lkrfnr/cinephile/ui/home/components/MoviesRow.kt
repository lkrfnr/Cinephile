package com.lkrfnr.cinephile.ui.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.network.model.common.MovieResult
import com.lkrfnr.cinephile.ui.theme.cardShapes
import com.lkrfnr.cinephile.ui.theme.popularMovieCardRateColor
import com.lkrfnr.cinephile.ui.theme.secondMainColor
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MoviesRow(movies: List<MovieResult>, rowTitle: String, navController: NavController) {
    Column(
        modifier = Modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {

        Text(
            rowTitle,
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            modifier = Modifier.padding(start = 12.dp)
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            item { Spacer(modifier = Modifier.fillMaxHeight(1f)) }
            items(movies) { movie ->
                AlternativeMovieCard(movie = movie, navController = navController)
            }
        }

    }
}


@Composable
fun MovieCard(movie: MovieResult) {

    val cardWidth = 188.dp
    val cardHeight = 364.dp

    val cardWidthPx = with(LocalDensity.current) { cardWidth.toPx() }
    val cardHeightPx = with(LocalDensity.current) { cardHeight.toPx() }

    Column(
        modifier =
        Modifier
            .width(cardWidth)
            .padding(start = 10.dp)
            .clip(cardShapes.small)
    ) {
        PosterImage(
            modifier = Modifier
                .width(cardWidth)
                .height(240.dp)
                .clip(cardShapes.small),
            posterImageUrl = movie.posterPath
        )
        Spacer(
            modifier = Modifier
                .size(cardWidth, 4.dp)
        )
        Column(
            modifier = Modifier.width(cardWidth),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Row(
                modifier = Modifier.width(cardWidth),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    movie.title,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 12.sp
                    ),
                    modifier = Modifier
                        .fillMaxWidth(0.60f)
                )

                MovieRateBox(
                    movieRate = movie.voteAverage.toString()
                )
            }

            Spacer(
                modifier = Modifier
                    .size(cardWidth, 4.dp)
            )

            // movie rate and watch trailer box

            Box(
                modifier = Modifier
                    .clip(RoundedCornerShape(8.dp))
                    .background(secondMainColor)
                    .padding(vertical = 8.dp, horizontal = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "Watch Trailer",
                    style = TextStyle(Color.White, fontSize = 10.sp, fontWeight = FontWeight.Bold)
                )
            }


        }
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
            modifier = Modifier.size(9.dp)
        )
        Text(
            movieRate,
            style = TextStyle(
                color = popularMovieCardRateColor,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold
            )
        )
    }
}

@Composable
fun PosterImage(modifier: Modifier, posterImageUrl: String) {

    val baseUrl = "https://image.tmdb.org/t/p/w500"

    CoilImage(
        modifier = modifier,
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


