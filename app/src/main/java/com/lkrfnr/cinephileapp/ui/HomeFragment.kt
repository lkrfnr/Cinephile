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
import com.lkrfnr.cinephileapp.network.RetrofitClient
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephileapp.network.services.movie.MoviePopularService
import com.lkrfnr.cinephileapp.persistance.LocalDatabase
import com.lkrfnr.cinephileapp.viewmodel.HomeViewModel
import com.lkrfnr.cinephileapp.viewmodel.HomeViewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.Retrofit

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
            homeViewModel = ViewModelProvider(
                    activity,
                    HomeViewModelFactory(
                            LocalDatabase.getInstance(activity.applicationContext)
                    )
            ).get(HomeViewModel::class.java)
        } ?: throw AssertionError("Unable to get parent activity from fragment")


        GlobalScope.launch(Dispatchers.IO) {
            val list : List<MoviePopularResult>  =  homeViewModel.getPopularMovies()

            for( item in list )
                Log.i(TAG, item.title)

        }



    }

}