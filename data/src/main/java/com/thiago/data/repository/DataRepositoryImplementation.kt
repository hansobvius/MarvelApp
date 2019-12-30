package com.thiago.data.repository

import androidx.lifecycle.LiveData
import com.thiago.data.model.HeroesDataModel

interface DataRepositoryImplementation {

    fun fetchData()

    fun getData(): LiveData<List<HeroesDataModel>>
}