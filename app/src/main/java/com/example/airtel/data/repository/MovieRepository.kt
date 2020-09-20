package com.example.airtel.data.repository

import com.example.airtel.data.remote.sources.*
import io.reactivex.Single

class MovieRepository(private val movieSource : MovieSource) {

    fun searchMovie(searchRequest: MovieSearchRequest): Single<MovieSearchResponse> {
       return movieSource.searchMovie(searchRequest.query)
    }

    fun getMovieDetail(movieDetailRequest: MovieDetailRequest): Single<MovieDetailResponse> {
       return movieSource.getMovie(movieDetailRequest.movieId)

    }
}