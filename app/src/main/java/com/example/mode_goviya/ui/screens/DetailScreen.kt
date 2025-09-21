package com.example.mode_goviya.ui.screens

import android.speech.tts.TextToSpeech
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mode_goviya.data.JsonLoader
import com.example.mode_goviya.util.TtsHelper
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext



@Composable
fun DetailScreen(navController: NavController, id: Int?) {
    val context = LocalContext.current
    val section = remember(id) { id?.let { JsonLoader.findById(context, it) } }
    if (section == null) {
        Text("දත්ත සොයාගත නොහැක")
        return
    }

    // TTS lifecycle
    val ttsHelper = remember { TtsHelper(context) }
    DisposableEffect(Unit) {
        ttsHelper.init()
        onDispose { ttsHelper.release() }
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)) {
        Text(section.title, style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(12.dp))
        Text(section.content, style = MaterialTheme.typography.bodyMedium)
        Spacer(Modifier.height(16.dp))
        Button(onClick = { ttsHelper.speak(section.content) }) {
            Text("ඇහුන්න")
        }
    }
}