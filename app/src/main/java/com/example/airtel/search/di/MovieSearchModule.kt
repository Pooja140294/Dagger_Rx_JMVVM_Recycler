package com.example.airtel.search.di

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModelProviders
import com.example.airtel.data.repository.MovieRepository
import com.example.airtel.search.MovieSearchActivity
import com.example.airtel.search.MovieSearchViewModel
import com.example.airtel.search.factories.MovieSearchViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieSearchModule{

    @Provides
    fun provideSearchViewModelFactory(movieRepository : MovieRepository) = MovieSearchViewModelFactory(movieRepository)

    @Provides
    fun provideSearchViewModel(factory : MovieSearchViewModelFactory, activity : MovieSearchActivity) = ViewModelProviders
        .of(activity as AppCompatActivity, factory)
        .get(MovieSearchViewModel::class.java)

}