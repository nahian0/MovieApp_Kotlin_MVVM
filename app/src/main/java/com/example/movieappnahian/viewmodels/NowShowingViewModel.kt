package com.example.movieappnahian.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappnahian.model.NowShowingModel
import com.example.movieappnahian.repos.NowShowingRepos
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NowShowingViewModel @Inject constructor(private val repository: NowShowingRepos)  : ViewModel() {

   val nowshowinglivedata: MutableLiveData<NowShowingModel> = MutableLiveData()

    fun getNowShowingMovie(page:Int){
        viewModelScope.launch {
            try {
                nowshowinglivedata.value = repository.getNowShowingMovie(page)

//
            }catch (e: Exception) {

            }
        }
    }
}