package com.thiago.cache

import androidx.lifecycle.LiveData

interface DatabaseImplementation<T> {

    fun insertDatabase(hero: T)

    fun getDatabase(): LiveData<List<T>>
}