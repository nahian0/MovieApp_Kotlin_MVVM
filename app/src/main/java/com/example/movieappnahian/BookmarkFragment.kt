package com.example.movieappnahian

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.movieappnahian.adapters.BookmarkAdapter
import com.example.movieappnahian.databinding.FragmentBookmarkBinding
import com.example.movieappnahian.viewmodels.BookmarksViewModel


class BookmarkFragment : Fragment() {
    lateinit var  binding : FragmentBookmarkBinding
    private lateinit var bookmarksViewModel : BookmarksViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding =  FragmentBookmarkBinding.inflate(inflater,container,false)

        bookmarksViewModel = ViewModelProvider(requireActivity()).get(BookmarksViewModel::class.java)


        val adapterBookmark = BookmarkAdapter{binding,bookmark,position->
            binding.delateIcon.setOnClickListener{
                bookmarksViewModel.deleteBookMarks(bookmark.bookmarkId)
            }
        }

        binding.BookmarkRecycleView.layoutManager=LinearLayoutManager(activity)
        binding.BookmarkRecycleView.adapter =adapterBookmark



        bookmarksViewModel.getAllmovies().observe(requireActivity()) {movieList->
            adapterBookmark.submitList(movieList)
            //Log.e("title", "onCreateView: "+movieList.get(0).title )
        }

        // Inflate the layout for this fragment
        return binding.root
    }


}