package com.example.movieappnahian.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappnahian.databinding.PopularMoviesLayoutBinding
import com.example.movieappnahian.model.PopularMovieModel

class PopularMoviesAdapter(val callback : (movie : PopularMovieModel.Result,
                                           binding : PopularMoviesLayoutBinding,value : Int) -> Unit) : ListAdapter<PopularMovieModel.Result, PopularMoviesAdapter.PopularMovieHolder>(
    MovieDiffUtil()
){

    class PopularMovieHolder(val binding: PopularMoviesLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieinfo: PopularMovieModel.Result) {
            binding.popularmovies=movieinfo
            //Log.e("MovieViewModel", movieinfo.toString())

        }
    }

    class MovieDiffUtil : DiffUtil.ItemCallback<PopularMovieModel.Result>() {
        override fun areItemsTheSame(oldItem: PopularMovieModel.Result, newItem: PopularMovieModel.Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: PopularMovieModel.Result, newItem: PopularMovieModel.Result): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieHolder{
        val binding = PopularMoviesLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PopularMovieHolder(binding)
    }

    override fun onBindViewHolder(holder: PopularMovieHolder, position: Int) {
        val popularmoviemodel = getItem(position)

        holder.bind(popularmoviemodel)
       // callback(holder.binding,popularmoviemodel,position)

        callback(popularmoviemodel,holder.binding,2)

        holder.binding.popularMovieLayout.setOnClickListener {
            callback(popularmoviemodel,holder.binding,1)
        }


    }
}