package com.example.airtel.di.modules

import com.example.airtel.detail.MovieDetailActivity
import com.example.airtel.detail.di.MovieDetailModule
import com.example.airtel.search.MovieSearchActivity
import com.example.airtel.search.di.MovieSearchModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityResolver {

    @ContributesAndroidInjector(modules = arrayOf(MovieSearchModule::class))
    abstract fun provideSearchActivity(): MovieSearchActivity

    @ContributesAndroidInjector(modules = arrayOf(MovieDetailModule::class))
    abstract fun provideDetailActivity(): MovieDetailActivity
}