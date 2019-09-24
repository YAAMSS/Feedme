package com.segui.mainactivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.segui.database.FoodDatabase
import com.segui.repository.FoodRepository
import com.segui.model.Food
import kotlinx.coroutines.launch

class FoodViewModel(application: Application) : AndroidViewModel(application){

    private val repository: FoodRepository
    val allFood: LiveData<List<Food>>
    val foodCount: Int

    init {
        val foodDao = FoodDatabase.getInstance(application).foodDao()
        repository = FoodRepository(foodDao)
        allFood = repository.foodList
        foodCount = repository.foodCount
    }

    fun insert(food: Food) = viewModelScope.launch {
        repository.insert(food)
    }

}