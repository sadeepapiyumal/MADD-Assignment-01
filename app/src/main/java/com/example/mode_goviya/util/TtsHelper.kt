package com.example.mode_goviya.util

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class TtsHelper(private val context: Context) {
    private var tts: TextToSpeech? = null

    fun init(onReady: ((Boolean) -> Unit)? = null) {
        if (tts != null) { onReady?.invoke(true); return }
        tts = TextToSpeech(context) { status ->
            if (status == TextToSpeech.SUCCESS) {
                val res = tts?.setLanguage(Locale("si", "LK"))
                onReady?.invoke(res == TextToSpeech.LANG_AVAILABLE || res == TextToSpeech.LANG_COUNTRY_AVAILABLE)
            } else onReady?.invoke(false)
        }
    }

    fun speak(text: String) {
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "mode_goviya_utt")
    }

    fun stop() { tts?.stop() }
    fun release() { tts?.shutdown(); tts = null }
}