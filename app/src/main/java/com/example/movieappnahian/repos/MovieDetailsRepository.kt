package com.example.movieappnahian.repos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.movieappnahian.daos.MovieDaos
import com.example.movieappnahian.entities.Bookmark


class MovieDetailsRepository(private var dao:MovieDaos) {
    private var bookMarkLiveData = MutableLiveData<Bookmark>()
    val detailsLiveData : LiveData<Bookmark>
        get() = bookMarkLiveData


    suspend fun insertBookMarks(bookmarkModel: Bookmark){
        try {
            dao.insertIntoBookmarks(bookmarkModel)
        }catch (e:Exception){}

    }

    suspend fun deleteBookMarks(id: Long){
        try {
            dao.deleteFromBookMarksById(id)
        }catch (e:Exception){}
    }
        suspend fun getAllmovies(){
        try {
           dao.getAllBookMarks()

        }catch (e:Exception){}

    }
}