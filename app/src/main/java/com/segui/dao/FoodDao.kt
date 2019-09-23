package com.segui.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.segui.models.Food

@Dao
interface FoodDao {

    @Query("SELECT COUNT(food_name) FROM food")
    fun getDataCount(): Int

    @Query("SELECT * FROM food")
    fun getAll(): LiveData<List<Food>>

    @Insert
    fun insert(foods: Food)
}