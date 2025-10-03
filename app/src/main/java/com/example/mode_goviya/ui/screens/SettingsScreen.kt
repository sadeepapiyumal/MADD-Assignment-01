package com.example.mode_goviya.ui.screens

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
//import androidx.compose.material3.ExposedDropdownMenu
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.mode_goviya.data.viewmodel.DistrictViewModel
import com.example.mode_goviya.util.Prefs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen(navController: NavController, vm: DistrictViewModel = viewModel()) {
    val context = LocalContext.current
    val prefs = remember { Prefs(context) }

    val districts by vm.districts.collectAsState()
    val varieties by vm.varieties.collectAsState()

    var districtExpanded by remember { mutableStateOf(false) }
    var varietyExpanded by remember { mutableStateOf(false) }

    // Pre-fill from saved preferences
    var selectedDistrict by remember { mutableStateOf(prefs.getDistrict().ifBlank { null }) }
    var selectedVariety by remember { mutableStateOf(prefs.getVariety().ifBlank { null }) }

    // When districts load, set the ViewModel's selected district based on saved name
    LaunchedEffect(districts) {
        if (selectedDistrict != null) {
            districts.firstOrNull { it.name == selectedDistrict }?.let { d ->
                vm.selectDistrict(d.id)
            } ?: run {
                // Saved district not found; clear selection
                selectedDistrict = null
                selectedVariety = null
            }
        }
    }

    // If selected district changes and varieties no longer contain saved variety, clear it
    LaunchedEffect(varieties) {
        selectedVariety?.let { vName ->
            if (varieties.none { it.name == vName }) {
                selectedVariety = null
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("සැකසුම්", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        ExposedDropdownMenuBox(expanded = districtExpanded, onExpandedChange = { districtExpanded = !districtExpanded }) {
            TextField(
                value = selectedDistrict ?: "දිස්ත්\u200Dරික්කය තෝරන්න",
                onValueChange = {},
                readOnly = true,
                label = { Text("දිස්ත්\u200Dරික්කය") },
                modifier = Modifier.menuAnchor().width(300.dp)
            )
            ExposedDropdownMenu(expanded = districtExpanded, onDismissRequest = { districtExpanded = false }) {
                districts.forEach { d ->
                    DropdownMenuItem(
                        text = { Text(d.name) },
                        onClick = {
                            selectedDistrict = d.name
                            vm.selectDistrict(d.id)
                            districtExpanded = false
                            selectedVariety = null
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(24.dp))

        ExposedDropdownMenuBox(expanded = varietyExpanded, onExpandedChange = { varietyExpanded = !varietyExpanded }) {
            TextField(
                value = selectedVariety ?: "වී වර්ගය තෝරන්න",
                onValueChange = {},
                readOnly = true,
                label = { Text("වර්ගය") },
                modifier = Modifier.menuAnchor().width(300.dp)
            )
            ExposedDropdownMenu(expanded = varietyExpanded, onDismissRequest = { varietyExpanded = false }) {
                varieties.forEach { v ->
                    DropdownMenuItem(
                        text = { Text(v.name) },
                        onClick = {
                            selectedVariety = v.name
                            varietyExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(28.dp))

        Button(onClick = {
            val dName = selectedDistrict
            val vName = selectedVariety
            if (dName.isNullOrBlank() || vName.isNullOrBlank()) {
                Toast.makeText(context, "කරුණාකර දිස්ත්‍රික්කය හා වර්ගය තෝරන්න", Toast.LENGTH_SHORT).show()
                return@Button
            }
            prefs.setDistrict(dName)
            prefs.setVariety(vName)
            Toast.makeText(context, "සැකසුම් සුරකින්නා ලදී", Toast.LENGTH_SHORT).show()
            navController.popBackStack()
        }) {
            Text("සුරකින්න")
        }
    }
}