package com.example.movieappnahian.repos


import com.example.movieappnahian.Api.NowShowingObject
import com.example.movieappnahian.model.NowShowingModel

const val api_key = "7891436f22ccc147037bfd45c7ed95d5"

class NowShowingRepos {

    suspend fun getNowShowingMovie(page: Int): NowShowingModel {
        val endUrl = "movie/now_playing?api_key=${api_key}&language=en-US&page=${page}"
        return NowShowingObject.nowShowingApiService.getNowShowing(endUrl)
    }
}