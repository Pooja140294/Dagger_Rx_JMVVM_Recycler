package com.example.airtel.search.factories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.airtel.data.repository.MovieRepository
import com.example.airtel.search.MovieSearchViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieSearchViewModelFactory @Inject constructor(private val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieSearchViewModel(movieRepository) as T

    }

}