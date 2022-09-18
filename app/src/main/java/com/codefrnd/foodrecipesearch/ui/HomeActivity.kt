package com.codefrnd.foodrecipesearch.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.codefrnd.foodrecipesearch.R
import com.codefrnd.foodrecipesearch.db.MealDB
import com.codefrnd.foodrecipesearch.repo.MealRepository
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var viewModel: MealViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val repository = MealRepository(MealDB(this))
        val provider = MealViewModelProviderFactory(repository)
        viewModel = ViewModelProvider(this, provider)[MealViewModel::class.java]

        bottom_navigation_view.setupWithNavController(food_nav_host_fragment.findNavController())
    }
}