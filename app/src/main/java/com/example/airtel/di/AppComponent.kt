package com.example.airtel.di

import android.app.Application
import com.example.airtel.AirtelApplication
import com.example.airtel.di.modules.ActivityResolver
import com.example.airtel.di.modules.DataSourceResolver
import com.example.airtel.di.modules.NetworkResolver
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = arrayOf(
        AndroidSupportInjectionModule::class,
        NetworkResolver::class,
        ActivityResolver::class,
        DataSourceResolver::class
    )
)
interface AppComponent : AndroidInjector<AirtelApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: AirtelApplication): Builder

        fun build(): AppComponent
    }
}