package com.thiago.marvelapp.di.cache

import com.thiago.cache.DatabaseRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

val cacheModule = module{

    single<DatabaseRepository>{
        DatabaseRepository(androidApplication())
    }
}
