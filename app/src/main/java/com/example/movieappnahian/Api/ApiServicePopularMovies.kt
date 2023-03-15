package com.example.movieappnahian.Api



import com.example.movieappnahian.model.PopularMovieModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Url



interface PopularMoviesApiService {
    @GET()
    suspend fun getPopularMovies(@Url endUrl: String): PopularMovieModel
}


object PopularObject {

    val popularMoviesApiService: PopularMoviesApiService by lazy {
        retrofit1.create(PopularMoviesApiService::class.java)
    }
}


val retrofit1 = Retrofit.Builder()
    .baseUrl(base_url)
    .addConverterFactory(GsonConverterFactory.create())
    .build()