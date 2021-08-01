package com.lkrfnr.cinephileapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.lkrfnr.cinephileapp.R
import com.lkrfnr.cinephileapp.databinding.FragmentFilmBinding

class FilmFragment : Fragment() {

    private lateinit var binding : FragmentFilmBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_film, container, false)

        return binding.root
    }
}