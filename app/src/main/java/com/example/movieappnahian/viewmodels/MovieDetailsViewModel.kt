package com.example.movieappnahian.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.movieappnahian.daos.MovieDaos
import com.example.movieappnahian.db.MovieDataBase
import com.example.movieappnahian.entities.Bookmark
import com.example.movieappnahian.repos.MovieDetailsRepository
import kotlinx.coroutines.launch

class MovieDetailsViewModel(application: Application): AndroidViewModel(application) {

    private lateinit var repository: MovieDetailsRepository
    private lateinit var dao: MovieDaos
    init {
        dao = MovieDataBase.getDB(application).getDao()
        repository = MovieDetailsRepository(dao)
    }


    fun insertBookMarks(bookmarkModel: Bookmark){
        viewModelScope.launch {
            repository.insertBookMarks(bookmarkModel)
        }
    }

    fun deleteBookMarks(id: Long){
        viewModelScope.launch {
            try {
                repository.deleteBookMarks(id)
            }catch (e:Exception){}
        }
    }

  fun getAllMovies() : LiveData<Bookmark> {
        viewModelScope.launch {
            try {
                repository.getAllmovies()
            }catch (e:Exception){}
        }
        return  repository.detailsLiveData

    }

}