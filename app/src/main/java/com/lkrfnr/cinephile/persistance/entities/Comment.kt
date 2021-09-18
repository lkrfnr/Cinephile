package com.lkrfnr.cinephile.persistance.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Comment(

    @PrimaryKey
    @ColumnInfo(name = "comment_id") val commentId:Long,
    @ColumnInfo(name = "film_owner_id") val filmOwnerId:Long,
    @ColumnInfo(name = "user_owner_id") val userOwnerId: Long,
    @ColumnInfo(name = "comment_text") val commentText: String,
    @ColumnInfo(name = "comment_like_count") val commentLikeCount: Int,
    @ColumnInfo(name = "comment_dislike_count") val commentDislikeCount: Int,
    @ColumnInfo(name = "date") val date: String

)


/*@Entity(
    foreignKeys = [ForeignKey(
    entity = User::class,
    parentColumns = arrayOf("user_id"),
    childColumns = arrayOf("user_id_fk"),
    onDelete = ForeignKey.CASCADE
    )]
)*/