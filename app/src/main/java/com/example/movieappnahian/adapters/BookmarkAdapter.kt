package com.example.movieappnahian.adapters

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappnahian.databinding.BookmarksLayoutBinding
import com.example.movieappnahian.entities.BookmarkModel

class BookmarkAdapter(val callback:(BookmarksLayoutBinding,BookmarkModel,Int)->Unit) : ListAdapter<BookmarkModel, BookmarkAdapter.BookmarkViewHolder>(
    MovieDiffUtil()
){

    class BookmarkViewHolder(val binding: BookmarksLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(bookmark: BookmarkModel) {
            Log.e("title", "onCreateView: "+bookmark)
            this.binding.bookmark=bookmark

        }
    }

    class MovieDiffUtil : DiffUtil.ItemCallback<BookmarkModel>() {
        override fun areItemsTheSame(oldItem: BookmarkModel, newItem:BookmarkModel): Boolean {
            return oldItem.id== newItem.id
        }

        override fun areContentsTheSame(oldItem: BookmarkModel, newItem:BookmarkModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder{
        val binding = BookmarksLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return BookmarkViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        val nowshowingmoviemodel = getItem(position)

        holder.bind(nowshowingmoviemodel)
        callback(holder.binding,nowshowingmoviemodel,position)


    }
}