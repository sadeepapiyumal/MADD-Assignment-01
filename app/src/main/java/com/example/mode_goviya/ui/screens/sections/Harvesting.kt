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

@Composable
fun HarvestingPage(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDFFFD6))
            .padding(6.dp)
            .verticalScroll(rememberScrollState()),
    ) {
        // Top Row with title and image
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "අස්වනු නෙලීම",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF034503),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .offset(y = 15.dp)

            )

            Image(
                painter = painterResource(id = R.drawable.harvesting),
                contentDescription = "Harvesting",
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
                text = "ගොයම කැපීම හා ගොයමින් වී වෙන්කර ගැනීම හෙවත් කොළ මැඩීම අස්වනු නෙළීමේ ප්\u200Dරධාන අදියර වේ." +
                        "අස්වනු නෙළීමට සති 2කට පමණ පෙර සිට පස වියළිව තැබීම යෝග්\u200Dය වේ." +
                        " මෙමගින් පරිණතිය හා ධාන්\u200Dය මේරීම කඩිනම් වන අතර අස්වනු නෙළීමද පහසුවේ.\n" +
                        "\n" +
                        "වගාව සුදුසු පැසුණු අවස්ථාවට පැමිණ විට ගොයම කැපිය යුතුය ක්ෂේත්\u200Dරය සමස්තයක් ලෙස පරීක්ෂා කර මෙය තීරණය කිරීම වැදගත්ය." +
                        " එමෙන්ම පත්\u200Dරවල පැහැය නොව කරල්වල පැහැය ගැන සැලකිලිමත් වීම වැදගත්ය." +
                        "බොහෝමයක් නව වී ප්\u200Dරභේදවල ගොයම් කැපීමට සුදුසු අවස්ථාව වන විටද පත්\u200Dර කොළ පැහැයෙන්ම පවතී." +
                        "අස්වැන්න නෙළීම සඳහා ඉතා සුදුසු අවස්ථාව ලෙස කරලක ඇටවලින් 85% ක් පමණ රන්වන් පැහැයට හැරුණු අවස්ථාව සැලකේ." +
                        " ඊට පෙර අස්වනු නෙළීමෙන් ලැබෙන නොමේරූ බීජ ගබඩා කිරීමේදී බොල් බවට පත්වේ.\n" +
                        "\n" +
                        "අස්වනු නෙළීම දෑකැති ආධාරයෙන්, ගොයම් කපන යන්ත්\u200Dර මගින් හෝ සංයුක්ත කොළඹ මඩින යන්ත්\u200Dර මගින් සිදුකෙරේ." +
                        " අස්වනු නෙළීම ප්\u200Dරමාද වන විට බීජ හැලීම වැඩිවන නිසා අස්වනු හානිය ද වැඩිවේ." +
                        "අස්වනු නෙලීම ප්\u200Dරමාද වූ වගාවන් වල සංයුක්ත අස්වනු නෙලන යන්ත්\u200Dරයෙන් නෙළීමේදී ඉතා අධික අස්වනු හානියක් සිදුවිය හැකිය.\n",
                fontSize = 16.sp,
                textAlign = TextAlign.Justify,
                modifier = Modifier.padding(16.dp)
            )
        }

        Spacer(modifier = Modifier.height(24.dp))




    }
}
