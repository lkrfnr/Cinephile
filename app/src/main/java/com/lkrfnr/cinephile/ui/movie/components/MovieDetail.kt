package com.lkrfnr.cinephile.ui.movie.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lkrfnr.cinephile.network.model.movie.detail.MovieCreditCast
import com.lkrfnr.cinephile.network.model.movie.moviedetail.MovieDetailGenre
import com.lkrfnr.cinephile.ui.theme.snowWhite
import com.lkrfnr.cinephile.ui.theme.softGray
import com.lkrfnr.cinephile.util.minToHour
import com.lkrfnr.cinephile.viewmodel.state.MovieCreditState
import com.lkrfnr.cinephile.viewmodel.state.MovieDetailState
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

const val TAG: String = "MoviePosterContainer"

@Composable
fun MovieDetailContainer(movieDetailState: MovieDetailState, movieCreditState: MovieCreditState) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(1f),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        item {
            Text(
                "Fight Club",
                modifier = Modifier.padding(vertical = 16.dp),
                style = TextStyle(
                    color = snowWhite,
                    fontSize = 20.sp,
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.W500
                )
            )
        }

        item {
            DetailRow(
                releaseDate = movieDetailState.releaseDate,
                genres = movieDetailState.genres,
                runtime = movieDetailState.runtime
            )
        }

        item {
            OverviewText(overview = movieDetailState.overview)
        }

        item {
            CastRow(castList = movieCreditState.castList)
        }


    }
}

@Composable
fun CastRow(castList: List<MovieCreditCast>?) {

    // Log.i(TAG, "CastList size : ${castList?.size}")

    castList?.let {
        LazyRow(modifier = Modifier.fillMaxWidth(1f)) {
            items(castList) { castItem ->
                Actor(actorName = castItem.name, actorProfilePicUrl = castItem.profile_path)
            }
        }
    }
}

@Composable
fun Actor(actorName: String?, actorProfilePicUrl: String?) {

    val baseUrl = "https://image.tmdb.org/t/p/w500"

    Column {
        CoilImage(
            modifier = Modifier
                .width(48.dp)
                .clip(RoundedCornerShape(8.dp)),
            imageModel = baseUrl + actorProfilePicUrl,
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

        actorName?.let {
            Text(
                text = actorName,
                style = TextStyle(color = Color.White, fontSize = 14.sp),
                modifier = Modifier
                    .width(48.dp)
                    .padding(top = 4.dp, start = 2.dp, end = 2.dp)
            )
        }

    }

}

@Composable
fun OverviewText(overview: String?) {

    overview?.let {
        Text(
            "Overview",
            modifier = Modifier.padding(top = 16.dp, bottom = 8.dp),
            style = TextStyle(
                color = snowWhite,
                fontSize = 18.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W400
            )
        )
        Text(
            it,
            Modifier.padding(horizontal = 24.dp),
            style = TextStyle(
                color = snowWhite,
                fontSize = 16.sp,
                fontFamily = FontFamily.Default,
                fontWeight = FontWeight.W300,
                textAlign = TextAlign.Justify
            )
        )
    }
}

@Composable
fun DetailText(text: String?, fontSize: Int = 16) {
    Text(
        text ?: "?",
        style = TextStyle(color = softGray, fontSize = fontSize.sp)
    )
}

@Composable
fun DetailRowDividerPoint() {
    Box(
        modifier = Modifier
            .size(4.dp)
            .clip(RoundedCornerShape(100))
            .background(snowWhite)
    )
}

@Composable
fun DetailRow(releaseDate: String?, genres: List<MovieDetailGenre>?, runtime: String?) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.spacedBy(12.dp, Alignment.CenterHorizontally),
        verticalAlignment = Alignment.CenterVertically
    ) {

        releaseDate?.let {
            DetailText(text = it.substringBefore("-"))
            DetailRowDividerPoint()
        }

        if (genres?.size!! > 0) {
            DetailText(text = genres[0].name)
            DetailRowDividerPoint()
        }

        runtime?.let {
            DetailText(text = it.minToHour())
        }

    }
}
