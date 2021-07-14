package com.lkrfnr.cinephileapp.persistance.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id") val userId: Long,
    @ColumnInfo(name = "user_name") val userName: String,
    @ColumnInfo(name = "user_mail") val userMail: String,
    @ColumnInfo(name = "bio_text") val bioText: String,
    @ColumnInfo(name = "short_desc_text") val shortDescText: String
)