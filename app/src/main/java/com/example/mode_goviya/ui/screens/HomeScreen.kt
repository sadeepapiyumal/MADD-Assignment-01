package com.example.mode_goviya.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mode_goviya.R

// Data class for sections
data class Section(
    val title: String,
    val iconRes: Int,
    val route: String
)

private const val s = "අස්වනු නෙලීම"

@Composable
fun HomeScreen(navController: NavController) {

    val sections = listOf(
        Section("බිම් සැකසීම", R.drawable.groundpreparation, "ground_preparation"),
        Section("බීජ වැපිරීම", R.drawable.sowing, "sowing"),
        Section("පොහොර යෙදීම", R.drawable.fertilizing, "fertilizing"),
        Section("පලිබෝධ පාලනය", R.drawable.pesticiding, "pesticiding"),
        Section("ජලය යෙදීම", R.drawable.watering, "watering"),
        Section("අස්වනු නෙලීම", R.drawable.harvesting, "harvesting"),
        Section("අස්වනු ගබඩා කිරීම", R.drawable.storing, "storing")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF6EE776)) // green background
            .padding(12.dp),
        verticalArrangement = Arrangement.Top, // start from top
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(24.dp)) // push everything a little down

        sections.forEach { section ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(90.dp) // fixed height for better vertical alignment
                    .padding(vertical = 6.dp)
                    .clickable { navController.navigate(section.route) },
                shape = RoundedCornerShape(8.dp),
                colors = CardDefaults.cardColors(containerColor = Color(0xFFFFEED4)),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = section.title,
                        style = MaterialTheme.typography.titleLarge,
                        modifier = Modifier.align(Alignment.CenterVertically) // ensures vertical center
                    )
                    Image(
                        painter = painterResource(id = section.iconRes),
                        contentDescription = section.title,
                        modifier = Modifier.size(80.dp)
                    )
                }
            }
        }
    }
}

