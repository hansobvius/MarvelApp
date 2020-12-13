package com.thiago.cache

import android.content.Context
import androidx.lifecycle.LiveData
import com.thiago.cache.builder.DatabaseBuilder
import com.thiago.cache.dao.ProjectDao
import com.thiago.cache.model.HeroesCacheModel

class DatabaseRepository(context: Context): DatabaseImplementation<HeroesCacheModel> {

    private val database: ProjectDao = DatabaseBuilder.getInstance(context.applicationContext)!!.projectDao

    override fun insertDatabase(hero: HeroesCacheModel) {
        database.insertHero(hero)
    }

    override fun getDatabase(): LiveData<List<HeroesCacheModel>> = database.getHeroesList()
}