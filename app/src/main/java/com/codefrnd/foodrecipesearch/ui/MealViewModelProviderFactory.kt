package com.codefrnd.foodrecipesearch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.codefrnd.foodrecipesearch.repo.MealRepository

class MealViewModelProviderFactory(
    private val mealRepository: MealRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MealViewModel(mealRepository) as T
    }
}