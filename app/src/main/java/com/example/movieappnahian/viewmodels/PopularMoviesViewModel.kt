package com.example.movieappnahian.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappnahian.model.PopularMovieModel
import com.example.movieappnahian.repos.PopularMovieRepos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PopularMoviesViewModel @Inject constructor (private val repository:PopularMovieRepos ) : ViewModel() {

    val popularmovieslivedata: MutableLiveData<PopularMovieModel> = MutableLiveData()

    fun getPopularMovie(page:Int){
        viewModelScope.launch {
            try {
                popularmovieslivedata.value = repository.getPopularMovies(page)

//
            }catch (e: Exception) {

            }
        }
    }
}