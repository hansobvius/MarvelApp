package com.thiago.cache.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thiago.cache.model.HeroesCacheModel

@Dao
interface ProjectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertHero(hero: HeroesCacheModel)

    @Query("SELECT * FROM heroes_table")
    fun getHeroesList(): LiveData<List<HeroesCacheModel>>
}