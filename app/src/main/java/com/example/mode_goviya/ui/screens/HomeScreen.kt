package com.example.mode_goviya.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.mode_goviya.data.JsonLoader
import com.example.mode_goviya.util.Prefs
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.MaterialTheme



@Composable
fun HomeScreen(navController: NavController) {
    val context = LocalContext.current
    val prefs = remember { Prefs(context) }
    val district = prefs.getDistrict() ?: "මහනුවර"
    val variety = prefs.getVariety() ?: "Bg 300"

    val data = remember { JsonLoader.loadAll(context) }
    val list = data.filter { it.district == district && it.variety == variety }

    Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
        Text("${district} - ${variety}", style = MaterialTheme.typography.titleLarge)
        Spacer(Modifier.height(8.dp))
        // Show each section >> Card
        list.forEach { item ->
            Card(modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp).clickable {
                navController.navigate("detail/${item.id}")
            }) {
                Row(modifier = Modifier.padding(12.dp)) {
                    // optionally add icon/image
                    Column {
                        Text(item.title, style = MaterialTheme.typography.titleMedium)
                        Spacer(Modifier.height(6.dp))
                        Text(item.content.take(80) + "...")
                    }
                }
            }
        }
    }
}