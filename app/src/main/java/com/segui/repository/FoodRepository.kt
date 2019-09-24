package com.segui.repository

import androidx.lifecycle.LiveData
import com.segui.dao.FoodDao
import com.segui.model.Food

class FoodRepository(val foodDao: FoodDao) {

    val foodList: LiveData<List<Food>> = foodDao.getAll()

    val foodCount = foodDao.getDataCount()

    fun insert(food: Food) {
        foodDao.insert(food)
    }
}