package com.lkrfnr.cinephileapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
    entity = User::class,
    parentColumns = arrayOf("user_id"),
    childColumns = arrayOf("user_id_fk"),
    onDelete = ForeignKey.CASCADE
    )]
)

data class Comment(
    @PrimaryKey
    val comment_id:Int,
    @ColumnInfo(name = "user_id_fk")
    val user_id: Int,
    val film_id: Int,
    val comment_text: String,
    val comment_like_count: Int,
    val comment_dislike_count: Int,
    val date: String
    )
