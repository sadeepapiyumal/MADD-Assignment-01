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
fun GroundPreparationPage(navController: NavController) {
    val description = "වී වගාව සඳහා බිම් සැකසීම මගින් වැපිරීම සඳහා පස සකසා ගැනීම, වල් පැළෑටි පාලනය, මුල් වර්ධනය ක්\u200Dරමවත් කිරීම," +
            " කාබනික ද්\u200Dරව්\u200Dය පසට මිශ්\u200Dර කිරීම හා පළිබෝධ පාලනය කිරීම යන අරමුණු ඉටුකර ගත හැකිය." +
            " බිම් සැකසීම තෙත් සහ විය ලියන ආකාර වලින් සිදු කළ හැකි අතර බහුලව භාවිතා වෙන්නේ තෙත් ආකාරයට(මඩට) බිම් සැකසීමයි.\n" +
            "\n" +
            "වැඩිදුර තොරතුරු සඳහා අදාළ විස්තරය ස්පර්ශ කරන්න."
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
                text = "බිම් සැකසීම",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF034503),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .offset(y = 25.dp)

            )

            Image(
                painter = painterResource(id = R.drawable.groundpreparation),
                contentDescription = "Ground Preparation",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = (-10).dp)
            )
        }

        Spacer(modifier = Modifier.height(1.dp))

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
                        .padding( bottom = 8.dp, top = 1.dp),
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    SpeakerTtsButton(
                        textToSpeak = description,
                        modifier = Modifier
                            .size(28.dp)

                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Subtopic Sections
        val subTopics = listOf(
            Pair("තෙත් ආකාරයට(මඩට)\nබිම් සැකසීම", "ground_preparation_sub1"),
            Pair("වියලි ආකාරයට(ගොඩට)\nබිම් සැකසීම", "ground_preparation_sub2"),
            Pair("අවම බිම් සැකසීම", "ground_preparation_sub3")
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
