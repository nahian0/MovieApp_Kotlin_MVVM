package com.example.movieappnahian.repos


import GenreModel
import androidx.lifecycle.LiveData
import com.example.movieappnahian.Api.genreObject
import com.example.movieappnahian.daos.MovieDaos
import com.example.movieappnahian.entities.Genre
import javax.inject.Inject


class GenreRepos @Inject constructor(private  val dao: MovieDaos, private val genreObjectDi: genreObject){

    //private  var dao: MovieDaos = MovieDataBase.getDB(context).getDao()

    suspend fun getGenres(): GenreModel {
        val endUrl = "genre/movie/list?api_key=${api_key}&language=en-US"
        return genreObjectDi.apiServiceGenre.getGenres(endUrl)
    }

    suspend fun insertGenres(genre: Genre){
     dao.insertIntoGenre(genre)

    }

    suspend fun getGenreByID(id: Int) = dao.getGenreById(id)

     fun getGenreDataByID(id : Int) :LiveData<List<Genre>> = dao.getGenreDataByID(id)
}