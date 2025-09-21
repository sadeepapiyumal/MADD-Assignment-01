package com.example.mode_goviya.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object JsonLoader {
    fun loadAll(context: Context): List<PaddySection> {
        val raw = context.assets.open("paddy_data.json").bufferedReader().use { it.readText() }
        val type = object : TypeToken<List<PaddySection>>() {}.type
        return Gson().fromJson(raw, type) ?: emptyList()
    }

    fun findById(context: Context, id: Int): PaddySection? =
        loadAll(context).firstOrNull { it.id == id }
}