package com.example.movieappnahian.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieappnahian.daos.MovieDaos
import com.example.movieappnahian.entities.BookmarkModel


class BookmarksRepository(private var dao:MovieDaos) {
    val bookmarkedList: MutableLiveData <List<BookmarkModel>> = MutableLiveData()

    var bookmarkModel: BookmarkModel? = null



    suspend fun insertBookMarks(bookmarkModel: BookmarkModel){
        try {
            dao.insertIntoBookmarks(bookmarkModel)
        }catch (e:Exception){}

    }

    suspend fun deleteBookMarks(id: Int?){
        try {
            dao.deleteFromBookMarksById(id)
        }catch (e:Exception){}
    }

    suspend fun getMovieByID(id: Int?) {
        try {
         bookmarkModel= dao.getMovieById(id)
        }
        catch (e:Exception){}
    }
    fun getAllmovies():LiveData<List<BookmarkModel>> = dao.getAllBookMarks()
}