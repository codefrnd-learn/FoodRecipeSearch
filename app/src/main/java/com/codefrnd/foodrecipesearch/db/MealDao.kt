package com.codefrnd.foodrecipesearch.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.codefrnd.foodrecipesearch.db.entity.Meal

@Dao
interface MealDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertMeal(meal: Meal): Long

    @Query("SELECT * FROM meal")
    fun getMeal(): LiveData<List<Meal>>

    @Delete
    suspend fun deleteMeal(meal: Meal)
}