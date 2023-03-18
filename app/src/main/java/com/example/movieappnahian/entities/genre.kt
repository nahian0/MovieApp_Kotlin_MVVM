package com.example.movieappnahian.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tbl_genre")
data class Genre(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val genre_id: Int = 0,
    val name: String,
)