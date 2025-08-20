// BMIViewModel.kt
package com.example.bmi

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class BMIViewModel : ViewModel() {
    var height by mutableStateOf(170)
    var weight by mutableStateOf(65)

    var age by mutableStateOf(26)
    var gender by mutableStateOf("male")

    fun calculateBMI(): Double {
        val heightInMeters = height / 100.0
        return weight / (heightInMeters * heightInMeters)
    }

    fun getBMICategory(bmi: Double): String {
        return when {
            bmi < 18.5 -> "Underweight"
            bmi < 25 -> "Normal"
            bmi < 30 -> "Overweight"
            else -> "Obese"
        }
    }

    fun getHealthyWeightRange(): Pair<Int, Int> {
        val heightInMeters = height / 100.0
        val lower = (18.5 * heightInMeters * heightInMeters).toInt()
        val upper = (24.9 * heightInMeters * heightInMeters).toInt()
        return Pair(lower, upper)
    }
}