package com.example.mode_goviya.ui
import com.example.mode_goviya.ui.screens.sections.*

import com.example.mode_goviya.util.Prefs
import com.example.mode_goviya.ui.screens.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.foundation.layout.padding

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    val context = LocalContext.current
    val prefs = remember { Prefs(context) }

    /*
    // Set start destination
    val startDestination = if (prefs.isFirstLaunch()) {
        "onboarding"
    } else {
        "district_selection"
    }*/

    val startDestination = "onboarding" // force onboarding


    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Scaffold(
        bottomBar = {
            // Hide bottom bar on onboarding and selection screens
            val hideRoutes = setOf("onboarding", "district_selection", "variety_selection")
            if (currentRoute !in hideRoutes) {
                BottomBar(navController)
            }
        }
    ) { padding ->
        NavHost(
            navController = navController,
            startDestination = startDestination,
            modifier = Modifier.padding(padding)
        ) {
            // Onboarding screen
            composable("onboarding") {
                OnboardingScreen(navController = navController, prefs = prefs)
            }

            // District selection screen
            composable("district_selection") {
                DistrictSelectionScreen(
                    navController = navController,
                    onDistrictSelected = { selectedDistrict ->
                        prefs.setDistrict(selectedDistrict)
                        navController.navigate("variety_selection")
                    }
                )
            }

            // Variety selection screen
            composable("variety_selection") {
                VarietySelectionScreen(
                    navController = navController,
                    onVarietySelected = { selectedVariety ->
                        prefs.setVariety(selectedVariety)
                        // Navigate to home and remove selection screens from back stack
                        navController.navigate("home") {
                            popUpTo("district_selection") { inclusive = true }
                        }
                    }
                )
            }

            // Home screen
            composable("home") {
                HomeScreen(navController)
            }

            //sections
            composable("ground_preparation") { GroundPreparationPage(navController = navController) }
            composable("sowing") { SowingPage(navController = navController) }
            composable("fertilizing") { FertilizingPage(navController = navController) }
            composable("pesticiding") { PesticidingPage(navController = navController) }
            composable("watering") { WateringPage(navController = navController) }
            composable("harvesting") { HarvestingPage(navController = navController) }
            composable("storing") { StoringPage(navController = navController) }

            //ground preparation sub sections
            composable("ground_preparation_sub1") { GroundSub1Page(navController) }
            composable("ground_preparation_sub2") { GroundSub2Page(navController) }
            composable("ground_preparation_sub3") { GroundSub3Page(navController) }

            //sowing sub sections
            composable("sowing_sub1") { SowingSub1Page(navController) }
            composable("sowing_sub2") { SowingSub2Page(navController) }
            composable("sowing_sub3") { SowingSub3Page(navController) }

            //fertilizing sub sections
            composable("fertilizing_sub1") { FertilizingSub1Page(navController) }
            composable("fertilizing_sub2") { FertilizingSub2Page(navController) }

            //pesticiding sub sections
            composable("pesticiding_sub1") { PesticidingSub1Page(navController) }
            composable("pesticiding_sub2") { PesticidingSub2Page(navController) }




            // Detail screen
            composable("detail/{id}") { backStackEntry ->
                val id = backStackEntry.arguments?.getString("id")?.toIntOrNull()
                DetailScreen(navController, id)
            }

            // Settings
            composable("settings") {
                SettingsScreen(navController)
            }
        }
    }
}
