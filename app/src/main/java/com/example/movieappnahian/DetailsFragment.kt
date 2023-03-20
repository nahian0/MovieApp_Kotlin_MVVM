package com.example.movieappnahian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.movieappnahian.databinding.FragmentDetailsBinding
import com.example.movieappnahian.entities.BookmarkModel
import com.example.movieappnahian.viewmodels.BookmarksViewModel


class DetailsFragment : Fragment() {
    lateinit var  binding :FragmentDetailsBinding
    private lateinit var bookmarksViewModel : BookmarksViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)

        bookmarksViewModel = ViewModelProvider(requireActivity()).get(BookmarksViewModel::class.java)

        var movietitle : String? = arguments?.getString("movieTitle")
        var movieId : Int? = arguments?.getInt("movieId",0)
        var posterPath : String? = arguments?.getString("posterPath")
        val voteAverage = arguments?.getDouble("voteAverage")
        val backdroppath = arguments?.getString("backdropath")
        val description = arguments?.getString("movieDetails")
        val genrelist = arguments?.getString("genreList")


        val b = BookmarkModel(bookmarkId = movieId,
            title = movietitle,
            voteAverage = voteAverage.toString(),
           // genreList = genrelist,
            posterPath = posterPath,)



        bookmarksViewModel.getBookmarkByid(movieId)
        bookmarksViewModel.isBookmarkedLiveData.observe(viewLifecycleOwner){ bookmarked->
            if (bookmarked){
                binding.addToBookmark.setImageDrawable(resources.getDrawable(R.drawable.bookmarked))
                binding.addToBookmark.setOnClickListener { bookmarksViewModel.deleteBookMarks(movieId)

                }
            }else{
                binding.addToBookmark.setImageDrawable(resources.getDrawable(R.drawable.bookmark_uncheked))
                binding.addToBookmark.setOnClickListener{

                    bookmarksViewModel.insertBookMarks(b)
                }
            }
            bookmarksViewModel.getBookmarkByid(movieId)
        }




        binding.movieTitle.text = movietitle
        binding.movieRating.text =voteAverage.toString()+"/10"
        binding.movieDescription.text=description

        Glide.with(requireActivity())
            .load("https://image.tmdb.org/t/p/w500/"+backdroppath)
            .into(binding.imageView5)


        return binding.root
    }


}