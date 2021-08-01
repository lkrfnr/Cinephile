package com.lkrfnr.cinephileapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.lkrfnr.cinephileapp.R
import com.lkrfnr.cinephileapp.databinding.FragmentHomeBinding
import com.lkrfnr.cinephileapp.network.RetrofitClient
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularBase
import com.lkrfnr.cinephileapp.network.model.movie.moviepopular.MoviePopularResult
import com.lkrfnr.cinephileapp.network.services.movie.MoviePopularService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import okhttp3.Dispatcher
import retrofit2.Retrofit

class HomeFragment : Fragment() {

    private lateinit var binding : FragmentHomeBinding
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

        val retrofitClient : Retrofit = RetrofitClient.getRetrofitInstance()
        val popularMoviesService : MoviePopularService = retrofitClient.create(MoviePopularService::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response = popularMoviesService
                .getPopularMovies(
                     resources.getString(R.string.api_key),
                    "en-US",
                    1)

            if(response.isSuccessful){
                val res : MoviePopularBase? = response.body()
                val movieList : List<MoviePopularResult>?  = res?.results

                for ( movie in movieList !! ){
                    Log.i(TAG, movie.overview)
                }

            }
        }

    }

}