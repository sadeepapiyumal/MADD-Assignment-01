package com.example.mode_goviya.util

import android.content.Context

class Prefs(private val context: Context) {
    private val prefs = context.getSharedPreferences("mode_goviya_prefs", Context.MODE_PRIVATE)
    fun setDistrict(d: String) = prefs.edit().putString("district", d).apply()
    fun getDistrict(): String? = prefs.getString("district", null)
    fun setVariety(v: String) = prefs.edit().putString("variety", v).apply()
    fun getVariety(): String? = prefs.getString("variety", null)
    fun setFirstLaunchFalse() = prefs.edit().putBoolean("firstLaunch", false).apply()
    fun isFirstLaunch() = prefs.getBoolean("firstLaunch", true)
}