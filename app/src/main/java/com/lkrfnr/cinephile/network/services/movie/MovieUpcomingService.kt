package com.lkrfnr.cinephile.network.services.movie

import android.content.res.Resources
import androidx.compose.ui.res.stringResource
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.network.model.movie.moviepopular.MoviePopularBase
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieUpcomingService {

    @GET("movie/upcoming")
    suspend fun getUpcomingMovies(@Query("api_key") apiKey : String = Resources.getSystem().getString(R.string.api_key),
                                  @Query("language") language : String = "en-US",
                                  @Query("page") page : Int = 1
    ) : Response<MoviePopularBase>

}