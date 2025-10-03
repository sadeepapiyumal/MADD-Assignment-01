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
fun SowingPage(navController: NavController) {
    val description = "වී වගාවෙන් වැඩි අස්වැන්නක් ලබා ගැනීම සඳහා කන්නයට හා ප්\u200Dරදේශයට ගැලපෙන විවර්ගය තෝරාගත යුතුය. මෙයට අමතරව පාරිභෝගික රුචිකත්වය පිළිබඳව ද සැලකිලිමත් විය යුතුය.\n" +
            "\n" +
            "බීජ වැපිරීම ප්\u200Dරධාන වශයෙන් තෙත් ක්\u200Dරමයට හෝ වියළි ක්\u200Dරමයට සිදුකළ හැකිය.\n" +
            "\n" +
            "වැඩිදුර තොරතුරු සඳහා අදාළ විස්තරය ස්පර්ශ කරන්න.\n"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDFFFD6))
            .padding(6.dp)
    ) {
        // Top Row with title and image
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "බීජ වැපිරීම",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF034503),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .offset(y = 15.dp)

            )

            SpeakerTtsButton(
                textToSpeak = description,
                modifier = Modifier
                    .offset(y = 0.dp)
                    .size(36.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.sowing),
                contentDescription = "Sowing",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = (-15).dp)
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
            Text(
                text = description,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Subtopic Sections
        val subTopics = listOf(
            Pair("බිත්තර වී භාවිතය", "sowing_sub1"),
            Pair("තෙත් ක්\u200Dරමයට වී වැපිරීම", "sowing_sub2"),
            Pair("වියළි  ක්\u200Dරමයට වී වැපිරීම", "sowing_sub3")
        )

        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            subTopics.forEach { (title, route) ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(60.dp)
                        .clickable { navController.navigate(route) },
                    shape = RectangleShape,
                    colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF5E0)),
                    elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
                ) {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier.padding(horizontal = 16.dp)
                    ) {
                        Text(
                            text = title,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Medium,
                            textAlign = TextAlign.Center
                            //color = Color(0xFF000000)
                        )
                    }
                }
            }
        }
    }
}
