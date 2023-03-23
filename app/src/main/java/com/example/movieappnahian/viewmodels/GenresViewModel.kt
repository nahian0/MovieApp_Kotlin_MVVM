package com.example.movieappnahian.viewmodels

import GenreModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappnahian.entities.Genre
import com.example.movieappnahian.repos.GenreRepos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class GenresViewModel@Inject constructor(private  val repository:GenreRepos) : ViewModel() {

   val genreLiveData: MutableLiveData<GenreModel> = MutableLiveData()

   var genreLiveDataValue: LiveData<List<Genre>> = MutableLiveData()

    val getGenresLiveData: MutableLiveData<Genre> = MutableLiveData()





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

               // Log.e("MovieViewModel", repository.getGenres().toString())
            }catch (e: Exception) {

            }
        }


    }


    fun getGenresById(id: Int) : LiveData<Genre>{

        viewModelScope.launch {
            try {
                getGenresLiveData.value=   repository.getGenreByID(id)

               // Log.e("MovieViewModel", repository.getGenres().toString())
            }catch (e: Exception) {

            }
        }

        return getGenresLiveData


    }

    fun getGenreDataByID(id : Int) : LiveData<List<Genre>>{
        try {
            viewModelScope.launch {
                repository.getGenreDataByID(id)
                genreLiveDataValue = repository.getGenreDataByID(id)
            }
        }catch (e:Exception){}
        return genreLiveDataValue
    }


}