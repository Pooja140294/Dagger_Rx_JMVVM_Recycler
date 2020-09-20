package com.example.airtel.di

import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.airtel.data.remote.config.ApiManager
import com.example.airtel.data.remote.config.BaseUrl
import com.example.airtel.data.remote.sources.MovieSource
import com.example.airtel.data.repository.MovieRepository
import com.example.airtel.detail.MovieDetailViewModel
import com.example.airtel.detail.factory.MovieDetailViewModelFactory
import com.example.airtel.search.MovieSearchViewModel
import com.example.airtel.search.factories.MovieSearchViewModelFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object Resolver {

    fun provideOkHttpClient() : OkHttpClient = OkHttpClient
        .Builder()
        .build()

    fun provideRetrofitClient(okHttpClient : OkHttpClient) : Retrofit{
       return Retrofit.Builder()
            .baseUrl(BaseUrl.dev)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    fun provideApiManager(retrofit: Retrofit) = ApiManager(retrofit)

    fun provideApiKey() : String = "b6573989"

    fun provideMovieDataSource(apiKey : String, apiManager : ApiManager) : MovieSource = MovieSource(apiKey, apiManager.movieService)

    fun provideMovieRepository(movieSource: MovieSource) : MovieRepository = MovieRepository(movieSource)

    fun provideSearchViewModelFactory(movieRepository : MovieRepository) = MovieSearchViewModelFactory(movieRepository)

    fun provideSearchViewModel(factory : MovieSearchViewModelFactory, activity : FragmentActivity) = ViewModelProviders
        .of(activity, factory)
        .get(MovieSearchViewModel::class.java)

    fun provideDetailViewModelFactory(movieRepository : MovieRepository) = MovieDetailViewModelFactory(movieRepository)

    fun provideDetailViewModel(factory : MovieDetailViewModelFactory, activity : FragmentActivity) = ViewModelProviders
        .of(activity, factory)
        .get(MovieDetailViewModel::class.java)

}