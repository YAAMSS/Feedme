package com.segui.dinnerdecider

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.segui.models.Food

class FoodViewModel(application: Application) : AndroidViewModel(Application()){

    private var foodRepository: FoodRepository
    var food: LiveData<List<Food>>

    init {
        val foodDao = FoodDatabase.getInstance(application).foodDao()
        foodRepository = FoodRepository(foodDao)
        food = foodRepository.food
    }

}