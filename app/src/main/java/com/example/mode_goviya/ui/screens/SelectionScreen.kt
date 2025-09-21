
@file:OptIn(ExperimentalMaterial3Api::class)
package com.example.mode_goviya.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mode_goviya.util.Prefs
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext


@Composable
fun SelectionScreen(navController: NavController) {
    val context = LocalContext.current
    val prefs = remember { Prefs(context) }

    // Hardcode district & variety lists (or load from JSON/strings.xml)
    val districts = listOf("කුරුණෑගල", "මහනුවර", "ගාල්ල", "මඩකලපුව") // add all 25
    val varieties = listOf("Bg 300", "Bg 352", "AT 362", "Suwandel")

    var selectedDistrict by remember { mutableStateOf(districts[0]) }
    var selectedVariety by remember { mutableStateOf(varieties[0]) }

    Column(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)) {
        Text("දිස්ත්‍රික්කය තෝරන්න", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        // simple dropdowns
        var openD by remember { mutableStateOf(false) }
        ExposedDropdownMenuBox(expanded = openD, onExpandedChange = { openD = !openD }) {
            TextField(value = selectedDistrict, onValueChange = {}, readOnly = true, label = { Text("දිස්ත්‍රික්කය") })
            ExposedDropdownMenu(expanded = openD, onDismissRequest = { openD = false }) {
                districts.forEach { d ->
                    DropdownMenuItem(text = { Text(d) }, onClick = { selectedDistrict = d; openD=false })
                }
            }
        }

        Spacer(Modifier.height(16.dp))
        Text("වැරය තෝරන්න", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        var openV by remember { mutableStateOf(false) }
        ExposedDropdownMenuBox(expanded = openV, onExpandedChange = { openV = !openV }) {
            TextField(value = selectedVariety, onValueChange = {}, readOnly = true, label = { Text("වැරය") })
            ExposedDropdownMenu(expanded = openV, onDismissRequest = { openV = false }) {
                varieties.forEach { v ->
                    DropdownMenuItem(text = { Text(v) }, onClick = { selectedVariety = v; openV=false })
                }
            }
        }

        Spacer(Modifier.height(24.dp))
        Button(onClick = {
            prefs.setDistrict(selectedDistrict)
            prefs.setVariety(selectedVariety)
            Toast.makeText(context, "තෝරාගෙන ඇත: $selectedDistrict - $selectedVariety", Toast.LENGTH_SHORT).show()
            navController.navigate("home")
        }) {
            Text("සුරකින්න සහ පටන් ගන්න")
        }
    }
}