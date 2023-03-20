package com.example.movieappnahian.viewmodels

import GenreModel
import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movieappnahian.daos.MovieDaos
import com.example.movieappnahian.db.MovieDataBase
import com.example.movieappnahian.entities.Genre
import com.example.movieappnahian.repos.GenreRepos
import kotlinx.coroutines.launch

class GenresViewModel(application: Application):AndroidViewModel(application) {


    private  var repository:GenreRepos

    private  var dao: MovieDaos
    init {
        dao = MovieDataBase.getDB(application).getDao()
       repository = GenreRepos(dao)
    }

   val genreLiveData: MutableLiveData<GenreModel> = MutableLiveData()

    fun getGenres(){
        viewModelScope.launch {
            try {
                genreLiveData.value = repository.getGenres()

              //Log.e("MovieViewModel", repository.getGenres().toString())
            }catch (e: Exception) {

            }
        }
    }

    fun insertGenres(g: Genre){

        viewModelScope.launch {
            try {
                repository.insertGenres(g)

                Log.e("MovieViewModel", repository.getGenres().toString())
            }catch (e: Exception) {

            }
        }


    }


}