package com.example.movieappnahian.repos


import com.example.movieappnahian.Api.NowShowingObject
import com.example.movieappnahian.model.NowShowingModel
import javax.inject.Inject

const val api_key = "7891436f22ccc147037bfd45c7ed95d5"

class NowShowingRepos @Inject constructor(private val nowShowingObjectDi: NowShowingObject) {

    suspend fun getNowShowingMovie(page: Int): NowShowingModel {
        val endUrl = "movie/now_playing?api_key=${api_key}&language=en-US&page=${page}"
        return nowShowingObjectDi.nowShowingApiService.getNowShowing(endUrl)
    }
}