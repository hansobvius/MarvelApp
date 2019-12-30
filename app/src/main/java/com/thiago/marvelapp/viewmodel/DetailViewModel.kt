package com.thiago.marvelapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.thiago.marvelapp.model.HeroesEntity

class DetailViewModel(application: Application): AndroidViewModel(application) {

    private val _heroes = MutableLiveData<HeroesEntity>()

    val heroes: LiveData<HeroesEntity>
        get() = _heroes

    fun insertValue(heroesEntity: HeroesEntity){
        _heroes.value = heroesEntity
    }
}