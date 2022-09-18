package com.codefrnd.foodrecipesearch.ui

import androidx.lifecycle.ViewModel
import com.codefrnd.foodrecipesearch.repo.MealRepository

class MealViewModel(
    val mealRepository: MealRepository
): ViewModel() {
}