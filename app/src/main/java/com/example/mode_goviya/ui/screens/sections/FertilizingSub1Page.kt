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
fun FertilizingSub1Page(navController: NavController) {
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
                contentDescription = "Chemical Fertilizing",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = (-15).dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Page Title
        Text(
            text = "රසායනික පොහොර භාවිතය",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF034503),
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(16.dp))


        // Reusable card function for each sub-subtopic
        SubTopicCard6(
            title = " ",
            description = "රසායනික පොහොර, පෝෂක ඉතා වැඩි ප්\u200Dරමාණයකින් යුක්ත වන අතර ඉතා අඩු පොහොර ප්\u200Dරමාණයකින් පෝෂක අවශ්\u200Dයතාවය සපුරාලයි." +
                            " ශාක වලට අවශ්\u200Dය එක් එක් පෝෂකය ලබාදිය හැකි රසායනික පොහොර වර්ග රාශියක් ඇත. " +
                            "මේ අතුරින් ශාකයට අවශ්\u200Dය ප්\u200Dරධාන පෝෂක තුන වන නයිට්\u200Dරජන්, පොටෑසියම් හා පොස්පරස් ලබාදෙන යූරියා, මියුරියේට් ඔෆ් පොටෑෂ් හා " +
                            "ට්\u200Dරිපල් සුපර් පොස්පේට් යන පොහොර වර්ග තුන වී වගාවේදී ප්\u200Dරධාන වශයෙන් භාවිතා වෙයි.\n" +
                            "\n" +
                            "පොහොර යෙදීමේදී කාලගුණය, ජලය යොදන ක්\u200Dරමය, පැළ සිටුවීමේ ක්\u200Dරමය හා අස්වනු නෙළීමට ගතවන කාලය පිළිබඳව සැලකිලිමත් වීම ඉතා වැදගත්ය." +
                            "ඒ අනුව යොදන පොහොර ප්\u200Dරමාණය හා අවස්ථාව වෙනස් වේ.\n" +
                            "\n" +
                            "පොහොර වර්ග කිහිපයක් යොදන අවස්ථාවලදී ඒවා වෙන වෙනම ගෙන, යෙදීමට පෙර හොඳින් මිශ්\u200Dර කර යෙදිය යුතුය." +
                            " මූලික පොහොර යෙදීමේදී පස මතුපිටට නොව පසට මිශ්\u200Dරවන ලෙස යෙදිය යුතුය.ඒ සඳහා බීජ වැපිරීමට හෝ පැළ සිටුවීමට පෙර කුඹුර පෝරු ගාන අවස්ථාවේදී " +
                            "පොහොර යෙදීම කළ හැකිය.පෝරු ගා අවසානයේ පොහොර යොදා පෝරු ලෑල්ලක ආධාරයෙන් තුනී මඩ තට්ටුවකින් වැසී යන ආකාරයට මිශ්\u200Dර කළ යුතුය." +
                            "\n"

        )



    }
}

// 🔹 Reusable composable for each sub-subtopic
@Composable
fun SubTopicCard6(title: String, description: String) {
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
