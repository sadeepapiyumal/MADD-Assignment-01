package com.example.mode_goviya.ui

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object GroundPreparation : Screen("ground_preparation")
    object Sowing : Screen("sowing")
    object Fertilizing : Screen("fertilizing")
    object Pesticiding : Screen("pesticiding")
    object Watering : Screen("watering")
    object Harvesting : Screen("harvesting")
    object Storing : Screen("storing")
}