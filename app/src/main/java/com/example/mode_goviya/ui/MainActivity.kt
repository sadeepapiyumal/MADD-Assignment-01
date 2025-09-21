package com.example.mode_goviya.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.mode_goviya.ui.AppNavHost
import com.example.mode_goviya.ui.theme.ModeGoviyaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ModeGoviyaTheme {
                AppNavHost()
            }
        }
    }
}