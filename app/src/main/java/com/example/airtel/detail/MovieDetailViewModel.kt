package com.example.airtel.detail

import androidx.lifecycle.ViewModel
import com.example.airtel.data.remote.sources.MovieDetailRequest
import com.example.airtel.data.remote.sources.MovieDetailResponse
import com.example.airtel.data.remote.sources.MovieSearchRequest
import com.example.airtel.data.remote.sources.Rating
import com.example.airtel.data.repository.MovieRepository
import com.example.airtel.di.Injector
import com.example.airtel.search.adapter.SearchListItem
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.util.concurrent.TimeUnit

class MovieDetailViewModel(val movieRespository : MovieRepository) : ViewModel() {

    fun getMovieDetail(movieId : String): Single<MovieDetailResponse> {
        val detailRequest = MovieDetailRequest(movieId)
         return movieRespository.getMovieDetail(detailRequest)
             .map {
                 val ratings = it.ratings?.map {
                    val rating = "${it.source} : ${it.value}"
                     Rating(source = rating, value = null)
                 }
                 it.copy(ratings = ratings)
             }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}