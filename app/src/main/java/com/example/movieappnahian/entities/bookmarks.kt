package com.example.movieappnahian.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bookmark_table")
data class Bookmark(
    @PrimaryKey(autoGenerate = true)
    val id : Long = 0,
    @ColumnInfo(name = "bookmark_Id")
    val bookmarkId : Long,
    var title : String,
    @ColumnInfo(name = "vote_average")
    val voteAverage : String,
    @ColumnInfo(name = "genre_list")
    val genreList : String,
    @ColumnInfo(name = "poster_path")
    val posterPath : String,
)