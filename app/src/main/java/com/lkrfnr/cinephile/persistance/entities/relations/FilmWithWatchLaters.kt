package com.lkrfnr.cinephileapp.persistance.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.lkrfnr.cinephile.persistance.entities.Film
import com.lkrfnr.cinephile.persistance.entities.WatchLater

data class FilmWithWatchLaters(

    @Embedded val film: Film,
    @Relation(
        parentColumn = "film_id",
        entityColumn = "film_owner_id"
    )

    val commentsList: List<WatchLater>
)