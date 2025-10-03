package com.example.mode_goviya.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.lifecycleScope
import com.example.mode_goviya.ui.theme.ModeGoviyaTheme
import com.example.mode_goviya.data.AppDatabase
import kotlinx.coroutines.launch
import kotlinx.coroutines.Dispatchers
import com.example.mode_goviya.data.DatabaseSeeder


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // seed DB on every app start (idempotent: returns early if data exists)
        lifecycleScope.launch(Dispatchers.IO) {
            val db = AppDatabase.getDatabase(applicationContext)
            DatabaseSeeder.seed(db)
        }

        setContent {
            ModeGoviyaTheme {
                AppNavHost()
            }
        }
    }
}