package com.example.movieappnahian.di

import android.content.Context
import com.example.movieappnahian.Api.NowShowingObject
import com.example.movieappnahian.Api.PopularObject
import com.example.movieappnahian.Api.genreObject
import com.example.movieappnahian.daos.MovieDaos
import com.example.movieappnahian.db.MovieDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object ModuleDI {

    @Provides
    fun ProvideDaos(@ApplicationContext context: Context) :MovieDaos{
        return  MovieDataBase.getDB(context).getDao()
    }
   @Provides
   fun ProvideGenre(@ApplicationContext context: Context) : genreObject {
        return  genreObject
    }

    @Provides
    fun ProvideNowShowing(@ApplicationContext context: Context) : NowShowingObject {
        return  NowShowingObject
    }

    @Provides
    fun ProvidePopularMovies(@ApplicationContext context: Context) : PopularObject {
        return  PopularObject
    }


}