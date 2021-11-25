package com.lkrfnr.cinephile.ui.movie.components

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.ui.nav.Screen
import com.lkrfnr.cinephile.ui.theme.snowWhite
import com.lkrfnr.cinephile.ui.theme.transparentGray
import com.lkrfnr.cinephile.viewmodel.state.MovieDetailState
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MoviePosterContainer(movieDetailState: MovieDetailState, navController: NavController) {

    Log.i(TAG, "posterImageUrl : ${movieDetailState.posterUrl}")

    Column(
        modifier = Modifier
            .fillMaxWidth(1f),
        verticalArrangement = Arrangement.Top,
    ) {

        Header(navController)
        MoviePoster(posterImageUrl = movieDetailState.posterUrl)

    }
}

@Composable
fun MoviePoster(posterImageUrl: String?) {
    posterImageUrl.let {
        if (it != null)
            PosterImage(posterImageUrl = it)
        else
            PosterPlaceholderImage()
    }
}

@Composable
fun Header(navController: NavController) {

    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(96.dp),
        contentAlignment = Alignment.CenterStart
    ) {

        Box(modifier = Modifier.padding(start = 24.dp)) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(RoundedCornerShape(24.dp))
                    .background(transparentGray)
                    .align(Alignment.CenterStart)
                    .clickable {
                        navController.navigate(Screen.HomeScreen.route) {
                            launchSingleTop = true
                            popUpTo(Screen.HomeScreen.route) { inclusive = false }
                        }
                    },
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.white_back_arrow),
                    contentDescription = "back arrow",
                    modifier = Modifier
                        .size(24.dp)
                        .padding(end = 4.dp)
                )
            }
        }

        Text(
            text = "Movie Detail",
            modifier = Modifier.fillMaxWidth(1f),
            textAlign = TextAlign.Center,
            style = TextStyle(snowWhite, fontWeight = FontWeight.Medium, fontSize = 18.sp)
        )

    }


}

@Composable
fun PosterPlaceholderImage() {
    Image(
        painter = painterResource(id = R.drawable.movie_poster_image_place_holder),
        contentDescription = "placeholder image",
        modifier = Modifier.fillMaxWidth(1f),
    )
}

@Composable
fun PosterImage(posterImageUrl: String?) {

    val baseUrl = "https://image.tmdb.org/t/p/w500"

    Box(
        modifier = Modifier.fillMaxWidth(1f),
    ){
        CoilImage(
            modifier = Modifier
                .fillMaxWidth(0.836f)
                .clip(RoundedCornerShape(12.dp)).align(Alignment.Center),
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