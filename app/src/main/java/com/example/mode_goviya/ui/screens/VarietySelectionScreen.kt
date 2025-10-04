@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.mode_goviya.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mode_goviya.data.viewmodel.DistrictViewModel
import com.example.mode_goviya.util.Prefs
import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.material3.IconButton
import android.speech.tts.TextToSpeech
import androidx.compose.runtime.DisposableEffect
import java.util.Locale
import androidx.compose.ui.res.painterResource
import com.example.mode_goviya.R

@Composable
fun VarietySelectionScreen(
    navController: NavController,
    onVarietySelected: (String) -> Unit
) {
    val context = LocalContext.current
    val prefs = remember { Prefs(context) }
    val vm: DistrictViewModel = viewModel()
    // Text-To-Speech
    val tts = remember {
        TextToSpeech(context) { /* onInit handled in LaunchedEffect below */ }
    }
    LaunchedEffect(tts) {
        // Configure language after engine is created
        val localeSi = Locale("si", "LK")
        val availability = tts.setLanguage(localeSi)
        if (availability == TextToSpeech.LANG_MISSING_DATA || availability == TextToSpeech.LANG_NOT_SUPPORTED) {
            tts.language = Locale.getDefault()
        }
    }
    // Ensure TTS is shutdown when this composable leaves
    DisposableEffect(Unit) {
        onDispose {
            tts.stop()
            tts.shutdown()
        }
    }

    // Observe districts and varieties
    val districts by vm.districts.collectAsState()
    val varieties by vm.varieties.collectAsState()

    // On enter, select district by saved name to populate varieties
    LaunchedEffect(districts) {
        val savedDistrict = prefs.getDistrict()
        if (savedDistrict.isNotBlank()) {
            districts.firstOrNull { it.name == savedDistrict }?.let { d ->
                vm.selectDistrict(d.id)
            }
        }
    }

    var selectedVariety by remember { mutableStateOf<String?>(null) }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF37D06A))
            .padding(46.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "වී වර්ගය තෝරන්න",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(Modifier.height(16.dp))

        val menuBg = Color(0xFFF4E9D1)
        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
            OutlinedTextField(
                value = selectedVariety ?: "වී වර්ගය තෝරන්න",
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                modifier = Modifier.menuAnchor().width(300.dp),
                textStyle = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold),
                shape = RoundedCornerShape(12.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = menuBg,
                    unfocusedContainerColor = menuBg,
                    disabledContainerColor = menuBg,
                    errorContainerColor = menuBg,
                    focusedBorderColor = menuBg,
                    unfocusedBorderColor = menuBg,
                    disabledBorderColor = menuBg,
                    errorBorderColor = menuBg
                )
            )

            ExposedDropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier
                    .width(300.dp)
                    .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 12.dp, bottomEnd = 12.dp)),
                containerColor = menuBg,
                tonalElevation = 0.dp,
                shadowElevation = 0.dp
            ) {
                // Header (inside dropdown)
                Text(
                    text = "වී වර්ගය තෝරන්න",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(horizontal = 16.dp, vertical = 12.dp)
                )
                Divider(color = menuBg)

                varieties.forEachIndexed { index, v ->
                    val pad = when (index) {
                        0 -> PaddingValues(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 10.dp)
                        varieties.lastIndex -> PaddingValues(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 0.dp)
                        else -> PaddingValues(horizontal = 16.dp, vertical = 10.dp)
                    }
                    DropdownMenuItem(
                        text = {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = v.name,
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                                )
                                Spacer(Modifier.height(4.dp))
                                Text(
                                    text = "අස්වැන්න: හෙක්ටයාරයකට ටොන් ${"%.1f".format(v.harvestAmount)}", // e.g., 5.9
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "අස්වනු නෙලීමට ගතවෙන කාලය: මාස ${v.periodMonths}",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "සහලේ වර්ණය: ${v.color}",
                                    style = MaterialTheme.typography.bodySmall
                                )
                                Text(
                                    text = "රෝග/පළිබෝධක ප්\u200Dරතිරෝධතා මට්ටම: ${v.diseaseResistance}",
                                    style = MaterialTheme.typography.bodySmall
                                )
                            }
                        },
                        trailingIcon = {
                            IconButton(onClick = {
                                val spoken = buildString {
                                    append(v.name)
                                    append(". ")
                                    append("අස්වැන්න හෙක්ටයාරයකට ටොන් ")
                                    append("%.1f".format(v.harvestAmount))
                                    append(". ")
                                    append("කාලය මාස ")
                                    append(v.periodMonths)
                                    append(". ")
                                    append("වර්ණය ")
                                    append(v.color)
                                    append(". ")
                                    append("රෝග ප්‍රතිරෝධය ")
                                    append(v.diseaseResistance)
                                }
                                tts.speak(spoken, TextToSpeech.QUEUE_FLUSH, null, "variety_${'$'}{v.id}")
                            }) {
                                Icon(
                                    painter = painterResource(id = R.drawable.icons_speaker),
                                    contentDescription = null,
                                    tint = Color.Unspecified,
                                    modifier = Modifier.size(24.dp)
                                )
                            }
                        },
                        onClick = {
                            selectedVariety = v.name
                            expanded = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = pad
                    )
                    if (index < varieties.lastIndex) Divider(
                        color = Color.Black,
                        thickness = 1.2.dp,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    )
                }
            }
        }

        Spacer(Modifier.height(28.dp))

        Button(
            onClick = {
                val value = selectedVariety
                if (value.isNullOrBlank()) {
                    Toast.makeText(context, "කරුණාකර වර්ගය තෝරන්න", Toast.LENGTH_SHORT).show()
                    return@Button
                }
                onVarietySelected(value)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF034503),
                contentColor = Color.White,
                disabledContainerColor = Color(0xFF6FCC1D),
                disabledContentColor = Color(0xFFE0E0E0)
            )
        ) {
            Text("සුරකින්න")
        }
    }
}

