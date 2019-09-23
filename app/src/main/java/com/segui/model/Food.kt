package com.segui.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Food(
    @PrimaryKey
    @ColumnInfo(name = "food_name")
    val foodName: String
)