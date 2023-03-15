package com.example.movieappnahian

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappnahian.adapters.NowShowingAdapter
import com.example.movieappnahian.databinding.FragmentHomePageBinding
import com.example.movieappnahian.model.NowShowingModel
import com.example.movieappnahian.viewmodels.NowShowingViewModel


class HomePageFragment : Fragment() {
    private var pagenumber = 1
    private lateinit var binding: FragmentHomePageBinding
    private val nowshowingviewmodel: NowShowingViewModel by activityViewModels()
    var nowShowingMovieList = mutableListOf<NowShowingModel.Result>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentHomePageBinding.inflate(inflater, container, false)

        val adapter = NowShowingAdapter ()

        binding.NowShowingRecycleView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.NowShowingRecycleView.adapter =adapter
        nowshowingviewmodel.getNowShowingMovie(pagenumber)

        nowshowingviewmodel.nowshowinglivedata.observe(viewLifecycleOwner){

           M->
            Log.e("MovieViewModel",  M.results.toString())

            adapter.submitList(M.results)



        }

        return binding.root
    }
}