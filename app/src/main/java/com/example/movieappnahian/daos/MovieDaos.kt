package com.example.movieappnahian.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.movieappnahian.entities.Bookmark

@Dao
interface MovieDaos{
    @Insert
    suspend fun insertIntoBookmarks(bookmark: Bookmark)

    @Query("delete from bookmark_table where bookmark_Id = :bookmarkId")
    suspend fun deleteFromBookMarksById(bookmarkId : Long)

    @Query("select * from bookmark_table where bookmark_Id = :bookmarkId")
    suspend fun getMovieById(bookmarkId : Long) : Bookmark?

    @Query("select * from bookmark_table")
    fun getAllBookMarks() : LiveData<List<Bookmark>>




}