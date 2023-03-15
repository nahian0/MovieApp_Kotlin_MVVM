package com.example.movieappnahian.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappnahian.model.PopularMovieModel
import com.example.movieappnahian.repos.PopularMovieRepos
import kotlinx.coroutines.launch

class PopularMoviesViewModel : ViewModel() {
   private val repository = PopularMovieRepos()
    val popularmovieslivedata: MutableLiveData<PopularMovieModel> = MutableLiveData()

    fun getNowShowingMovie(page:Int){
        viewModelScope.launch {
            try {
                popularmovieslivedata.value = repository.getPopularMovies(page)

//                Log.e("MovieViewModel", repository.getNowShowingMovie(page).toString())
            }catch (e: Exception) {
                Log.e("NowShowingMovieError", e.localizedMessage)
            }
        }
    }
}