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
fun SowingSub3Page(navController: NavController) {
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
            text = "වියළි ක්\u200Dරමයට වී වැපිරීම\n",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF034503),
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(16.dp))


        // Reusable card function for each sub-subtopic
        SubTopicCard5(
            title = " ",
            description = "මෝසම් වර්ෂාව ප්\u200Dරමාද වන යල හා මහා කන්න වල වැලි සහිත කුඹුරුවල සිදුකරනු ලබයි." +
                    "බිම් සැකසීම වියළි ලෙස සිදුකර, වියළි බීජ වැඩි ගනත්වයකින් වපුරයි. මෙය කැකුළන් වගාව ලෙසද හඳුන්වනු ලැබේ." +
                    "මෙමගින් වර්ෂාව අඩු කාල සඳහා වාලි ජලය ඉතුරු කර ගත හැකිය.\n" +
                    "\n" +
                    "මෙම ක්\u200Dරමයට වගා කිරීමේදී බීජ වලට සිදුවිය හැකි හානිය වැඩි බැවින්ද වල්පැළ ගහනය අවම කර ගැනීම සඳහාද" +
                    " අක්කරයට කිලෝ ග්\u200Dරෑම් 60ත් 100ත් අතර බීජ ප්\u200Dරමාණයක් භාවිතා කරයි.\n"

        )



    }
}

// 🔹 Reusable composable for each sub-subtopic
@Composable
fun SubTopicCard5(title: String, description: String) {
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
