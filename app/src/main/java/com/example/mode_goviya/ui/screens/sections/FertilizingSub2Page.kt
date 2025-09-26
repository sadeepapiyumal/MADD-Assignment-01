package com.example.mode_goviya.ui.screens.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
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
import androidx.navigation.NavController
import com.example.mode_goviya.R

@Composable
fun FertilizingSub2Page(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDFFFD6)) // light green background
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // allow scrolling
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {


        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            // Main Title
            Text(
                text = "පොහොර යෙදීම",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF034503),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .offset(y = 10.dp), // take space on the left
            )

            // Image on the right
            Image(
                painter = painterResource(id = R.drawable.sowing),
                contentDescription = "Organic Fertilizing",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = (-15).dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Page Title
        Text(
            text = "කාබනික පොහොර භාවිතය",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF034503),
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(16.dp))


        // Reusable card function for each sub-subtopic
        SubTopicCard7(
            title = " ",
            description = "දිගින් දිගටම රසායනික පොහොර පමණක් භාවිතා කිරීම නිසා පසෙහි අහිතකර වෙනස්කම්ද,කාබනික ද්\u200Dරව්\u200Dය අඩුවීමද සිදුවේ." +
                    " මේ හේතුව නිසා කුඹුරු වල වී අස්වැන්න අඩුවීම හෝ වැඩි නොවී එක් මට්ටමක රැඳී තිබීම සුලභ තත්ත්වයක් වී තිබේ." +
                    "මෙම තත්ත්වයෙන් මිදීම සඳහා රසායනික පොහොර සහ කාබනික පොහොර යන දෙවර්ගයම යෙදිය යුතු අතර එමඟින්" +
                    " වඩාත් සාර්ථක අස්වැන්නක් ලබාගත හැකිය. තවද කාබනික පොහොර යෙදීමෙන් රසායනික පොහොරවල කාර්යක්ෂමතාවය වැඩිවේ." +
                    " වී වගාව සඳහා කාබනික පොහොර යෙදීම පහත සඳහන් පරිදි සිදු කළ හැක.\n" +
                    "\n" +
                    "•අක්කරයක් සඳහා පසුගිය කන්නයේ සම්පූර්ණ පිදුරු ප්\u200Dරමාණය යෙදීම. බීජ නිෂ්පාදනයේ දී මේ කන්නයේ වගා කරන ප්\u200Dරභේදය" +
                    " පසුගිය කන්නේ වගාකල ප්\u200Dරභේදයට වඩා වෙනස් වන්නේ නම් පසුගිය කන්නේ පිදුරු නොයෙදිය යුතුය.\n" +
                    "\n" +
                    "•කොළ පොහොර (ග්ලිරිසීඩියා, වල් සූරියකාන්ත, එරබදු, සෙස්බේනියා හා ඉපිල් ඉපිල් වැනි ශාක) අක්කරයකට කිලෝ 400 සමග " +
                    "කොම්පෝස් කිලෝ 1000ක් හෝ ගොම පොහොර කිලෝ 1600ක් හෝ දිරාපත් වූ කුකුල් පොහොර කිලෝ 800ක්" +
                    " පළමු සීසෑමෙන් පසුව යෙදීම.\n" +
                    "\n" +
                    "•කර දහයියා අක්කරයකට කිලෝ ග්\u200Dරෑම් 250ක් දෙවන සීසෑමෙන් පසුව යෙදීමද සුදුසුවේ.\n"

        )



    }
}

// 🔹 Reusable composable for each sub-subtopic
@Composable
fun SubTopicCard7(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RectangleShape, // default rounded
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF7E6))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF034503)
            )
            Spacer(modifier = Modifier.height(6.dp))
            Text(
                text = description,
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                color = Color.Black
            )
        }
    }
}
