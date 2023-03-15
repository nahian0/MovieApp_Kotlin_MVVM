package com.example.movieappnahian.viewmodels

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappnahian.model.NowShowingModel
import com.example.movieappnahian.repos.NowShowingRepos
import kotlinx.coroutines.launch

class NowShowingViewModel : ViewModel() {
    val repository = NowShowingRepos()
    val nowshowinglivedata: MutableLiveData<NowShowingModel> = MutableLiveData()

    fun getNowShowingMovie(page:Int){
        viewModelScope.launch {
            try {
                nowshowinglivedata.value = repository.getNowShowingMovie(page)

//                Log.e("MovieViewModel", repository.getNowShowingMovie(page).toString())
            }catch (e: Exception) {
                Log.e("NowShowingMovieError", e.localizedMessage)
            }
        }
    }
}