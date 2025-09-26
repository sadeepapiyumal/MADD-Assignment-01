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
fun PesticidingSub1Page(navController: NavController) {
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
                contentDescription = "Herbiciding",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = (-15).dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Page Title
        Text(
            text = "වල්පැළෑටි පාලනය",
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
            description = "වී වගාව සඳහා බලපාන පළිබෝධකයන් අතුරින් වල්පැළ මගින් සිදුවන හානිය ඉතා අධික වේ." +
                    "වල්පැළ පළල් පත්\u200Dර තෘණ  සහ පන් වර්ග ලෙස ප්\u200Dරධාන කාණ්ඩ 3කි." +
                    " වල්පැළ පාලනය නිසි පරිදි නොකිරීම නිසා ලබාගත හැකි අස්වැන්න සැලකිය යුතු ප්\u200Dරමාණයකින්" +
                    " අඩුවන අතර සමහර අවස්ථාවලදී අස්වනු හානිය 100%ක්ම විය හැකිය.වගාවේ වල්පැළෑටි පාලනය " +
                    "සාර්ථක වීම සඳහා වගාවේ පළමු දින 30 තුළ කුඹුරේ වල්පැළෑටි මැනවින් පාලනය කර තබා ගැනීම විශේෂයෙන් වැදගත් වේ." +
                    " වී වගාවේ වල්පැළෑටි පාලනය සාර්ථක වීම සඳහා එකම ක්\u200Dරමයක් මත පමණක් බලාපොරොත්තු නොතබා" +
                    " පහසුවෙන් සිදු කළ හැකි ක්\u200Dරම කිහිපයක් අනුගමනය කිරීම මගින් (ඒකාබද්ධ වල්පැළෑටි පාලනය)" +
                    " සාර්ථක ප්\u200Dරතිඵල ලබාගත හැකියි.\n"

        )

        SubTopicCard8(
            title = "ඒකාබද්ධ වල්පැළෑටි පාලනය\n",
            description = "•නියම වෙලාවට වගා කිරීම.\n" +
                    "\n" +
                    "•නිවැරදිව බිම් සැකසීම.\n" +
                    "\n" +
                    "•වනාත, ඇළ, කන්ඩි හොඳින් සුද්ද කිරීම.\n" +
                    "\n" +
                    "•වල් බීජ වලින් තොර ගුණාත්මක බිත්තර වී භාවිතය.\n" +
                    "\n" +
                    "•බිත්තර වී පෙඟවීමට පිරිසිදු ජලය භාවිතා කිරීම.\n" +
                    "\n" +
                    "•වල් බීජ බිත්තර වී සමග නැවතත් කුඹුරට ඇතුල්විය හැකි බැවින් ඇළ වේලි වල ජලයෙන් බිත්තර වී සේදීමෙන් වැළකීම.\n" +
                    "\n" +
                    "•හැකි සෑම විටම වී වැපිරීම වෙනුවට පේළියට පැළ සිටුවීම (අතින් හෝ යන්ත්\u200Dර මගින්).\n" +
                    "\n" +
                    "•හොඳින් මට්ටම් කළ කුඹුරේ ජලය කපා හැර දින 3-4 ක් පමණ තබා මතුපිට ස්තරයේ වල් ඇට පැළ වූ පසු ගොවි ලෑල්ලක ආධාරයෙන් පසට යට කිරීම හෝ වල්නාශකයක් යොදා විනාශ කිරීම.\n" +
                    "\n" +
                    "•පැළ ඝනව වැඩෙන තෙක් (සෙන්ටිමීටර් 5-10 ක්) ප්\u200Dරමාණවත්ව ලියද්දේ ජලය බැඳ තබා වල් පැළ දුටු විට අතින් උගුල්ලා දැමීම.\n" +
                    "\n" +
                    "•කරල් පීදෙන අවස්ථාවේදී දක්නට ලැබෙන වල් වී, බජිරි, අශ්වවලිග වැනි වල් වර්ග වල කරල් කපා කුඹුරෙන් ඉවත් කිරීම.\n" +
                    "\n" +
                    "•අස්වනු නෙළීමේදී භාවිතා කරන යන්ත්\u200Dර සහ අතුරණු වල්බීජ වලින් තොරව තබා ගැනීම.\n"
        )


    }
}

// 🔹 Reusable composable for each sub-subtopic
@Composable
fun SubTopicCard8(title: String, description: String) {
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
