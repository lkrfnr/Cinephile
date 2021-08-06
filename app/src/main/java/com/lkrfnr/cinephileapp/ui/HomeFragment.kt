package com.lkrfnr.cinephileapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.lkrfnr.cinephileapp.R
import com.lkrfnr.cinephileapp.databinding.FragmentHomeBinding
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephileapp.network.model.search.SearchMovieResult
import com.lkrfnr.cinephileapp.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private val TAG : String = "HomeFragment"


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        // init home view model
        activity?.let { activity ->
            homeViewModel = ViewModelProvider(activity).get(HomeViewModel::class.java)
        } ?: throw AssertionError("Unable to get parent activity from fragment")

        GlobalScope.launch(Dispatchers.IO) {
            val popularMovies : List<MoviePopularResult>  =  homeViewModel.getPopularMovies()

            for( item in popularMovies )
                Log.i(TAG, item.title + "\n" + item.posterPath + "\n")

            val searchResultList : List<SearchMovieResult> = homeViewModel.searchMovie("second war")

            Log.i(TAG, "\n" + "---------------------------------------" + "\n")

            for( item in searchResultList)
                Log.i(TAG, item.title + "\n" + item.poster_path + "\n")

        }



    }

}