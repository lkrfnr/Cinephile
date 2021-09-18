package com.lkrfnr.cinephile.persistance

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.lkrfnr.cinephile.persistance.entities.Comment
import com.lkrfnr.cinephile.persistance.entities.Film
import com.lkrfnr.cinephile.persistance.entities.User
import com.lkrfnr.cinephile.persistance.entities.WatchLater
import com.lkrfnr.cinephile.persistance.entities.dao.FilmDao
import com.lkrfnr.cinephile.persistance.entities.dao.UserDao

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

    abstract fun userDao(): UserDao
    abstract fun filmDao(): FilmDao

    companion object{

        @Volatile
        private var INSTANCE: LocalDatabase? = null

        fun init(context: Context) : LocalDatabase {

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