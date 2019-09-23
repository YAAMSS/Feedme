package com.segui.dinnerdecider

import androidx.lifecycle.LiveData
import com.segui.dao.FoodDao
import com.segui.models.Food

class FoodRepository(foodDao: FoodDao) {

    val food: LiveData<List<Food>> = foodDao.getAll()
}