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
fun GroundSub3Page(navController: NavController) {
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
            text = "වියලි ආකාරයට(ගොඩට)\n" +
                    "බිම් සැකසීම",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF034503),
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.width(16.dp))


        // Reusable card function for each sub-subtopic
        SubTopicCard2(
            title = "අවම බිම් සැකසීම\n",
            description = "වර්ෂාව ප්\u200Dරමාද වූ විට හෝ බිම් සැකසීම සඳහා ප්\u200Dරමාණවත් ලෙස ජලය නොමැති විට කෙටි කලකින් බිම් සකස් කර ගැනීම සඳහා" +
                    " අවම බිම් සැකසීම සිදු කළ හැකිය. මෙහිදී පසේ ව්\u200Dයුහයට වන හානිය අඩු වන අතර පළමු හීය වෙනුවට වල් නාශක භාවිතා කරයි." +
                    " වල් පැළ මැරුණු පසුව රොටවේටරයෙන් සී සා බීජ වපුරයි. පේලියට වපුරන්නේ නම් දෙවන හීය පේළි වලට පමණක් සීමා වෙයි." +
                    " නියර සුද්ද කිරීම අවමය.\n"

        )



    }
}

// 🔹 Reusable composable for each sub-subtopic
@Composable
fun SubTopicCard2(title: String, description: String) {
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
