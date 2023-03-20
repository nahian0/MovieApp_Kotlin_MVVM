package com.example.movieappnahian.viewmodels

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.movieappnahian.daos.MovieDaos
import com.example.movieappnahian.db.MovieDataBase
import com.example.movieappnahian.entities.BookmarkModel
import com.example.movieappnahian.repos.BookmarksRepository
import kotlinx.coroutines.launch

class BookmarksViewModel(application: Application): AndroidViewModel(application) {

    var repository: BookmarksRepository

    var isBookmarkedLiveData: MutableLiveData<Boolean> = MutableLiveData()
      var dao: MovieDaos
    init {
        dao = MovieDataBase.getDB(application).getDao()
        repository = BookmarksRepository(dao)
    }


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

                Log.e("isBookmarked",isBookmarkedLiveData.value.toString())
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