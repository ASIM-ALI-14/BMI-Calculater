package com.example.bmicalculater.Veiw


import android.R.attr.onClick
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height

import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons

import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight


import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.bmi.BMIViewModel
import com.example.bmi.Veiw.ResultCard
import com.example.bmicalculater.Model.rememberClickFeedback
import com.example.bmicalculater.R


@Composable
fun SecondScreen(
    viewModel: BMIViewModel,
    onBack: () -> Unit,
    onCalculate: () -> Unit
)  {
    val clickFeedback = rememberClickFeedback()
    var weight by remember { mutableStateOf(viewModel.weight) }
    var age by remember { mutableStateOf(viewModel.age) }
    var showui by remember { mutableStateOf(false) }


    var gender by remember { mutableStateOf("Male") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)

            .padding(
                WindowInsets.systemBars.only(WindowInsetsSides.Top + WindowInsetsSides.Bottom)
                    .asPaddingValues()
            )


    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 50.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 13.dp)
            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .clickable {
                            clickFeedback()

                            onBack()
                                   },


                    tint = Color(0xFF65B741)
                )
                Spacer(Modifier.width(43.dp))
                Text(
                    text = "BMI",

                    fontSize = 35.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFFFFB534)
                )
                Spacer(Modifier.width(9.dp))
                Text(
                    text = "Calculator",

                    fontWeight = FontWeight.ExtraBold, fontSize = 35.sp, color = Color(0xFF65B741)
                )
            }
            Spacer(modifier = Modifier.height(29.dp))
            Text(text = "Please Modify the values", fontSize = 25.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(40.dp))
            Row() {
                ElevatedCard(
                    modifier = Modifier.size(170.dp, 185.dp),
                    shape = RoundedCornerShape(21.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = Color(0xFFFBF6EE) // your background color
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(Modifier.height(23.dp))
                        Text(
                            text = "Weight(kg)",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily(Font(R.font.quicksand_bold)),
                            color = Color(0xFFACACAC)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = "$weight",
                            fontSize = 46.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFCE922A)
                        )
                        Spacer(Modifier.height(12.dp))

                        Row() {
                            ElevatedButton(
                                onClick = {
                                    clickFeedback()
                                    if (weight > 1) weight-- },
                                shape = CircleShape,
                                colors = ButtonDefaults.elevatedButtonColors(
                                    containerColor = Color.White, // Circle background
                                    contentColor = Color(0xFF996515) // Brown minus
                                ),
                                elevation = ButtonDefaults.elevatedButtonElevation(
                                    defaultElevation = 4.dp
                                ),
                                modifier = Modifier.size(40.dp), // Circle size
                                contentPadding = PaddingValues(0.dp) // 🔹 Remove default padding
                            ) {

                                Canvas(modifier = Modifier.size(20.dp)) {
                                    val thickness = 5.dp.toPx() // height of the minus bar
                                    val barWidth = 24.dp.toPx() // width of the minus bar

                                    // Calculate offsets to center the shape
                                    val xOffset = (size.width - barWidth) / 2
                                    val yOffset = (size.height - thickness) / 2

                                    drawRoundRect(
                                        color = Color(0xFF996515),
                                        topLeft = Offset(
                                            xOffset, yOffset
                                        ),
                                        size = Size(barWidth, thickness),
                                        cornerRadius = CornerRadius(50f, 50f) // rounded ends
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(39.dp))
                            ElevatedButton(
                                onClick = {
                                    clickFeedback()
                                    weight++ },
                                shape = CircleShape,
                                colors = ButtonDefaults.elevatedButtonColors(
                                    containerColor = Color.White, // Circle background
                                    contentColor = Color(0xFF996515) // Brown minus
                                ),
                                elevation = ButtonDefaults.elevatedButtonElevation(
                                    defaultElevation = 4.dp
                                ),
                                modifier = Modifier.size(40.dp), // Circle size
                                contentPadding = PaddingValues(0.dp) // 🔹 Remove default padding
                            ) {

                                Canvas(modifier = Modifier.size(20.dp)) {
                                    val thickness = 5.dp.toPx()  // thickness of each bar
                                    val barLength = 24.dp.toPx() // length of each bar

                                    // Center offsets for horizontal bar
                                    val xOffsetH = (size.width - barLength) / 2
                                    val yOffsetH = (size.height - thickness) / 2

                                    // Center offsets for vertical bar
                                    val xOffsetV = (size.width - thickness) / 2
                                    val yOffsetV = (size.height - barLength) / 2

                                    // Horizontal bar
                                    drawRoundRect(
                                        color = Color(0xFF996515),
                                        topLeft = Offset(
                                            xOffsetH, yOffsetH
                                        ),
                                        size = Size(barLength, thickness),
                                        cornerRadius = CornerRadius(50f, 50f)
                                    )

                                    // Vertical bar
                                    drawRoundRect(
                                        color = Color(0xFF996515),
                                        topLeft = Offset(
                                            xOffsetV, yOffsetV
                                        ),
                                        size = Size(thickness, barLength),
                                        cornerRadius = CornerRadius(50f, 50f)
                                    )
                                }

                            }


                        }

                    }
                }
                Spacer(modifier = Modifier.width(29.dp))
                ElevatedCard(
                    modifier = Modifier.size(170.dp, 185.dp),
                    shape = RoundedCornerShape(21.dp),
                    colors = CardDefaults.elevatedCardColors(
                        containerColor = Color(0xFFFBF6EE) // your background color
                    )
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize(),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Spacer(Modifier.height(23.dp))
                        Text(
                            text = "Age",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.ExtraBold,
                            fontFamily = FontFamily(Font(R.font.quicksand_bold)),
                            color = Color(0xFFACACAC)
                        )
                        Spacer(Modifier.height(8.dp))
                        Text(
                            text = "$age",
                            fontSize = 46.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = Color(0xFFCE922A)
                        )
                        Spacer(Modifier.height(12.dp))

                        Row() {
                            ElevatedButton(
                                onClick = {
                                    clickFeedback()
                                    if (age > 1) age-- },
                                shape = CircleShape,
                                colors = ButtonDefaults.elevatedButtonColors(
                                    containerColor = Color.White, // Circle background
                                    contentColor = Color(0xFF996515) // Brown minus
                                ),
                                elevation = ButtonDefaults.elevatedButtonElevation(
                                    defaultElevation = 4.dp
                                ),
                                modifier = Modifier.size(40.dp), // Circle size
                                contentPadding = PaddingValues(0.dp) // 🔹 Remove default padding
                            ) {

                                Canvas(modifier = Modifier.size(20.dp)) {
                                    val thickness = 5.dp.toPx() // height of the minus bar
                                    val barWidth = 24.dp.toPx() // width of the minus bar

                                    // Calculate offsets to center the shape
                                    val xOffset = (size.width - barWidth) / 2
                                    val yOffset = (size.height - thickness) / 2

                                    drawRoundRect(
                                        color = Color(0xFF996515),
                                        topLeft = Offset(
                                            xOffset, yOffset
                                        ),
                                        size = Size(barWidth, thickness),
                                        cornerRadius = CornerRadius(50f, 50f) // rounded ends
                                    )
                                }
                            }
                            Spacer(modifier = Modifier.width(39.dp))
                            ElevatedButton(
                                onClick = {
                                    clickFeedback()
                                    age++ },
                                shape = CircleShape,
                                colors = ButtonDefaults.elevatedButtonColors(
                                    containerColor = Color.White, // Circle background
                                    contentColor = Color(0xFF996515) // Brown minus
                                ),
                                elevation = ButtonDefaults.elevatedButtonElevation(
                                    defaultElevation = 4.dp
                                ),
                                modifier = Modifier.size(40.dp), // Circle size
                                contentPadding = PaddingValues(0.dp) // 🔹 Remove default padding
                            ) {

                                Canvas(modifier = Modifier.size(20.dp)) {
                                    val thickness = 5.dp.toPx()  // thickness of each bar
                                    val barLength = 24.dp.toPx() // length of each bar

                                    // Center offsets for horizontal bar
                                    val xOffsetH = (size.width - barLength) / 2
                                    val yOffsetH = (size.height - thickness) / 2

                                    // Center offsets for vertical bar
                                    val xOffsetV = (size.width - thickness) / 2
                                    val yOffsetV = (size.height - barLength) / 2

                                    // Horizontal bar
                                    drawRoundRect(
                                        color = Color(0xFF996515),
                                        topLeft = Offset(
                                            xOffsetH, yOffsetH
                                        ),
                                        size = Size(barLength, thickness),
                                        cornerRadius = CornerRadius(50f, 50f)
                                    )

                                    // Vertical bar
                                    drawRoundRect(
                                        color = Color(0xFF996515),
                                        topLeft = Offset(
                                            xOffsetV, yOffsetV
                                        ),
                                        size = Size(thickness, barLength),
                                        cornerRadius = CornerRadius(50f, 50f)
                                    )
                                }

                            }


                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(36.dp))
            HeightTracker(viewModel = viewModel)
            Spacer(modifier = Modifier.height(49.dp))
            Button(
                onClick = {
                    clickFeedback()
                    viewModel.weight = weight

                    viewModel.age = age
                    showui = true
                },
                contentPadding = PaddingValues(

                    vertical = 20.dp
                ),
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 36.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF65B741),
                    contentColor = Color.White,

                    )
            ) {
                Text(text = "Continue", fontSize = 25.sp)
            }


        }
        if (showui) {
            AnimatedVisibility(
                visible = showui,
                enter = fadeIn() + scaleIn(),
                exit = fadeOut() + scaleOut()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black.copy(alpha = 0.3f)),
                    contentAlignment = Alignment.Center
                ) {
                    ResultCard(
                        viewModel = viewModel,
                        onClose = {

                            showui = false } // 🔹 closes dialog only
                    )
                }
            }
        }
    }
}
