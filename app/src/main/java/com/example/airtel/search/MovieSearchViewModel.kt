package com.example.airtel.search

import androidx.lifecycle.ViewModel
import com.example.airtel.data.remote.sources.MovieSearchRequest
import com.example.airtel.data.repository.MovieRepository
import com.example.airtel.di.Injector
import com.example.airtel.search.adapter.SearchListItem
import com.google.gson.Gson
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import java.lang.IllegalStateException
import java.util.concurrent.TimeUnit

class MovieSearchViewModel(val movieRespository : MovieRepository) : ViewModel() {

    fun searchMovie(query : String): Observable<List<SearchListItem>> {
         return Observable.just(query)
             .map{if (it.isEmpty()){
                  return@map throw IllegalStateException("empty string")
             }
                 return@map it
             }
             .debounce(500, TimeUnit.MILLISECONDS)
             .flatMap {
                 val searchRequest = MovieSearchRequest(it)
                 movieRespository.searchMovie(searchRequest).toObservable()
             }.map {response ->
                response.search?.map {movieDetail ->
                    SearchListItem(
                        imageUrl = movieDetail.poster ?: "",
                        movieTitle = movieDetail?.title ?: "",
                        movieReleaseYear = movieDetail.year ?: "",
                        movieId = movieDetail.imdbID ?: "",
                        movieType = movieDetail.type ?: ""
                    )
                }?: emptyList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }


}