package com.lkrfnr.cinephile.ui.home.components

import android.content.res.Resources
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.*
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephile.ui.theme.popularMovieCardBackground
import com.lkrfnr.cinephile.ui.theme.popularMovieCardRateColor
import com.lkrfnr.cinephile.viewmodel.HomeViewModel
import com.skydoves.landscapist.ShimmerParams
import com.skydoves.landscapist.coil.CoilImage

@Composable
fun MoviesRow( movies:List<MoviePopularResult>, rowTitle: String ){
    Column(
        modifier = Modifier.fillMaxWidth(1f),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.spacedBy(12.dp)) {
        
        Text(rowTitle,
            fontSize = 24.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White)
        
        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)){
            items(movies){ movie ->
                MovieCard(movie = movie)
            }
        }

    }
}


@Composable
fun MovieCard(movie: MoviePopularResult){

    Card(modifier = Modifier
        .size(320.dp, 180.dp)
        .clip(RoundedCornerShape(12.dp)),
        backgroundColor = popularMovieCardBackground,
    ) {

        Row(Modifier.padding(10.dp)){
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
                Text(movie.title,
                    style = TextStyle(
                        color = Color.White,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp))
                // movie rate
                MovieRateBox(movieRate = movie.voteAverage.toString())
                // movie overview
                MovieOverviewBox(movieOverview = movie.overview)
            }
        }

    }
}


@Composable
fun MovieOverviewBox(movieOverview : String){

    var summary = ""
    if (movieOverview.length > 110){
        summary = movieOverview.subSequence(0,110) as String
        summary = summary.subSequence(0,summary.lastIndexOf(" ")) as String
    }

    summary = summary.plus("...")

    Row(verticalAlignment = Alignment.Bottom){
        // movie overview
        Text(
            text = summary,
            style = TextStyle(fontSize = 12.sp, color = Color.White)
        )
    }

}

@Composable
fun MovieRateBox(movieRate : String){
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
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
fun PosterImageBox(posterImageUrl : String){

    val baseUrl = "https://image.tmdb.org/t/p/w500"

    Box(modifier = Modifier
        .fillMaxHeight(1f)
        .fillMaxWidth(0.35f)
    ){

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