package com.example.movieappnahian.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappnahian.databinding.GenresListBinding
import com.example.movieappnahian.entities.Genre

class GenresAdapter() : ListAdapter<Genre, GenresAdapter.GenreViewHolder>(
    MovieDiffUtil()
){

    class GenreViewHolder(val binding: GenresListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(genre: Genre) {

            this.binding.genre=genre
        }
    }

    class MovieDiffUtil : DiffUtil.ItemCallback<Genre>() {
        override fun areItemsTheSame(oldItem: Genre, newItem:Genre): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Genre, newItem:Genre): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenreViewHolder{
        val binding = GenresListBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return GenreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: GenreViewHolder, position: Int) {
        val genreModel = getItem(position)

        holder.bind(genreModel)



    }
}