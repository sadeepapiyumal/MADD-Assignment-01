package com.example.mode_goviya.util

import android.content.Context
import android.speech.tts.TextToSpeech
import java.util.Locale

class TtsManager(private val context: Context) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private var ready = false
    private var pendingLocale: Locale? = null

    fun init(locale: Locale = Locale("si","LK")) {
        if (tts == null) tts = TextToSpeech(context, this).apply { pendingLocale = locale }
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            val locale = pendingLocale ?: Locale.getDefault()
            val result = tts?.setLanguage(locale)
            ready = result == TextToSpeech.LANG_AVAILABLE || result == TextToSpeech.LANG_COUNTRY_AVAILABLE || result == TextToSpeech.LANG_COUNTRY_VAR_AVAILABLE
        } else {
            ready = false
        }
    }

    fun speak(text: String, pitch: Float = 1.0f, rate: Float = 1.0f) {
        if (tts == null) init()
        tts?.setPitch(pitch)
        tts?.setSpeechRate(rate)
        tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "MODE_GOVIYA_UTTERANCE")
    }

    fun stop() { tts?.stop() }

    fun shutdown() {
        tts?.stop()
        tts?.shutdown()
        tts = null
        ready = false
    }
}
