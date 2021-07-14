package com.lkrfnr.cinephileapp.persistance.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.lkrfnr.cinephileapp.persistance.entities.Comment
import com.lkrfnr.cinephileapp.persistance.entities.Film

data class FilmWithComments(

    @Embedded val film: Film,
    @Relation(
        parentColumn = "film_id",
        entityColumn = "film_owner_id"
    )

    val commentsList: List<Comment>

)