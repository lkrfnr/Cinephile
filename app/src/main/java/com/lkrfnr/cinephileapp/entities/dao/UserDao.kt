package com.lkrfnr.cinephileapp.entities.dao

import androidx.room.*
import com.lkrfnr.cinephileapp.entities.Comment
import com.lkrfnr.cinephileapp.entities.User
import com.lkrfnr.cinephileapp.entities.WatchLater
import com.lkrfnr.cinephileapp.entities.relations.UserWithComments
import com.lkrfnr.cinephileapp.entities.relations.UserWithWatchLaters

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWatchLater(watchLater: WatchLater)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertComment(comment: Comment)

    @Transaction
    @Query("SELECT * FROM User WHERE user_id = :userId")
    suspend fun getUserWithComments(userId: String) : List<UserWithComments>

    @Transaction
    @Query("SELECT * FROM User WHERE user_id = :userId")
    suspend fun getUserWithWatchLaters(userId: String) : List<UserWithWatchLaters>

    @Query("SELECT * FROM User")
    suspend fun getUsers() : List<User>

}