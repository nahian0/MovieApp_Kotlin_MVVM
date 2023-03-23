package com.example.movieappnahian.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.movieappnahian.entities.BookmarkModel
import com.example.movieappnahian.repos.BookmarksRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class BookmarksViewModel @Inject constructor (private val repository: BookmarksRepository): ViewModel() {

    var isBookmarkedLiveData: MutableLiveData<Boolean> = MutableLiveData()





    fun insertBookMarks(bookmarkModel: BookmarkModel){
        viewModelScope.launch {
            repository.insertBookMarks(bookmarkModel)
        }
    }


    fun getBookmarkByid(id:Int?){
        viewModelScope.launch {
            try {
             repository.getMovieByID(id)
                isBookmarkedLiveData.value = repository.bookmarkModel != null

                //Log.e("isBookmarked",isBookmarkedLiveData.value.toString())
            }
            catch (e:Exception){

            }
        }
    }



    fun deleteBookMarks(id: Int?){
        viewModelScope.launch {
            try {
                repository.deleteBookMarks(id)
            }catch (e:Exception){}
        }
    }

    fun getAllmovies(): LiveData<List<BookmarkModel>> = repository.getAllmovies()

}