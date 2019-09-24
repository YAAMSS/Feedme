package com.segui.mainactivity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.segui.database.FoodDatabase
import com.segui.dinnerdecider.R
import com.segui.model.Food
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity  : AppCompatActivity() {

    private lateinit var viewModel: FoodViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(FoodViewModel::class.java)

        viewModel.allFood.observe(this, Observer {
            Log.d("foodlist", it.toString())
        })

        val db: FoodDatabase = FoodDatabase.getInstance(applicationContext)

        Log.d("listsize", viewModel.foodCount.toString())

        decideBtn.setOnClickListener {
            val random = Random()
            val randomFood = random.nextInt(viewModel.foodCount)
            selectedFoodTxt.text = viewModel.allFood.value?.get(randomFood).toString()
        }

        addFoodBtn.setOnClickListener {
            val newFood = Food(addFoodTxt.text.toString())
            db.foodDao().insert(newFood)
            addFoodTxt.text?.clear() }
    }
}

