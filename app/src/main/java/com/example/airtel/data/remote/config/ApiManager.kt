package com.example.airtel.data.remote.config

import com.example.airtel.data.remote.sources.MovieSearchResponse
import com.example.airtel.data.remote.sources.MovieService
import retrofit2.Retrofit

class ApiManager(private val retrofit : Retrofit) {

    val movieService : MovieService by lazy {
        retrofit.create(MovieService::class.java)
    }

}