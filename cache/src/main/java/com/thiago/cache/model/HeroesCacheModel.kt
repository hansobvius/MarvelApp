package com.thiago.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "heroes_table")
class HeroesCacheModel(
        @PrimaryKey @ColumnInfo(name = "heroId") val heroId: Int,
        @ColumnInfo(name = "name") val name: String,
        @ColumnInfo(name = "descripion") val description: String,
        @ColumnInfo(name = "image") val image: String)
