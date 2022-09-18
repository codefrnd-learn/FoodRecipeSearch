package com.codefrnd.foodrecipesearch.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.codefrnd.foodrecipesearch.db.entity.Meal

@Database(entities = [Meal::class], version = 1)
abstract class MealDB : RoomDatabase() {

    abstract fun getMealDao(): MealDao

    companion object {

        @Volatile
        private var instance: MealDB? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK) {
            instance ?: createDatabase(context).also { instance = it }
        }

        private fun createDatabase(context: Context) =
            Room.databaseBuilder(
                context,
                MealDB::class.java,
                "MealDB.db"
            ).build()
    }
}