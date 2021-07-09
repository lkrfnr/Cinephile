package com.lkrfnr.cinephileapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class User(
    @PrimaryKey(autoGenerate = true)
    val user_id: Int,
    val user_name: String,
    val user_mail: String,
    val bio_text: String,
    val short_desc_text: String
)