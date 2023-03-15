package com.example.movieappnahian.Api


import com.example.movieappnahian.model.NowShowingModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url



interface NowShowingApiService {
    @GET()
    suspend fun getNowShowing(@Url endUrl: String): NowShowingModel
}


object NowShowingObject {

    val nowShowingApiService: NowShowingApiService by lazy {
        retrofit.create(NowShowingApiService::class.java)
    }
}

const val base_url = "https://api.themoviedb.org/3/"

val retrofit = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()