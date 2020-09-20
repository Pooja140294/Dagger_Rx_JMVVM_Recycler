package com.example.airtel.di.modules

import com.example.airtel.data.remote.config.ApiManager
import com.example.airtel.data.remote.config.BaseUrl
import com.example.airtel.detail.MovieDetailActivity
import com.example.airtel.search.MovieSearchActivity
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class NetworkResolver {

    @Provides
    @Named("apikey")
    fun provideApiKey() : String = "b6573989"

    @Singleton
    @Provides
    fun provideOkHttpClient() : OkHttpClient = OkHttpClient
        .Builder()
        .build()

    @Singleton
    @Provides
    fun provideRetrofitClient(okHttpClient : OkHttpClient) : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BaseUrl.dev)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
    }

    @Singleton
    @Provides
    fun provideApiManager(retrofit: Retrofit) = ApiManager(retrofit)

}