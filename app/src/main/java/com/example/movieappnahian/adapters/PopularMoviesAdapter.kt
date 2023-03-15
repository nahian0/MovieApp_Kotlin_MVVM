//package com.example.movieappnahian.adapters
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.example.movieappnahian.databinding.NowShowingItemBinding
//import com.example.movieappnahian.model.NowShowingModel
//import com.example.movieappnahian.model.PopularMovieModel
//
//class PopularMoviesAdapter() : ListAdapter<PopularMovieModel.Result, NowShowingAdapter.NowShowingViewHolder>(
//    MovieDiffUtil()
//){
//
//    class PopularMovieHolder(val binding: NowShowingItemBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//        fun bind(movieinfo: NowShowingModel.Result) {
//            binding.nowShowing=movieinfo
//            //Log.e("MovieViewModel", movieinfo.toString())
//
//        }
//    }
//
//    class MovieDiffUtil : DiffUtil.ItemCallback<NowShowingModel.Result>() {
//        override fun areItemsTheSame(oldItem: NowShowingModel.Result, newItem: NowShowingModel.Result): Boolean {
//            return oldItem.id == newItem.id
//        }
//
//        override fun areContentsTheSame(oldItem: NowShowingModel.Result, newItem: NowShowingModel.Result): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopularMovieHolder{
//        val binding = NowShowingItemBinding.inflate(
//            LayoutInflater.from(parent.context), parent, false
//        )
//        return PopularMovieHolder(binding)
//    }
//
//    override fun onBindViewHolder(holder: PopularMovieHolder, position: Int) {
//        val nowshowingmoviemodel = getItem(position)
//
//        holder.bind(nowshowingmoviemodel)
//        // callback(holder.binding,nowshowingmoviemodel,position)
//
//
//    }
//}