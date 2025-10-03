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
import com.example.mode_goviya.util.Prefs
import com.example.mode_goviya.data.viewmodel.DistrictViewModel
import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.foundation.background
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.VolumeUp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DistrictSelectionScreen(
    navController: NavController,
    onDistrictSelected: (String) -> Unit, // districtName only
    vm: DistrictViewModel = viewModel()
) {
    val context = LocalContext.current
    val prefs = remember { Prefs(context) }

    val districts by vm.districts.collectAsState()

    // UI state for dropdowns
    var districtExpanded by remember { mutableStateOf(false) }

    // current selected names
    val selectedDistrict = remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF37D06A))
            .padding(46.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "දිස්ත්‍රික්කය තෝරන්න",
            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
        )
        Spacer(Modifier.height(16.dp))

        // District dropdown
        val menuBg = Color(0xFFF4E9D1)
        ExposedDropdownMenuBox(
            expanded = districtExpanded,
            onExpandedChange = { districtExpanded = !districtExpanded }
        ) {
            OutlinedTextField(
                value = selectedDistrict.value ?: "දිස්ත්‍රික්කය තෝරන්න",
                onValueChange = {},
                readOnly = true,
                trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = districtExpanded) },
                modifier = Modifier
                    .menuAnchor()
                    .width(300.dp),
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
                expanded = districtExpanded,
                onDismissRequest = { districtExpanded = false },
                modifier = Modifier
                    .width(300.dp)
                    .clip(RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 12.dp, bottomEnd = 12.dp)),
                containerColor = menuBg,
                tonalElevation = 0.dp,
                shadowElevation = 0.dp
            ) {


                // Items (remove top/bottom gap so it looks continuous)
                districts.forEachIndexed { index, d ->
                    val pad = when (index) {
                        0 -> PaddingValues(start = 16.dp, end = 16.dp, top = 0.dp, bottom = 10.dp)
                        districts.lastIndex -> PaddingValues(start = 16.dp, end = 16.dp, top = 10.dp, bottom = 0.dp)
                        else -> PaddingValues(horizontal = 16.dp, vertical = 10.dp)
                    }
                    DropdownMenuItem(
                        text = {
                            Column(modifier = Modifier.fillMaxWidth()) {
                                Text(
                                    text = d.name,
                                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                                )
                            }
                        },
                        onClick = {
                            selectedDistrict.value = d.name
                            vm.selectDistrict(d.id)
                            districtExpanded = false
                        },
                        modifier = Modifier.fillMaxWidth(),
                        contentPadding = pad
                    )
                    if (index < districts.lastIndex) Divider(color = menuBg)
                }
            }
        }
        Spacer(Modifier.height(28.dp))

        Button(onClick = {
            val dName = selectedDistrict.value
            if (dName.isNullOrBlank()) {
                Toast.makeText(context, "කරුණාකර දිස්ත්‍රික්කය තෝරන්න", Toast.LENGTH_SHORT).show()
                return@Button
            }

            // save to prefs and go to variety selection
            prefs.setDistrict(dName)
            onDistrictSelected(dName)
            navController.navigate("variety_selection")
        },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF034503), // dark green
                contentColor = Color.White,
                disabledContainerColor = Color(0xFF6FCC1D),
                disabledContentColor = Color(0xFFE0E0E0)
            )
        ) {
            Text("ඊළඟට")
        }
    }
}
