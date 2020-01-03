package com.thiago.marvelapp

import android.app.Application
import com.thiago.marvelapp.di.app.detailViewModelModule
import com.thiago.marvelapp.di.app.viewModelModule
import com.thiago.marvelapp.di.data.dataModule
import com.thiago.marvelapp.di.remote.remoteModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class AppApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initializeKoinComponent()
    }

    fun initializeKoinComponent(){
        startKoin{
            androidLogger()
            androidContext(this@AppApplication)
            modules(listOf(
                dataModule,
                remoteModule,
                viewModelModule,
                detailViewModelModule
            ))
        }
    }
}