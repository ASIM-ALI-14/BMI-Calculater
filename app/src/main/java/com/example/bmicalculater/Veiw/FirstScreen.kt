package com.example.bmicalculater.Veiw

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
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

import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape

import androidx.compose.material3.Button

import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.ripple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi.BMIViewModel
import com.example.bmicalculater.Model.rememberClickFeedback

import com.example.bmicalculater.R
import kotlin.let


enum class Gender {
    Female, Male
}

@Composable
fun FirstScreen(
    viewModel: BMIViewModel,
    onContinue: () -> Unit
) {
    val clickFeedback = rememberClickFeedback()
    var selectedGender by remember { mutableStateOf<Gender?>(null) }
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
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(top = 50.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "BMI",

                    fontSize = 35.sp, fontWeight = FontWeight.ExtraBold, color = Color(0xFFFFB534)
                )
                Spacer(Modifier.width(10.dp))
                Text(
                    text = "Calculator",

                    fontWeight = FontWeight.ExtraBold, fontSize = 35.sp, color = Color(0xFF65B741)
                )
            }
            Spacer(Modifier.height(39.dp))
            Text(text = "Please choose your gender", fontSize = 25.sp)
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 12.dp)
                    .clip(RoundedCornerShape(37.dp))
                    .clickable(

                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(bounded = true, radius = 250.dp)

                    ) {
                        clickFeedback()
                        selectedGender = Gender.Male
                    }
                    .background(
                        color = if (selectedGender == Gender.Male) Color(0xFFBCECA7) else Color(
                            0xFFEBF5E6
                        ), shape = RoundedCornerShape(37.dp)
                    ), verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(43.dp))
                Text(
                    text = "Male",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = if (selectedGender == Gender.Male) Color(0xFF549D32) else Color(
                        0xFF53A42F
                    )
                )
                Spacer(modifier = Modifier.width(90.dp))
                Box(
                    modifier = Modifier
                        .background(Color.White, shape = CircleShape)
//                    .clip(CircleShape)

                        .size(135.dp), contentAlignment = Alignment.Center

                ) {
                    Box(
                        Modifier
                            .size(65.dp)
                            .offset(x = (-57).dp, y = (-54).dp)
                            .background(Color(0xFF22689E), shape = CircleShape),
                        // <-- Position inside parent

                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.img_2),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 84.dp)
                            .height(12.dp)
                            .width(14.dp)

                            .background(Color(0xFFC0E4F9))
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(CircleShape)
                            .padding(top = 12.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.group),
                            contentDescription = null,
                            modifier = Modifier.padding(top = 29.dp)
                        )

                        Box(
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .height(5.dp)
                                .width(17.dp)
                                .background(Color(0xFF22689E))
                        )
                        Box(
                            modifier = Modifier


                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color(0xFF22689E))
                        )
                    }

//
                }
            }
            Spacer(modifier = Modifier.height(29.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 12.dp)
                    .clip(RoundedCornerShape(37.dp))
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = ripple(bounded = true, radius = 250.dp)
                    ) {
                        clickFeedback()
                        selectedGender = Gender.Female
                    }
                    .background(
                        color = if (selectedGender == Gender.Female) Color(0xFFF3DDBC) else Color(
                            0xFFFCF3E6
                        ), shape = RoundedCornerShape(37.dp)
                    ), verticalAlignment = Alignment.CenterVertically) {
                Spacer(modifier = Modifier.width(43.dp))
                Text(
                    text = "Female",
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color(0xFFCE922A)
                )
                Spacer(modifier = Modifier.width(90.dp))
                Box(
                    modifier = Modifier
                        .background(Color.White, shape = CircleShape)
//                    .clip(CircleShape)

                        .size(135.dp), contentAlignment = Alignment.Center

                ) {
                    Box(
                        Modifier
                            .size(65.dp)
                            .offset(x = (-57).dp, y = (-54).dp)
                            .background(Color(0xFFF74141), shape = CircleShape),
                        // <-- Position inside parent

                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            painter = painterResource(R.drawable.girl),
                            contentDescription = null,
                            modifier = Modifier.size(40.dp)
                        )
                    }
                    Box(
                        modifier = Modifier
                            .padding(top = 87.dp)
                            .height(12.dp)
                            .width(14.dp)

                            .background(Color(0xCCFF9977))
                    )
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .clip(CircleShape)
                            .padding(top = 12.dp)
                    ) {
                        Image(
                            painter = painterResource(R.drawable.girl_icon_cropped),
                            contentDescription = null,
                            modifier = Modifier.padding(top = 20.dp)
                        )

                        Box(
                            modifier = Modifier
                                .padding(top = 2.dp)
                                .height(5.dp)
                                .width(17.dp)
                                .background(Color(0xFFF74141))
                        )
                        Box(
                            modifier = Modifier


                                .size(50.dp)
                                .clip(CircleShape)
                                .background(Color(0xFFF74141))
                        )
                    }

//
                }
            }
            Spacer(Modifier.height(50.dp))
            Button(
                onClick = {
                    clickFeedback()
                    selectedGender?.let {
                        viewModel.gender = it.name
                        onContinue()

                    }
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
    }
}