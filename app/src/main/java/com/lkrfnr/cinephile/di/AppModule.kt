package com.lkrfnr.cinephile.di

import android.graphics.Movie
import com.lkrfnr.cinephile.network.RetrofitClient
import com.lkrfnr.cinephile.network.services.SearchMovieService
import com.lkrfnr.cinephile.network.services.movie.MovieDetailService
import com.lkrfnr.cinephile.network.services.movie.MoviePopularService
import com.lkrfnr.cinephile.network.services.movie.MovieUpcomingService
import com.lkrfnr.cinephile.repository.MoviePopularRepository
import com.lkrfnr.cinephile.repository.MovieUpcomingRepository
import com.lkrfnr.cinephile.repository.SearchMovieRepository
import com.lkrfnr.cinephile.viewmodel.HomeViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.annotation.Signed
import javax.inject.Inject
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofitClient(): Retrofit {
        return RetrofitClient.getRetrofitInstance()
    }

    @Provides
    @Singleton
    fun provideMovieDetailService(retrofit: Retrofit): MovieDetailService {
        return retrofit.create(MovieDetailService::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviePopularService(retrofit: Retrofit): MoviePopularService {
        return retrofit.create(MoviePopularService::class.java)
    }

    @Provides
    @Singleton
    fun provideMovieUpcomingService(retrofit: Retrofit): MovieUpcomingService {
        return retrofit.create(MovieUpcomingService::class.java)
    }

    @Provides
    @Singleton
    fun provideSearchMovieService(retrofit: Retrofit): SearchMovieService {
        return retrofit.create(SearchMovieService::class.java)
    }

    @Provides
    @Singleton
    fun provideMoviePopularRepository(
        moviePopularService: MoviePopularService,
        movieDetailService: MovieDetailService
    ): MoviePopularRepository {
        return MoviePopularRepository(moviePopularService, movieDetailService)
    }

    @Provides
    @Singleton
    fun provideMovieUpcomingRepository(
        movieUpcomingService: MovieUpcomingService
    ): MovieUpcomingRepository {
        return MovieUpcomingRepository(movieUpcomingService)
    }

    @Provides
    @Singleton
    fun provideSearchMovieRepository(
        searchMovieService: SearchMovieService
    ): SearchMovieRepository {
        return SearchMovieRepository(searchMovieService)
    }

    @Provides
    @Singleton
    fun provideHomeViewModel(
        moviePopularRepository: MoviePopularRepository,
        movieUpcomingRepository: MovieUpcomingRepository,
        searchMovieRepository: SearchMovieRepository,
    ):HomeViewModel{
        return HomeViewModel(moviePopularRepository,
            movieUpcomingRepository,
            searchMovieRepository)
    }

}