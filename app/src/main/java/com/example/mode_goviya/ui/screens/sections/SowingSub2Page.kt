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
fun SowingSub2Page(navController: NavController) {
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
                text = "බීජ වැපිරීම",
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
                contentDescription = "Wet Sowing",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = (-15).dp)
            )
        }

        Spacer(modifier = Modifier.width(8.dp))

        // Page Title
        Text(
            text = "තෙත් ක්\u200Dරමයට වී වැපිරීම\n",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF034503),
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(16.dp))


        // Reusable card function for each sub-subtopic
        SubTopicCard4(
            title = " ",
            description = "මේ සඳහා මුල් අද්දවා අද්දවා ගත් (කණු කැපුණු) බිත්තර වී යොදා ගනියි. බිත්තර වී අවශ්\u200Dයතාවය මධ්\u200Dයස්ථ දිගට වී (නාඩු) සඳහා" +
                    " අක්කරයකට කිලෝ ග්\u200Dරෑම් 41ක්ද, කුඩා රවුම් වී (සම්බා) සඳහා   අක්කරයකට කිලෝ ග්\u200Dරෑම් 32ක්ද වේ." +
                    "වැපිරීම සඳහා බිත්තර වී පැල කර ගැනීම පහත සඳහන් පරිදි සිදුකරයි.\n" +
                    "\n" +
                    "\n" +
                    "•පළමුව බීජ වල පැලවීමේ ප්\u200Dරමාණය පරීක්ෂා කිරීම සඳහා බීජ නියැදියක් (බීජ දෝතක් පමණ) පැළ කර බැලිය යුතුය.\n" +
                    "\n" +
                    "•බීජ පිරිසිදු ජලයෙන් හොඳින් සෝදා බෝල් හා අනෙකුත් අපද්\u200Dරව්\u200Dය ඉවත් කරගත යුතුය.\n" +
                    "\n" +
                    "•සුදුසු භාජනයක දමා පැය 24 ක් පිරිසිදු ජලයේ හොඳින් පැඟවිය යුතුය. මෙම කාලය තුළ දෙවරක්වත් ජලය මාරු කිරීම සුදුසුවේ.\n" +
                    "\n" +
                    "•මෙසේ පඟවා ගත් බීජ මුල් අද්දවා ගැනීමට සුදුසු ස්ථානයක පැය 48ක් යහන් ගත කර තැබිය යුතුය. මෙහිදී බිමට කෙසෙල් කොළ හෝ හබරල කොළ දමා" +
                    " සෙන්ටි මීටර් 10ක් පමණ ගණකමට ඒකාකාරීව බීජ අතුරා ඒ මත නැවත කෙසේ කළ හෝ හබරල කොළ අතුරා තෙත ගෝනි යොදා බර තැබිය යුතුය." +
                    "\n" +
                    "\n" +
                    "•කන්නය ප්\u200Dරමාද වී නම් පැළ මැක්කාගේ හානිය පාලනය කිරීම සඳහා පොඟවා ගත් බීජ සඳහා සුදුසු බීජ ප්\u200Dරතිකාරකයක් යෙදිය යුතුය.\n" +
                    "\n" +
                    "•අයහපත් කාලගුණ තත්ත්වයන් යටතේ වැපිරීම ප්\u200Dරමාද වන්නේ නම් යහන කඩා, තුනී කර, තෙතමනය ආරක්ෂාවන පරිදි දින දෙක තුනක් පමණ තබාගත හැකිය." +
                    "\n" +
                    "\n" +
                    "•වැපිරීමට පෙර ලියද්ද හොඳින් මට්ටම් කර වැඩිපුර ජලය කඩා හැර තිබීම වැදගත්ය. වර්ග මීටරයකට බීජ 400ක් පමණ වැටෙන සේ ඒකාකාරීව වැපිරිය යුතුය." +
                    " බීජ වපුරා දින 7-10 කට පසු ලියද්දට හොඳින් වතුර බැඳීමෙන් වල් පැළ වර්ධනය අවම කර ගත හැකිය.\n"

        )



    }
}

// 🔹 Reusable composable for each sub-subtopic
@Composable
fun SubTopicCard4(title: String, description: String) {
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
