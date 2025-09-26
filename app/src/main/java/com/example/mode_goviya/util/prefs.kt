package com.example.mode_goviya.util

import android.content.Context
import android.content.SharedPreferences

class Prefs(context: Context) {
    private val prefs: SharedPreferences =
        context.getSharedPreferences("mode_goviya_prefs", Context.MODE_PRIVATE)

    fun setDistrict(district: String) {
        prefs.edit().putString("district", district).apply()
    }

    fun getDistrict(): String = prefs.getString("district", "") ?: ""

    fun setVariety(variety: String) {
        prefs.edit().putString("variety", variety).apply()
    }

    fun getVariety(): String = prefs.getString("variety", "") ?: ""

    fun setFirstLaunch(isFirst: Boolean) {
        prefs.edit().putBoolean("first_launch", isFirst).apply()
    }

    fun isFirstLaunch(): Boolean = prefs.getBoolean("first_launch", true)
}
