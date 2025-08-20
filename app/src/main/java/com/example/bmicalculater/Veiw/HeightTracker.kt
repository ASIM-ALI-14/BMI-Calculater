package com.example.bmicalculater.Veiw

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bmi.BMIViewModel
import com.example.bmicalculater.Model.rememberClickFeedback
import com.example.bmicalculater.R


@Composable
fun HeightTracker(viewModel: BMIViewModel) {
    // Range & default values
    val minHeight = 100
    val maxHeight = 400
    val totalTicks = 301
    val defaultHeight = viewModel.height // Use ViewModel's height as default

    // Convert default height into index
    val defaultIndex = (defaultHeight - minHeight) * (totalTicks - 1) / (maxHeight - minHeight)

    // Local state for height that syncs with ViewModel
    var height by remember { mutableStateOf(defaultHeight) }

    // Start LazyRow from default index
    val lazyListState = rememberLazyListState(initialFirstVisibleItemIndex = defaultIndex)
    val clickFeedback = rememberClickFeedback()

    // Update both local state and ViewModel when scrolled
    LaunchedEffect(lazyListState) {
        snapshotFlow { lazyListState.firstVisibleItemIndex }
            .collect { firstVisibleItem ->
                val newHeight = minHeight + (firstVisibleItem * (maxHeight - minHeight) / (totalTicks - 1))

                if (newHeight != height) {
                    height = newHeight
                    viewModel.height = newHeight

                    // ✅ Vibrate + Beep when height changes
                    clickFeedback()
                }
            }
    }


    ElevatedCard(
        modifier = Modifier.size(370.dp, 205.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color(0xFFFBF6EE))
    ) {
        Spacer(modifier = Modifier.height(19.dp))
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Height(cm)",
                fontSize = 17.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(R.font.quicksand_bold)),
                color = Color(0xFFACACAC),
            )
            Text(
                text = height.toString(),
                fontSize = 48.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(R.font.quicksand_bold)),
                color = Color(0xFFCE922A),
            )
            Spacer(modifier = Modifier.height(39.dp))
            Box(contentAlignment = Alignment.Center) {
                LazyRow(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 21.dp),
                    verticalAlignment = Alignment.Bottom,
                    state = lazyListState,
                    contentPadding = PaddingValues(horizontal = 157.5f.dp)
                ) {
                    items(totalTicks) { index ->
                        val active = (index % 5) == 0
                        Trakertick(active)
                    }
                }

                // Center indicator
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(bottom = 11.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.img_3),
                        contentDescription = null,
                        modifier = Modifier
                            .size(12.dp)
                            .padding(bottom = 5.dp)
                    )
                    Box(
                        modifier = Modifier
                            .padding(horizontal = 5.dp)
                            .size(3.dp, 40.dp)
                            .background(
                                color = Color(0xFFCE922A),
                                shape = RoundedCornerShape(10.dp)
                            )
                    )
                }
            }
        }
    }
}

@Composable
fun Trakertick(higher: Boolean) {
    Box(
        modifier = Modifier
            .padding(horizontal = 5.dp)
            .width(if (higher) 3.dp else 2.5f.dp)
            .height(if (higher) 40.dp else 22.dp)
            .background(
                color = Color.Gray,
                shape = RoundedCornerShape(10.dp)
            )
    )
}