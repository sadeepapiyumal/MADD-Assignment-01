package com.example.mode_goviya.ui.screens.sections

import androidx.compose.foundation.clickable
import androidx.navigation.NavController
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
fun StoringPage(navController: NavController) {
    val description = "වී වගාවේදී ගබඩාකරණය ඉතා වැදගත් පියවරකි.නිසි ආකාරයෙන් ගබඩා නොකිරීම නිසා සැලකිය යුතු අස්වනු හානියක් සිදුවේ." +
            " වී ගබඩා කිරීම සඳහා නිසි ප්\u200Dරමිතියෙන් යුතු ගබඩාවක් භාවිතා කිරීම අත්\u200Dයවශ්\u200Dය වේ.\n" +
            "\n" +
            "වී ගබඩා කිරීමට ප්\u200Dරථම ගබඩාව පිටත හා ඇතුළත හොඳින් පිරිසිදු කරගත යුතුය." +
            "ගබඩාව අවට පරිසරය හොඳින් පිරිසිදු කර අවට ඇති උසට වැඩුණු තණකොළ ආදිය කපා දැමිය යුතුය." +
            "ගොඩනැගිල්ල ආසන්නයේ ඇති ගස්වල අතුද කපා ඉවත් කළ යුතුය.මී ගුල් සහ කෘමීන් බෝවිය හැකි ස්ථාන ඇත්නම් " +
            "වී ගබඩා කිරීමට පෙර ඒවා වසා දැමිය යුතුය. තවද ගබඩාව ඇතුළත ඇති අපද්\u200Dරව්\u200Dය," +
            " දූවිලි, ධාන්\u200Dය කැබලි ආදිය ඉවත් කර පුළුස්සා දැමිය යුතුය.\n" +
            "\n" +
            "වී ගෝනි ඇසිරීමට ගන්නා ලී තට්ටු හා ගෝනි කෘමීන්ගෙන් තොර විය යුතුය. පොළොව හා බිත්තිය සමඟ නොගෑවෙන ලෙස" +
            " ලී රාමුවක් මත හෝ ලී දඬු මත පේළි දෙකක් වන සේ වී ගෝනි ඇසිරිය හැක. ගුල්ලන්, ඉපියන්, මීයන්, කුරුල්ලන්" +
            " වැනි සතුන්ගෙන් බීජ වලට හානි වීමට ඉඩ ඇති බැවින් ගබඩා කර ඇති වී වරින් වර පරීක්ෂා කර බලා යම් හානියක් " +
            "සිදුවී ඇත්නම් නැවත පිරිසිදු කර වියලා ගත යුතුය.\n" +
            "\n" +
            "ගබඩාවේ උෂ්ණත්වය සෙල්සියස් අංශක 25 ට අඩුව තබා ගැනීම සුදුසුය.දිවා කාලයේ ගබඩාව තුළ උෂ්ණත්වය සහ" +
            " ආර්ද්\u200Dරතාවය ඉහළ යෑම වැළැක්වීම සඳහා වාත කවුළු විවෘත කර තබා සවස් වන විට ඒවා වසා දැමිය යුතුය." +
            " නමුත් වැසි දිනවලදී ගබඩාව තුළට ජලවාෂ්ප ඇතුළු වීම වැළැක්වීම සඳහා වාත කවුළු වසා තැබිය යුතුය.\n"
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDFFFD6))
            .padding(5.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        // Top Row with title and image
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "අස්වනු ගබඩා කිරීම",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF034503),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .offset(y = 25.dp)

            )

            Image(
                painter = painterResource(id = R.drawable.storing),
                contentDescription = "Storing",
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




    }
}
