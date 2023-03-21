package com.example.movieappnahian.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.movieappnahian.entities.BookmarkModel
import com.example.movieappnahian.entities.Genre

@Dao
interface MovieDaos{

    //Bookmark
    @Insert
    suspend fun insertIntoBookmarks(bookmark: BookmarkModel)

    @Query("delete from bookmark_table where bookmark_Id = :bookmarkId")
    suspend fun deleteFromBookMarksById(bookmarkId : Int?)

    @Query("select * from bookmark_table where bookmark_Id = :bookmarkId")
    suspend fun getMovieById(bookmarkId : Int?) : BookmarkModel?

    @Query("select * from bookmark_table")
    fun getAllBookMarks() : LiveData<List<BookmarkModel>>

    //Genre
    @Insert
    suspend fun insertIntoGenre(genre: Genre)

    @Query("select * from genre_table where genre_id = :genreId")
    suspend fun getGenreById(genreId: Int?) : Genre?

    @Query("select * from genre_table where id = :id")
     fun getGenreDataByID(id : Int) : LiveData<List<Genre>>







}