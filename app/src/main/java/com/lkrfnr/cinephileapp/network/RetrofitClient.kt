package com.lkrfnr.cinephileapp.network

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {
        val BASE_URL = "https://api.themoviedb.org/3/"
        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
                    .build()
        }

    }
}