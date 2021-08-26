package com.lkrfnr.cinephileapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lkrfnr.cinephileapp.R
import com.lkrfnr.cinephileapp.databinding.FragmentHomeBinding
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephileapp.network.model.search.SearchMovieResult
import com.lkrfnr.cinephileapp.ui.adapter.HomePageViewPagerAdapter
import com.lkrfnr.cinephileapp.viewmodel.HomeViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
    private lateinit var homeViewModel: HomeViewModel
    private val TAG : String = "HomeFragment"

    private lateinit var popularMovieObserver: Observer<MutableList<MoviePopularResult>>
    private lateinit var searchMovieObserver: Observer<MutableList<SearchMovieResult>>


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // init home view model
        activity?.let { activity ->
            homeViewModel = ViewModelProvider(activity).get(HomeViewModel::class.java)
        } ?: throw AssertionError("Unable to get parent activity from fragment")

        preparePopularContentViewPager()

        homeViewModel.popularMoviesList.observe(viewLifecycleOwner,popularMovieObserver)
        homeViewModel.searchMovieResultList.observe(viewLifecycleOwner,searchMovieObserver)
        //homeViewModel.searchMovieResultList.observe(viewLifecycleOwner,searchMovieObserver)

        GlobalScope.launch(Dispatchers.IO) {
            homeViewModel.getPopularMovies()
        }
    }

    private fun preparePopularContentViewPager(){
        popularMovieObserver = Observer<MutableList<MoviePopularResult>> {
            Log.i(TAG,"" + it.size)
            binding.popularContentsViewPager.adapter = HomePageViewPagerAdapter(it.subList(0,5))
        }
    }

}