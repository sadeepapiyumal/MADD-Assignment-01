package com.example.mode_goviya.ui.screens.sections

import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mode_goviya.R
import com.example.mode_goviya.ui.components.SpeakerTtsButton

@Composable
fun PesticidingPage(navController: NavController) {
    val description = "වල්පැළෑටි  හා කෘමීන් මගින් සිදුවන\n" +
            "පළිබෝධ හානි නිසා වී වගාවේ අස්වැන්න හා ගුණාත්මකභාවය අඩු කර සෘජු හෝ වක්\u200Dර වශයෙන් විශාල ආර්ථික හානි ඇති කරයි." +
            " එමගින් නිෂ්පාදන පිරිවැයද වැඩි වේ.එම නිසා වී වගාවක මනා පළිබෝධ පාලනයක් සිදු  කල  යුතුය.\n" +
            "\n" +
            "වැඩිදුර තොරතුරු සඳහා අදාළ විස්තරය ස්පර්ශ කරන්න.\n"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDFFFD6))
            .padding(5.dp)
    ) {
        // Top Row with title and image
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "පළිබෝධ පාලනය",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF034503),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .offset(y = 25.dp)

            )

            Image(
                painter = painterResource(id = R.drawable.pesticiding),
                contentDescription = "Pesticiding",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = (-10).dp)
            )
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Description in a Card
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RectangleShape,
            colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF5E0)),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = description,
                    fontSize = 18.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.padding(start = 15.dp, top = 16.dp, end = 15.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 18.dp, top = 10.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SpeakerTtsButton(
                        textToSpeak = description,
                        modifier = Modifier.size(28.dp)
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Subtopic Sections
        val subTopics = listOf(
            Pair("වල්පැළෑටි පාලනය", "pesticiding_sub1"),
            Pair("කෘමීන් පාලනය", "pesticiding_sub2"),

            )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            subTopics.forEach { (title, route) ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(68.dp)
                        .clickable { navController.navigate(route) },
                    shape = RectangleShape,
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF5E0)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = title,
                            fontSize = 22.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Start,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
    }
}
