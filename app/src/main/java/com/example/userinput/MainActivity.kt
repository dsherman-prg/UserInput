package com.example.userinput

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    var totalTip: Double = 0.00
    var priceOfMeal: Double = 0.00
    var tipChoice = ""
    var tipPercentage: Double = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val meal: EditText = findViewById(R.id.txtMealCost)
        val group: Spinner = findViewById(R.id.spnGroup)
        val charges: Button = findViewById(R.id.btnTip)
        val result: TextView = findViewById(R.id.txtResult)

        charges.setOnClickListener {
            priceOfMeal = meal.text.toString().toDouble()
            val currency = DecimalFormat("$###,###.00")
            tipChoice = group.selectedItem.toString()

            when(tipChoice){
                "5%" -> tipPercentage = .05
                "10%" -> tipPercentage = .1
                "15%" -> tipPercentage = .15
                "20%" -> tipPercentage = .2
                "25%" -> tipPercentage = .25
            }

            totalTip = priceOfMeal * tipPercentage
            val totalTipFormatted = currency.format(totalTip)

            result.text = "Calculated tip price is: $totalTipFormatted"
        }
    }
}