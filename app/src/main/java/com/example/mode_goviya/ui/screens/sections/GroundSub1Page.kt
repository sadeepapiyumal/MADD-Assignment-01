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
import com.example.mode_goviya.ui.components.SpeakerTtsButton

@Composable
fun GroundSub1Page(navController: NavController) {
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
                text = "බිම් සැකසීම",
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
                painter = painterResource(id = R.drawable.groundpreparation),
                contentDescription = "Wet Preparation",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = (-15).dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Page Title
        Text(
            text = "තෙත් ආකාරයෙන් (මඩට) බිම් සැකසීම",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF034503),
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(16.dp))


        // Reusable card function for each sub-subtopic
        SubTopicCard(
            title = "පළමු සී සෑම(පුරන් හීය, බිං නැගුම)\n",
            description = "පස හොඳින් තෙත්ව තිබියදී බිම් සැකසීම සිදු කරයි. මෙහිදී සෙන්ටිමීටර් 15ක් 20ක් පමණ ගැඹුරට පස බුරුල් වන සේ පෙරළීම සිදු කරයි." +
                    "මේ සඳහා සිංහල ගැමි නඟුල, යකඩ නඟුල, මෝල්ඩ්බෝඩ් නඟුල හෝ තැටි නඟුල භාවිතා කරනු ලැබේ.උදලු මගින් ලියදි කෙටීමද සිදු කරයි." +
                    "මේ අන්දමට සී සෑමෙන් පසුගිය කන්නයේ ක්ෂේත්\u200Dරයේ ඉතිරි වූ ඉපනැල්ල හා වල් පැළ පිඬැල්ලට යටවීම නිසා කුණුවීම සිදුවේ." +
                    "පසට යට වී ඇති වල් බීජ මතුපිටට පැමිණීම නිසා විනාශ වේ.තවද ගැඹුරින් ඇති පස් මතුපිට පස සමඟන් මිශ්\u200Dර වන අතර " +
                    "එමගින් පෝෂක මිශ්\u200Dරවීම සිදුවී  බෝග වර්ධනයට වඩා හිතකර තත්ත්වයක් ඇතිවේ.\n" +
                    "\n" +
                    "පළමු සීසෑමෙන් පසුව නියර සුද්ද කළ යුතුය. කාබනික පොහොර ලෙස පිදුරු, ග්ලිරිසීඩියා සහ අඬනහිරියා වැනි ශාක කොළ පොහොර යෙදීම සුදුසුය." +
                    " වර්තමානයේදී අස්වනු නෙලන යන්ත්\u200Dර  මගින් පිදුරු කුඹුරටම වැටෙන බැවින් එවැනි කුඹුරු වලට අමතරව පිදුරු එකතු කිරීම අවශ්\u200Dය නොවේ." +
                    " පළමු සී සෑමෙන් පසු හී කැට අඩක් වැසී යන සේ ජලය බැඳ තබනු ලැබිය යුතුය."

        )

        SubTopicCard(
            title = "දෙවන සී සෑම(දෙ හීය, මඩ හීය)\n",
            description = "පළමු සී සෑම සිදුකර දින 10කට 14කට පසුව දෙවන සීසෑම සිදුකරයි.මුලින් පෙරලන ලද විශාල කැටිති කුඩා කොටස් වලට කඩා ගැනීම" +
                    " දෙවන බිම් සැකසීමේ ප්\u200Dරධාන අරමුණ වේ.පිඬැල්ල පෙරළීමේදී මතුපිටට පැමිණ පැළවුණු වල්පැළ දෙවන හීයේදී විනාශ වේ." +
                    "දෙහීය හෑමට පෙර නියර සහ ඇළ වේලි සුද්ද කළ යුතුය.සිංහල ගැමි නඟුල, රොටවේටරය හෝ කොකු නඟුල භාවිතා කර" +
                    " දෙවන සී සෑම පළමු බිම් සැකසූ දිශාවේ හරස් අතර සිදු කරයි.\n" +
                    "\n" +
                    "දිරාපත් වූ කාබනික පොහොර(දිරාපත් වූ පිදුරු, ගොම පොහොර, කොම්පෝස්ට් පොහොර) දෙහීයෙන් පසු කුඹුරට යෙදීම යෝග්\u200Dය වේ." +
                    "සීසෑමෙන් පසු ඉතුරු වූ හී කැට හොඳින් වැසී යන සේ වතුර බැඳ තැබීම කළ යුතුය."
        )

        SubTopicCard(
            title = "නියර බැඳීම\n",
            description = "දෙවන සී සෑමෙන් පසු නියරෙහි ඇති කක්කුටුගුල්, මී ගුල් ආදිය වසා කැඩුණු තැන් පිළිසකර කර මඩ තැබිය යුතුය." +
                    " මේ මගින් ලියදිවල ජලය රඳවා තබා ගැනීමට හැකි වන අතරින් නියරවල වල්පැළෑටි පැලවීමද පාලනය වේ."
        )

        SubTopicCard(
            title = "මඩ කිරීම හා මට්ටම් කිරීම\n" +
                    "(පෝරුගෑම)\n",
            description = "දෙවන සී සෑමෙන් දින 5කට 7කට පසු පෝරු ගෑම සිදුකරයි. පෝරුව හෝ රොටවේටරයට ලෑල්ලක් සවිකර පෝරු ගෑම සිදු කරයි." +
                    "ලියදි මඩ කිරීමෙන් පසු මතුපිට ඒකාකාරීව මට්ටම් කළ යුතුය. අවශ්\u200Dය වුවහොත් ගොවි පෝරුව භාවිතයෙන් මතුපිට මට්ටම් කිරීම තවදුරටත් කළ හැකිය." +
                    "වී වැපිරීමේදී ඒකාකාරීී බීජ ප්\u200Dරරෝහණයට පස මනා ලෙස මට්ටම් කිරීම අතිශයින් වැදගත්ය."
        )
    }
}

// 🔹 Reusable composable for each sub-subtopic
@Composable
fun SubTopicCard(title: String, description: String) {
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
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                SpeakerTtsButton(textToSpeak = description)
            }
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
