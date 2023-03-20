package com.example.movieappnahian.repos


import GenreModel
import com.example.movieappnahian.Api.genreObject
import com.example.movieappnahian.daos.MovieDaos
import com.example.movieappnahian.entities.Genre


class GenreRepos (private var dao: MovieDaos){

    suspend fun getGenres(): GenreModel {
        val endUrl = "genre/movie/list?api_key=${api_key}&language=en-US"
        return genreObject.apiServiceGenre.getGenres(endUrl)
    }

    suspend fun insertGenres(genre: Genre){
     dao.insertIntoGenre(genre)

    }

    suspend fun getGenreByID(id: Int?) =dao.getGenreById(id)
}