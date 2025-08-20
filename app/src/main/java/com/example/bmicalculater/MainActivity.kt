// MainActivity.kt
package com.example.bmicalculater

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.bmi.BMIViewModel
import com.example.bmicalculater.Model.Screen
import com.example.bmicalculater.Veiw.FirstScreen
import com.example.bmicalculater.Veiw.SecondScreen
import com.example.bmicalculater.Veiw.SplashScreen
import com.example.bmicalculater.ui.theme.BMICalculaterTheme

class MainActivity : ComponentActivity() {
    private val viewModel: BMIViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BMICalculaterTheme {
                AppNavigation(viewModel)
            }
        }
    }
}

@Composable
fun AppNavigation(viewModel: BMIViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.First.route
    ) {

        

        // First Screen
        composable(Screen.First.route) {
            FirstScreen(viewModel) {
                navController.navigate(Screen.Second.route)
            }
        }

        // Second Screen
        composable(Screen.Second.route) {
            SecondScreen(
                viewModel,
                onBack = { navController.popBackStack() }, // back to First
                onCalculate = { /* Already handled with dialog */ }
            )
        }
    }
}
