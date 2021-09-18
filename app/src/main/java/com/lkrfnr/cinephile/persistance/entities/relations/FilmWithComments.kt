package com.lkrfnr.cinephile.persistance.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.lkrfnr.cinephile.persistance.entities.Comment
import com.lkrfnr.cinephile.persistance.entities.Film

data class FilmWithComments(

    @Embedded val film: Film,
    @Relation(
        parentColumn = "film_id",
        entityColumn = "film_owner_id"
    )

    val commentsList: List<Comment>

)