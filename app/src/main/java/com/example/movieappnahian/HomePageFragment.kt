package com.example.movieappnahian

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappnahian.adapters.NowShowingAdapter
import com.example.movieappnahian.adapters.PopularMoviesAdapter
import com.example.movieappnahian.databinding.FragmentHomePageBinding
import com.example.movieappnahian.model.NowShowingModel
import com.example.movieappnahian.model.PopularMovieModel
import com.example.movieappnahian.viewmodels.NowShowingViewModel
import com.example.movieappnahian.viewmodels.PopularMoviesViewModel


class HomePageFragment : Fragment() {
    private var pagenumberNowshowing = 1
    private  var pagenumberPopularMovies =1


    private lateinit var binding: FragmentHomePageBinding

    //view models
    private val nowshowingviewmodel: NowShowingViewModel by activityViewModels()
    private val popularmovievwmodel: PopularMoviesViewModel by activityViewModels()
    //data lists
    var nowShowingMovieList = mutableListOf<NowShowingModel.Result>()
    var popularMovieList = mutableListOf<PopularMovieModel.Result>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentHomePageBinding.inflate(inflater, container, false)

        val adapterNowShowing = NowShowingAdapter {binding,nowShowingMovie,position->
             binding.nowShowingLayout.setOnClickListener {
                 findNavController().navigate(R.id.action_homePageFragment_to_detailsFragment,args= bundleOf("movieid" to nowShowingMovie.id,"moviename" to nowShowingMovie.title,"backdrobpath" to nowShowingMovie.backdropPath ,"voteaverage" to nowShowingMovie.voteAverage, "description" to nowShowingMovie.overview))
             }

        }
        val adapeterPopularMovies =PopularMoviesAdapter{binding,popularmoviemodel,position->
            binding.popularMovieLayout.setOnClickListener{
                findNavController().navigate(R.id.action_homePageFragment_to_detailsFragment, args =bundleOf("movieid" to popularmoviemodel.id,"moviename" to popularmoviemodel.title,"backdrobpath" to popularmoviemodel.backdropPath ,"voteaverage" to popularmoviemodel.voteAverage, "description" to popularmoviemodel.overview) )
            }
        }
      //Now showing movies
        binding.NowShowingRecycleView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.NowShowingRecycleView.adapter =adapterNowShowing
        nowshowingviewmodel.getNowShowingMovie(pagenumberNowshowing)

        nowshowingviewmodel.nowshowinglivedata.observe(viewLifecycleOwner){

           M->
            Log.e("MovieViewModel",  M.results.toString())

            adapterNowShowing.submitList(M.results)



        }

        //popular movies

        binding.PopularMoviesRecyleView.layoutManager =LinearLayoutManager(activity)
        binding.PopularMoviesRecyleView.adapter =adapeterPopularMovies
        popularmovievwmodel.getPopularMovie(pagenumberPopularMovies)
        popularmovievwmodel.popularmovieslivedata.observe(viewLifecycleOwner){
            M->
            adapeterPopularMovies.submitList(M.results)
        }



        return binding.root
    }
}