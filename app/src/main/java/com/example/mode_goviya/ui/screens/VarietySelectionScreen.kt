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

@Composable
fun VarietySelectionScreen(
    navController: NavController,
    onVarietySelected: (String) -> Unit
) {
    val context = LocalContext.current

    val varieties = listOf("Bg 300", "Bg 352", "AT 362","Bg 350", "Bg 354", "AT 362")
    var selectedVariety by remember { mutableStateOf(varieties[0]) }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 16.dp, end = 16.dp),
        verticalArrangement = Arrangement.Top,        // 👈 centers vertically
        horizontalAlignment = Alignment.CenterHorizontally // 👈 centers horizontally
    ) {
        Text("වී වර්ගය තෝරන්න", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))

        ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = !expanded }) {
            TextField(
                value = selectedVariety,
                onValueChange = {},
                readOnly = true,
                label = { Text("වී වර්ගය තෝරන්න") },
                modifier = Modifier.menuAnchor().width(250.dp) // 👈 center width
            )
            ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
                varieties.forEach { v ->
                    DropdownMenuItem(
                        text = { Text(v) },
                        onClick = {
                            selectedVariety = v
                            expanded = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(24.dp))

        Button(
            onClick = {
                Toast.makeText(context, "තෝරාගෙන ඇත: $selectedVariety", Toast.LENGTH_SHORT).show()
                onVarietySelected(selectedVariety)
        },
            modifier = Modifier.width(200.dp)
        ){            // 👈 make button nicely centered) {
            Text("සුරකින්න")
        }
    }
}

