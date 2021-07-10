package com.lkrfnr.cinephileapp.entities.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.lkrfnr.cinephileapp.entities.Comment
import com.lkrfnr.cinephileapp.entities.Film
import com.lkrfnr.cinephileapp.entities.User

data class FilmWithComments(

    @Embedded val film: Film,
    @Relation(
        parentColumn = "film_id",
        entityColumn = "film_owner_id"
    )

    val commentsList: List<Comment>

)