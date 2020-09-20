package com.example.airtel.detail.di

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.airtel.data.repository.MovieRepository
import com.example.airtel.detail.MovieDetailActivity
import com.example.airtel.detail.MovieDetailViewModel
import com.example.airtel.detail.factory.MovieDetailViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieDetailModule{

    @Provides
    fun provideDetailViewModelFactory(movieRepository : MovieRepository) = MovieDetailViewModelFactory(movieRepository)

    @Provides
    fun provideDetailViewModel(factory : MovieDetailViewModelFactory, activity : MovieDetailActivity) = ViewModelProviders
        .of(activity as AppCompatActivity, factory)
        .get(MovieDetailViewModel::class.java)

}