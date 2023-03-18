package com.example.movieappnahian.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.movieappnahian.databinding.NowShowingLayoutBinding
import com.example.movieappnahian.model.NowShowingModel

class NowShowingAdapter(val callback:(NowShowingLayoutBinding,NowShowingModel.Result,Int)->Unit) : ListAdapter<NowShowingModel.Result, NowShowingAdapter.NowShowingViewHolder>(
    MovieDiffUtil()
){

    class NowShowingViewHolder(val binding: NowShowingLayoutBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(movieinfo: NowShowingModel.Result) {
            binding.nowShowing=movieinfo
            //Log.e("MovieViewModel", movieinfo.toString())

        }
    }

    class MovieDiffUtil : DiffUtil.ItemCallback<NowShowingModel.Result>() {
        override fun areItemsTheSame(oldItem: NowShowingModel.Result, newItem: NowShowingModel.Result): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NowShowingModel.Result, newItem: NowShowingModel.Result): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NowShowingViewHolder {
        val binding = NowShowingLayoutBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return NowShowingViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NowShowingViewHolder, position: Int) {
        val nowshowingmoviemodel = getItem(position)

        holder.bind(nowshowingmoviemodel)
        callback(holder.binding,nowshowingmoviemodel,position)


    }
}