package com.example.movieappnahian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.example.movieappnahian.databinding.FragmentDetailsBinding
import com.example.movieappnahian.viewmodels.MovieDetailsViewModel


class DetailsFragment : Fragment() {
    lateinit var  binding :FragmentDetailsBinding
    private lateinit var movieDetailsViewModel : MovieDetailsViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailsBinding.inflate(inflater,container,false)

        var movietitle = arguments?.getString("moviename")
        val backdroppath = arguments?.getString("backdrobpath")
        val averagerating = arguments?.getDouble("voteaverage")
        val description = arguments?.getString("description")
        binding.movieTitle.text = movietitle
        binding.movieRating.text =averagerating.toString()+"/10"
        binding.movieDescription.text=description

        Glide.with(requireActivity())
            .load("https://image.tmdb.org/t/p/w500/"+backdroppath)
            .into(binding.imageView5)
        binding.addToBookmark.setOnClickListener {

        }

        return binding.root
    }


}