package com.example.mode_goviya.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mode_goviya.ui.AppNavHost
import com.example.mode_goviya.ui.theme.ModeGoviyaTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.mode_goviya.data.DatabaseSeeder

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // seed DB in background (only inserts when empty)
        CoroutineScope(Dispatchers.IO).launch {
            DatabaseSeeder.seedIfNeeded(this@MainActivity)
        }

        setContent {
            ModeGoviyaTheme {
                AppNavHost()
            }
        }
    }
}