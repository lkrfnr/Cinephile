package com.lkrfnr.cinephile.persistance.entities.relations

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Relation
import com.lkrfnr.cinephile.persistance.entities.Comment
import com.lkrfnr.cinephile.persistance.entities.User

// this should not be an entity because it is a relation..
data class UserWithComments(

    @Embedded val user: User,
    @Relation(
        parentColumn = "user_id",
        entityColumn = "user_owner_id"
    )

    val commentsList: List<Comment>

)
