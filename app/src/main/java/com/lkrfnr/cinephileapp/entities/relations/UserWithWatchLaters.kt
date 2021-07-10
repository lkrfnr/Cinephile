package com.lkrfnr.cinephileapp.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.lkrfnr.cinephileapp.entities.Comment
import com.lkrfnr.cinephileapp.entities.Film
import com.lkrfnr.cinephileapp.entities.User
import com.lkrfnr.cinephileapp.entities.WatchLater


data class UserWithWatchLaters(

    @Embedded val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "user_owner_id"
    )

    val watchLaters: List<WatchLater>
)