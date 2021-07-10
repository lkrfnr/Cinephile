package com.lkrfnr.cinephileapp.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class WatchLater(

    @PrimaryKey
    @ColumnInfo(name = "watch_later_id") val watchLaterId:Long,
    @ColumnInfo(name = "user_owner_id") val userOwnerId:Long,
    @ColumnInfo(name = "film_owner_id") val filmOwnerId:Long,
    @ColumnInfo(name = "date") val date:String,

)
