package com.thiago.marvelapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import com.thiago.data.DataProject
import com.thiago.marvelapp.mapper.EntityMapper
import com.thiago.marvelapp.model.HeroesEntity

class HeroesViewModel(
    application: Application,
    private val dataProject: DataProject?,
    private val mapper: EntityMapper?): AndroidViewModel(application){

    private val _navigateToHero = MutableLiveData<HeroesEntity>()

    val navigateToHero: LiveData<HeroesEntity>
        get() = _navigateToHero

    private val _data = MutableLiveData<List<HeroesEntity>>()

    val data: LiveData<List<HeroesEntity>>
        get() = _data

    fun getDatabase(): LiveData<List<HeroesEntity>>? {
        val datalist = dataProject!!.getProject()
        return Transformations.map(datalist){
           it.map {
               mapper!!.dataToPresentation(it)
           }
        }
    }

    fun displayPropertyDetail(heroesEntity: HeroesEntity){
        _navigateToHero.value = heroesEntity
    }

    fun heroesDetailCompleted(){
        _navigateToHero.value = null
    }
}