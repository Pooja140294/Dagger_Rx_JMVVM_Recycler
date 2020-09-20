package com.example.airtel.detail.factory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.airtel.data.repository.MovieRepository
import com.example.airtel.detail.MovieDetailViewModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MovieDetailViewModelFactory @Inject constructor(private val movieRepository: MovieRepository) : ViewModelProvider.NewInstanceFactory(){

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MovieDetailViewModel(movieRepository) as T

    }

}