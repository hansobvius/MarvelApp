package com.thiago.cache

import androidx.lifecycle.LiveData
import com.thiago.cache.model.HeroesCacheModel

interface DatabaseImplementation {

    fun insertDatabase(hero: HeroesCacheModel)

    fun getDatabase(): LiveData<List<HeroesCacheModel>>
}