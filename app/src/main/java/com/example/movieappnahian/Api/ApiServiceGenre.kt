package com.example.movieappnahian.Api


import GenreModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url



interface ApiServiceGenre {
    @GET()
    suspend fun getGenres(@Url endUrl: String): GenreModel
}


object genreObject {

    val apiServiceGenre: ApiServiceGenre by lazy {
        retrofit2.create(ApiServiceGenre::class.java)
    }
}



val retrofit2 = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()