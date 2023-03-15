package com.example.movieappnahian.repos

import com.example.movieappnahian.Api.PopularObject
import com.example.movieappnahian.model.PopularMovieModel


class PopularMovieRepos {

    suspend fun getPopularMovies(page: Int): PopularMovieModel {
        val endUrl = "movie/popular?api_key=${api_key}&language=en-US&page=${page}"
        return PopularObject.popularMoviesApiService.getPopularMovies(endUrl)
    }
}