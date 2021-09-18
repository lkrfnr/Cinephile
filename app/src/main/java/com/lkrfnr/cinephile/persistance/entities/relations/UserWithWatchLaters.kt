package com.lkrfnr.cinephile.persistance.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.lkrfnr.cinephile.persistance.entities.User
import com.lkrfnr.cinephile.persistance.entities.WatchLater


data class UserWithWatchLaters(

    @Embedded val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "user_owner_id"
    )

    val watchLaters: List<WatchLater>
)