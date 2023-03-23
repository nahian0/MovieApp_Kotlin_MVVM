package com.example.movieappnahian.repos

import com.example.movieappnahian.Api.PopularObject
import com.example.movieappnahian.model.PopularMovieModel
import javax.inject.Inject


class PopularMovieRepos @Inject constructor(private val popularObjectDi: PopularObject) {

    suspend fun getPopularMovies(page: Int): PopularMovieModel {
        val endUrl = "movie/popular?api_key=${api_key}&language=en-US&page=${page}"
        return popularObjectDi.popularMoviesApiService.getPopularMovies(endUrl)
    }
}