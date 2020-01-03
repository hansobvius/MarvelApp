package com.thiago.data.repository

import androidx.lifecycle.LiveData
import com.thiago.data.model.HeroesDataModel

interface DataRepositoryImplementation<T> {

    fun fetchData()

    fun getData(): LiveData<List<T>>
}