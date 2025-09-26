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
fun PesticidingSub2Page(navController: NavController) {
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
                text = "පළිබෝධ පාලනය",
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
                painter = painterResource(id = R.drawable.pesticiding),
                contentDescription = "pesticiding",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = (-15).dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Page Title
        Text(
            text = "කෘමීන් පාලනය",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF034503),
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(16.dp))


        // Reusable card function for each sub-subtopic
        SubTopicCard(
            title = " ",
            description = "කෘමි හා මයිටා පළිබෝධකයන් වී වගාවේ දී සැලකිය යුතු තර්ජනයක් වන අතර කෘමි පළිබෝධකයින්ගෙන් වන අස්වනු හානිය 10% - 20% ත් අතර වේ.\n" +
                    "කෘමීන් හා මයිටාවන් පාලනය සඳහා ඒකාබද්ධ පළිබෝධ කළමනාකරණ උපක්\u200Dරම අනුගමනය කිරීම වඩා සාර්ථක ක්\u200Dරමයයි." +
                    "වී වගා පරිසරයේ සිටින හිතකර සතුන් මගින්, වී වගාවට හානි කරන කෘමීන් ස්වභාවිකව පාලනය වීමට ඉඩදියය යුතුවේ." +
                    "මේ සඳහා හැකිතාක් දුරට රසායනික ද්\u200Dරව්\u200Dය භාවිතය අවම කර අවසාන විසඳුම ලෙස පළිබෝධනාශක භාවිතා කළ යුතුය." +
                    "කෘෂිකර්ම දෙපාර්තමේන්තුව විසින් පළිබෝධනාශක නිර්දේශය වරින් වර වෙනස් කිරීමට ලක් කිරීමේදී බොහෝ විට අලුතින් නිර්දේශ වන කෘමිනාශක " +
                    "පැරැණි ඒවාට වඩා හානිකර ලක්ෂණ අඩු බැවින් පවතින අලුත්ම නිර්දේශය භාවිතා කිරීම සුදුසුය. ඒකාබද්ධ පළිබෝධ පාලනයේදී පහත සඳහන් " +
                    "ක්\u200Dරියාමාර්ග අනුගමනය කළ යුතුය."

        )

        SubTopicCard8(
            title = "ඒකාබද්ධ පළිබෝධ පාලනය\n",
            description = "•වගාව කන්නයට අනුවම ආරම්භ කර යාය එකවර වගා කිරීම.\n" +
                    "\n" +
                    "•වගා කරන ප්\u200Dරදේශයේ බහුලව වැළඳෙන රෝග හා කෘමි හානිවලට ඔරොත්තු දෙන ප්\u200Dරභේද වගා කිරීම.\n" +
                    "\n" +
                    "•වගාවේ නියමිත පැළ ගහණය පවත්වා ගැනීම.\n" +
                    "\n" +
                    "•වගාව අවට හා වගාව තුළ වල්පැළෑටි නිසියාකාරව මර්ධනයය කිරීම.\n" +
                    "\n" +
                    "•අවස්ථාවට උචිත පරිදි කුඹුරේ ජලය  මැනවින්  පාලනය.\n" +
                    "\n" +
                    "•වගාවේ ආරම්භයේ සිට අවසානය දක්වා නිරතුරුවම සුපරික්ෂාකාරී වී හානිය මුලින්ම හඳුනාගෙන ඊට උචිත ක්\u200Dරම භාවිතා කිරීම.\n" +
                    "\n" +
                    "•එමගින් හානිය පාලනය වන බව නොපෙනේනම් ඒ සඳහා නිර්දේශිත කෘමිනාශකයක් යෙදීම.\n"
        )


    }
}

// 🔹 Reusable composable for each sub-subtopic
@Composable
fun SubTopicCard9(title: String, description: String) {
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
