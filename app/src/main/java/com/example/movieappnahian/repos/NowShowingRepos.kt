package com.example.movieappnahian.repos


import com.example.movieappnahian.Api.NetworkService
import com.example.movieappnahian.model.NowShowingModel

const val api_key = "2bd6abca42954ca4fce07eedac57c3d1"

class NowShowingRepos {

    suspend fun fetchNowShowing(page: Int): NowShowingModel {
        val endUrl = "movie/now_playing?api_key=${api_key}&language=en-US&page=${page}"
        return NetworkService.nowShowingApiService.getNowShowing(endUrl)
    }
}