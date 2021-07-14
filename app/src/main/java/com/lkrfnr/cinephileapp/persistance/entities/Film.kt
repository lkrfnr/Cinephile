package com.lkrfnr.cinephileapp.persistance.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Film(

    @PrimaryKey
    @ColumnInfo(name = "film_id") val filmId:Long,
    @ColumnInfo(name = "film_name" ) val filmName:String,
    @ColumnInfo(name = "description_text") val descText:String,
    @ColumnInfo(name = "imdb_score") val imdbScore:String,
    @ColumnInfo(name = "movie_release_date") val movieReleaseDate:String,
    @ColumnInfo(name = "film_poster_uri") val filmPosterUri:String,
    @ColumnInfo(name = "user_pp_uri") val userPPUri:String,


    )