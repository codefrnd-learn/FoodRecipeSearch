package com.codefrnd.foodrecipesearch.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.codefrnd.foodrecipesearch.R
import com.codefrnd.foodrecipesearch.ui.HomeActivity
import com.codefrnd.foodrecipesearch.ui.MealViewModel

class SearchFoodFragment: Fragment(R.layout.fragment_search_food) {

    lateinit var viewModel: MealViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = (activity as HomeActivity).viewModel
    }
}