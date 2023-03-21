package com.example.movieappnahian

import Genress
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappnahian.adapters.NowShowingAdapter
import com.example.movieappnahian.adapters.PopularMoviesAdapter
import com.example.movieappnahian.databinding.FragmentHomePageBinding
import com.example.movieappnahian.entities.Genre
import com.example.movieappnahian.model.NowShowingModel
import com.example.movieappnahian.model.PopularMovieModel
import com.example.movieappnahian.viewmodels.GenresViewModel
import com.example.movieappnahian.viewmodels.NowShowingViewModel
import com.example.movieappnahian.viewmodels.PopularMoviesViewModel


class HomePageFragment : Fragment() {
    private var pagenumberNowshowing = 1
    private  var pagenumberPopularMovies =1


    private lateinit var binding: FragmentHomePageBinding

    //view models
    private val nowshowingviewmodel: NowShowingViewModel by activityViewModels()
    private val popularmovievwmodel: PopularMoviesViewModel by activityViewModels()
    private val genreviewmodel: GenresViewModel by activityViewModels()
    //data lists
    var nowShowingMovieList = mutableListOf<NowShowingModel.Result>()
    var popularMovieList = mutableListOf<PopularMovieModel.Result>()
    var genreList = mutableListOf<GenresViewModel>()
    var genresDataList  = ArrayList<Genress>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentHomePageBinding.inflate(inflater, container, false)

        val adapterNowShowing = NowShowingAdapter {binding,nowShowingMovie,position->
             binding.nowShowingLayout.setOnClickListener {
                 findNavController().navigate(R.id.action_homePageFragment_to_detailsFragment,args= bundleOf("movieId" to nowShowingMovie.id,"movieTitle" to nowShowingMovie.title,"posterPath" to nowShowingMovie.posterPath,"movieDetails" to nowShowingMovie.overview,"genrelist" to nowShowingMovie.genreIds,"backdropath" to nowShowingMovie.backdropPath,"voteAverage" to nowShowingMovie.voteAverage))
             }

        }
        /*val adapeterPopularMovies =PopularMoviesAdapter{binding,popularmoviemodel,position->
            binding.popularMovieLayout.setOnClickListener{
                findNavController().navigate(R.id.action_homePageFragment_to_detailsFragment, args =bundleOf("movieId" to popularmoviemodel.id,"movieTitle" to popularmoviemodel.title,"posterPath" to popularmoviemodel.posterPath,"movieDetails" to popularmoviemodel.overview,"genrelist" to popularmoviemodel.genreIds,"backdropath" to popularmoviemodel.backdropPath,"voteAverage" to popularmoviemodel.voteAverage))
            }
        }*/

        val adapeterPopularMovies = PopularMoviesAdapter{movie,binding,value  ->
            if(value==2){
                Log.e("callback2", "onCreateView: insert" )
                for(i in 0..movie.genreIds.size - 1){
                    var genre_ids = movie.genreIds.get(i)
                    genreviewmodel.getGenreDataByID(genre_ids).observe(viewLifecycleOwner){
                        for(i in 0..it.size - 1){
                            it.forEach{
                                if(genre_ids==it.id){
                                    val dynamicTextView = TextView(requireContext())
                                    dynamicTextView.text = it.name
                                    dynamicTextView.setBackgroundResource(R.drawable.genres_border)
                                    val params = LinearLayout.LayoutParams(
                                        LinearLayout.LayoutParams.WRAP_CONTENT,
                                        LinearLayout.LayoutParams.WRAP_CONTENT)
                                    params.setMargins(0, 10, 15, 5)

                                    dynamicTextView.layoutParams = params
                                    binding.popularGanerRVID.addView(dynamicTextView)
                                }

                            }
                        }

                    }
                }


            }else if(value==1){
                Log.e("callback", "onCreateView: insert" )
                findNavController().navigate(R.id.action_homePageFragment_to_detailsFragment, args =bundleOf("movieId" to movie.id,"movieTitle" to movie.title,"posterPath" to movie.posterPath,"movieDetails" to movie.overview,"genrelist" to movie.genreIds,"backdropath" to movie.backdropPath,"voteAverage" to movie.voteAverage))

            }




        }
      //Now showing movies
        binding.NowShowingRecycleView.layoutManager = LinearLayoutManager(activity,LinearLayoutManager.HORIZONTAL,false)
        binding.NowShowingRecycleView.adapter =adapterNowShowing
        nowshowingviewmodel.getNowShowingMovie(pagenumberNowshowing)
        genreviewmodel.getGenres()

        genreviewmodel.genreLiveData.observe(viewLifecycleOwner){
            G->
            Log.e("MovieViewModel",  G.genres.toString())
           for (i in 0..G.genres.size){

               genreviewmodel.insertGenres(
                   Genre(
                       genre_id =G.genres[i].id,
                       name = G.genres[i].name

                   )
               )
           }

        }

        genreviewmodel.getGenresById(10749)
        genreviewmodel.getGenresLiveData.observe(viewLifecycleOwner){
           // Log.e("fadsssssssssssssssssssssssssssssssssssssssssssssssss",  it.name)

        }




        nowshowingviewmodel.nowshowinglivedata.observe(viewLifecycleOwner){

           M->
            //Log.e("MovieViewModel",  M.results.toString())

            adapterNowShowing.submitList(M.results)



        }

        //popular movies

        binding.PopularMoviesRecyleView.layoutManager =LinearLayoutManager(activity)
        binding.PopularMoviesRecyleView.adapter =adapeterPopularMovies
        popularmovievwmodel.getPopularMovie(pagenumberPopularMovies)



        popularmovievwmodel.popularmovieslivedata.observe(viewLifecycleOwner){
            M->

          /*  M.results.forEach({
                for(i in 0..it.genreIds.size-1 ){
                    genreviewmodel.getGenresById(it.genreIds.get(i)).observe(requireActivity(),{G ->
                        Log.e("genres", "onCreateView: "+G.name )
                        //it.genresList.add(Genress(id=G.id, name = G.name))

                    })



                }
                //Log.e("genresdfsaaaaaaaaaaaaaaaaaaaaaaaaaa", it.genresList.toString())
            })*/


           /* M.results[0].genresList =  genresDataList
            Log.e("genres", genresDataList.size.toString())
            Log.e("genres", M.results[0].genresList.size.toString())*/

            adapeterPopularMovies.submitList(M.results)
        }





        return binding.root
    }
}