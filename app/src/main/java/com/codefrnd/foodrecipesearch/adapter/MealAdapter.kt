package com.codefrnd.foodrecipesearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.codefrnd.foodrecipesearch.R
import com.codefrnd.foodrecipesearch.db.entity.Meal
import kotlinx.android.synthetic.main.item_meal.view.*

class MealAdapter : RecyclerView.Adapter<MealAdapter.MealHolder> {

    inner class MealHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    private val differCallBack = object : DiffUtil.ItemCallback<Meal>() {
        override fun areItemsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem.idMeal == newItem.idMeal
        }

        override fun areContentsTheSame(oldItem: Meal, newItem: Meal): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, differCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealHolder {
        return MealHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)
        )
    }

    override fun onBindViewHolder(holder: MealHolder, position: Int) {
        val meal = differ.currentList[position]
        holder.itemView.apply {
            Glide.with(this).load(meal.strMealThumb).into(meal_iv)
            meal_str_tv.text = meal.strMeal
            meal_category_tv.text = meal.strCategory
            meal_area_tv.text = meal.strArea
            setOnItemClickListener {
                onItemClickListener?.let { it(meal) }
            }
        }
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var onItemClickListener: ((Meal) -> Unit)? = null

    fun setOnItemClickListener(listener: (Meal) -> Unit) {
        onItemClickListener = listener
    }
}