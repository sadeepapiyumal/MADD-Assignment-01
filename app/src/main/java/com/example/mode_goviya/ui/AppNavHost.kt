package com.example.mode_goviya.ui

import com.example.mode_goviya.ui.screens.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable

import androidx.compose.foundation.layout.padding



@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    // use Scaffold to host bottom bar
    Scaffold(
        bottomBar = { BottomBar(navController) }
    ) { padding ->
        NavHost(navController = navController, startDestination = "selection", modifier = Modifier.padding(padding)) {
            composable("selection") { SelectionScreen(navController) }
            composable("home") { HomeScreen(navController) }
            composable("detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                DetailScreen(navController, id)
            }
            composable("settings") { SettingsScreen(navController) }
            composable("reminders") { OnboardingScreen(navController) }
            // add onboarding if needed
        }
    }
}