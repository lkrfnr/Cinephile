package com.lkrfnr.cinephileapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lkrfnr.cinephileapp.entities.Comment
import com.lkrfnr.cinephileapp.entities.Film
import com.lkrfnr.cinephileapp.entities.User
import com.lkrfnr.cinephileapp.entities.WatchLater
import com.lkrfnr.cinephileapp.entities.dao.FilmDao
import com.lkrfnr.cinephileapp.entities.dao.UserDao
import java.security.AccessControlContext

@Database(

    entities = [

        Comment::class,
        Film::class,
        User::class,
        WatchLater::class

    ],
    version = 1

)
abstract class LocalDatabase : RoomDatabase() {

    abstract val userDao: UserDao
    abstract val filmDao: FilmDao

    companion object{

        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun getInstance(context: Context) : LocalDatabase{

            synchronized(this){

                return INSTANCE ?: Room.databaseBuilder(
                    context.applicationContext,
                    LocalDatabase::class.java,
                    "cinephile_db"
                ).build().also {
                    INSTANCE = it
                }

            }

        }

    }

}