package com.thiago.data

import android.content.Context
import androidx.lifecycle.LiveData
import com.thiago.data.model.HeroesDataModel
import com.thiago.data.repository.DataRepository

class DataProject(private val context: Context): DataImplementation<HeroesDataModel> {

    private var dataRepository: DataRepository

    init{
        dataRepository = DataRepository(context)
    }

    override fun fecthProject() {
        dataRepository.fetchData()
    }

    override fun getProject(): LiveData<List<HeroesDataModel>> = dataRepository.getData()
}