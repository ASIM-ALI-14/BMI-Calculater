// ResultScreen.kt
package com.example.bmi.Veiw


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.bmi.BMIViewModel
import com.example.bmicalculater.Model.rememberClickFeedback
import kotlin.text.format


@Composable
fun ResultCard(viewModel: BMIViewModel,
               onClose: () -> Unit ) {

    val bmi = viewModel.calculateBMI()
    val bmiValue = String.format("%.1f", bmi)
    val category = viewModel.getBMICategory(bmi)
    val (minHealthy, maxHealthy) = viewModel.getHealthyWeightRange()
    val colors = listOf(
        Color(0xFF58CCEF),
        Color(0xFF5C934A),
        Color(0xFFFFEB3B),
        Color.Red
    )
    val clickFeedback = rememberClickFeedback()


    ElevatedCard(
        modifier = Modifier
            .size(370.dp, 435.dp),
        shape = RoundedCornerShape(21.dp),
        colors = CardDefaults.elevatedCardColors(
            containerColor = Color(0xFFFBF6EE) // your background color
        )
    )

    {
        Column(
            modifier = Modifier
                .fillMaxWidth(),

            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(23.dp))
            // Title
            Text(
                text = "Your BMI:",
                fontSize = 19.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Spacer(modifier = Modifier.height(13.dp))
            // BMI Value
            Text(
                text = bmiValue,
                fontSize = 64.sp,
                fontWeight = FontWeight.ExtraBold,
                color = Color(0xFF65B741)
            )
            Spacer(modifier = Modifier.height(27.dp))
            // Category


            Text(
                text = category,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier
                    .background(
                        Color(if (category == "Normal") (0xFF5C934A) else if (category == "Overweight") (0xFFFF0000) else if (category == "Underweight") (0xFF58CCEF) else (0xFF58CCEF)),
                        shape = RoundedCornerShape(10)
                    )
                    .padding(5.dp)

            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow {
                items(40) { index ->
                    Brick(
                        color = colors[index / 10]
                    )
                    Spacer(modifier = Modifier.width(2.dp))
                }
            }
            Spacer(modifier = Modifier.height(12.dp))


            // User Data Row - Now using the height from ViewModel
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 13.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                DataColumn(value = "${viewModel.weight} kg", label = "Weight")
                DataColumn(
                    value = "${viewModel.height} cm",
                    label = "Height"
                )  // This comes from HeightTracker
                DataColumn(value = "${viewModel.age}", label = "Age")
                DataColumn(value = viewModel.gender, label = "Gender")
            }

            // Healthy Weight Range
            Text(
                text = "Healthy weight for the height:",
                fontSize = 18.sp,
                color = Color.Black,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            Text(
                text = "$minHealthy kg - $maxHealthy kg",
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color(0xFF65B741),
                modifier = Modifier.padding(bottom = 17.dp)
            )

            // Close Button
            Button(
                onClick = {
                    clickFeedback()
                    onClose()},
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .padding(horizontal = 12.dp),
                shape = RoundedCornerShape(12.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF65B741),
                    contentColor = Color.White
                )
            ) {
                Text(
                    text = "Close",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }

        }
    }
}


@Composable
fun Brick(color: Color) {
    Box(
        modifier = Modifier
            .size(6.dp, 20.dp)
            .background(
                color = color,
                shape = CircleShape
            )
    )
}


@Composable
private fun DataColumn(value: String, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            text = value,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF65B741)
        )
        Text(
            text = label,
            fontSize = 16.sp,
            color = Color(0xFFB2B2B2)
        )
    }
}

