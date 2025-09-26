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
import com.example.mode_goviya.data.DistrictViewModel
import com.example.mode_goviya.util.Prefs

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DistrictSelectionScreen(
    navController: NavController,
    onDistrictSelected: (String, String) -> Unit, // (districtName, varietyName)
    vm: DistrictViewModel = viewModel()
) {
    val context = LocalContext.current
    val prefs = remember { Prefs(context) }

    val districts by vm.districts.collectAsState()
    val varieties by vm.varieties.collectAsState()

    // UI state for dropdowns
    var districtExpanded by remember { mutableStateOf(false) }
    var varietyExpanded by remember { mutableStateOf(false) }

    // current selected names
    val selectedDistrict = remember { mutableStateOf<String?>(null) }
    val selectedVariety = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("දිස්ත්‍රික්කය තෝරන්න", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(16.dp))

        // District dropdown
        ExposedDropdownMenuBox(expanded = districtExpanded, onExpandedChange = { districtExpanded = !districtExpanded }) {
            TextField(
                value = selectedDistrict.value ?: "දිස්ත්\u200Dරික්කය තෝරන්න",
                onValueChange = {},
                readOnly = true,
                label = { Text("දිස්ත්‍රික්කය") },
                modifier = Modifier.menuAnchor().width(300.dp)
            )
            ExposedDropdownMenu(expanded = districtExpanded, onDismissRequest = { districtExpanded = false }) {
                districts.forEach { d ->
                    DropdownMenuItem(
                        text = { Text(d.name) },
                        onClick = {
                            selectedDistrict.value = d.name
                            vm.selectDistrict(d.id)
                            districtExpanded = false
                            selectedVariety.value = null // reset variety
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(26.dp))

        // Variety dropdown (populated from vm.varieties)
        ExposedDropdownMenuBox(expanded = varietyExpanded, onExpandedChange = { varietyExpanded = !varietyExpanded }) {
            TextField(
                value = selectedVariety.value ?: "වී වර්ගය තෝරන්න",
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
                            selectedVariety.value = v.name
                            varietyExpanded = false
                        }
                    )
                }
            }
        }

        Spacer(Modifier.height(28.dp))

        Button(onClick = {
            val dName = selectedDistrict.value
            val vName = selectedVariety.value
            if (dName.isNullOrBlank() || vName.isNullOrBlank()) {
                Toast.makeText(context, "කරුණාකර දිස්ත්‍රික්කය හා වර්ගය තෝරන්න", Toast.LENGTH_SHORT).show()
                return@Button
            }

            // save to prefs and call callback
            prefs.setDistrict(dName)
            prefs.setVariety(vName)
            onDistrictSelected(dName, vName)
            navController.navigate("home") {
                popUpTo("district_selection") { inclusive = true }
            }
        }) {
            Text("ඊළඟට")
        }
    }
}
