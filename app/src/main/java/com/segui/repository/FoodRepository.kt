package com.segui.repository

import androidx.lifecycle.LiveData
import com.segui.dao.FoodDao
import com.segui.model.Food

class FoodRepository(foodDao: FoodDao) {

    val food: LiveData<List<Food>> = foodDao.getAll()
}