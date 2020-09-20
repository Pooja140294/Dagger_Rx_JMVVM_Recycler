package com.example.airtel.di.modules

import com.example.airtel.data.remote.config.ApiManager
import com.example.airtel.data.remote.sources.MovieSource
import com.example.airtel.data.repository.MovieRepository
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class DataSourceResolver {


    @Singleton
    @Provides
    fun provideMovieDataSource(    @Named("apikey")
                                   apiKey : String, apiManager : ApiManager) : MovieSource = MovieSource(apiKey, apiManager.movieService)

    @Singleton
    @Provides
    fun provideMovieRepository(movieSource: MovieSource) : MovieRepository = MovieRepository(movieSource)

}