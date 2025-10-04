package com.example.mode_goviya.ui.screens.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mode_goviya.R
import com.example.mode_goviya.ui.components.SpeakerTtsButton

@Composable
fun WateringPage(navController: NavController) {
    val context = LocalContext.current

    val description = "වැසි ජලය භාවිතයෙන් පහත් බිම් වල සිදු කරන වී වගාවේ දී වැපිරීමෙන් හෝ පැළ සිටුවීමෙන් පසු" +
            " සෙන්ටිමීටර් 4 - 5 ක් උසට ජලය බැඳ තබයි. මෙලෙස අනවශ්‍ය ප්‍රමාණ වලින්" +
            " ලියැදිවල ජලය දිගටම බැඳ තැබීම නිසා ජලයෙන් වැඩි කොටසක් අපතේ යයි." +
            " මේ නිසා වී ශාකය ජලයට වඩාත් සංවේදී වන බණ්ඩි හා මල් පිපෙන අවදිවලදී ප්‍රමාණවත් ලෙස " +
            "ජලය සපයා ගැනීමට නොහැකි වුවහොත් එය වී වගා කරන ප්‍රදේශවල අස්වැන්න අඩුවීමට ප්‍රධාන ලෙස බලපායි." +
            " එම නිසා වගාවට නිවැරදිව ජලය සැපයීමෙන් උපරිම වී අස්වැන්නක් ලබා ගැනීම වර්තමානයේ ඉතාමත් වැදගත්ය.\n"

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
                text = "ජලය යෙදීම",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF034503),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .offset(y = 25.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.watering),
                contentDescription = "Watering",
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
                        .padding(bottom = 18.dp, top = 1.dp),
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

        // Speaker button above handles TTS
    }
}
