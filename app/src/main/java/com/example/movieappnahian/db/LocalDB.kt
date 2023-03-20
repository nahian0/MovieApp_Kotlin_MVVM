package com.example.movieappnahian.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.movieappnahian.daos.MovieDaos
import com.example.movieappnahian.entities.BookmarkModel
import com.example.movieappnahian.entities.Genre

@Database(entities = [ BookmarkModel::class, Genre::class], version = 1)
abstract class MovieDataBase : RoomDatabase(){

    abstract fun getDao() : MovieDaos

    companion object{
        @Volatile
        private  var db : MovieDataBase ? = null

        fun getDB(context : Context) : MovieDataBase {
            if(db==null){
                synchronized(this){
                    db = Room.databaseBuilder(
                        context,
                        MovieDataBase::class.java,
                        "movies"
                    ).build()
                }

            }

            return db!!
        }
    }
}