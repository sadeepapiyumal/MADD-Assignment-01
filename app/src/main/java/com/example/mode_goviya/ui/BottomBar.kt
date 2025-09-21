package com.example.mode_goviya.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@Composable
fun BottomBar(navController: NavController) {
    NavigationBar(containerColor = Color(0xFF5FE978)) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.ArrowBack, contentDescription = "Back", tint = Color(0xFF034503)) },
            selected = false,
            onClick = { navController.popBackStack() }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Home, contentDescription = "Home", tint = Color(0xFF034503)) },
            selected = false,
            onClick = {
                navController.popBackStack("home", false) // go to home, clear stack
                navController.navigate("home")
            }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.Settings, contentDescription = "Settings", tint = Color(0xFF034503)) },
            selected = false,
            onClick = { navController.navigate("settings") }
        )
    }
}