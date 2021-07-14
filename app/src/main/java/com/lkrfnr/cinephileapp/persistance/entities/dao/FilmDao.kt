package com.lkrfnr.cinephileapp.persistance.entities.dao

import androidx.room.*
import com.lkrfnr.cinephileapp.persistance.entities.Film
import com.lkrfnr.cinephileapp.persistance.entities.relations.FilmWithComments
import com.lkrfnr.cinephileapp.persistance.entities.relations.FilmWithWatchLaters

@Dao
interface FilmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFilm(film: Film)

    @Transaction
    @Query("SELECT * FROM Film WHERE film_id = :filmId")
    suspend fun getFilmWithComments(filmId:String) : List<FilmWithComments>

    @Transaction
    @Query("SELECT * FROM Film WHERE film_id = :filmId")
    suspend fun getFilmWithWatchLaters(filmId:String) : List<FilmWithWatchLaters>

    @Query("SELECT * FROM Film")
    suspend fun getFilms() : List<Film>

}