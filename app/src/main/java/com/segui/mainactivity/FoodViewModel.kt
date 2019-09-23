package com.segui.mainactivity

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.segui.database.FoodDatabase
import com.segui.repository.FoodRepository
import com.segui.model.Food

class FoodViewModel(application: Application) : AndroidViewModel(Application()){

    private var foodRepository: FoodRepository
    var food: LiveData<List<Food>>

    init {
        val foodDao = FoodDatabase.getInstance(application).foodDao()
        foodRepository = FoodRepository(foodDao)
        food = foodRepository.food
    }

}