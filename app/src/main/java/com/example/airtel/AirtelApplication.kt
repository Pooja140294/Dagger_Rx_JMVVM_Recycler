package com.example.airtel

import com.example.airtel.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AirtelApplication : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent
        .builder()
        .application(this)
        .build()
}