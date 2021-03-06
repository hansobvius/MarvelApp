package com.thiago.cache.builder

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.thiago.cache.dao.ProjectDao
import com.thiago.cache.model.HeroesCacheModel

@Database(entities = [HeroesCacheModel::class], version = 1, exportSchema= false)
abstract class DatabaseBuilder: RoomDatabase() {

    abstract val projectDao: ProjectDao

    companion object{

        private const val PROJECT_DATABASE = "project_database"

        @Volatile
        private var INSTANCE: DatabaseBuilder? = null

        fun getInstance(context: Context): DatabaseBuilder? {
            synchronized(this){
                var instance = INSTANCE
                if(instance == null){
                    instance = Room.databaseBuilder(
                            context.applicationContext,
                            DatabaseBuilder::class.java,
                            PROJECT_DATABASE)
                            .fallbackToDestructiveMigration()
                            .build()

                    INSTANCE = instance
                }
                return INSTANCE
            }
        }
    }
}