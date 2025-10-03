package com.example.mode_goviya.ui.screens.sections

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
import androidx.navigation.NavController
import com.example.mode_goviya.R
import com.example.mode_goviya.ui.components.SpeakerTtsButton

@Composable
fun SowingSub1Page(navController: NavController) {
    val descriptionText = "වී වගාව සඳහා සෑම විටම පළවීමේ ශක්තියෙන් වැඩි, වෙනස් වී වර්ග සමග මිශ්‍රව නොමැති, " +
            "අපද්‍රව්‍ය, වල් බීජ හා හානි වූ බීජ අවම මට්ටමකින් පවතින උසස් ගුණාත්මක භාවයෙන් යුතු බිත්තර වී භාවිතා කළ යුතුය. " +
            "එමගින් නිරෝගී, ශක්තිමත්, ඒකාකාරී පැල ගහණයක් හා ඉහළ අස්වැන්නක් ලබාගත හැකිය.\n\n" +
            "වගාව සඳහා අවශ්‍ය කරන බිත්තර වී කෘෂිකර්ම දෙපාර්තමේන්තුවේ බිත්තර ගොවිපළවලින් හා ලියාපදිංචි ගොවීන්ගෙන් ලබාගත හැකි අතර " +
            "ගොවිමහතුන්ට තමා විසින්ම බිත්තර වී නිෂ්පාදනය කිරීමද කළැකිය.\n\n" +
            "නියමිත කන්නයට සහ යායේ සියලු ගොවීන් එකට වගා කිරීම තුළින් වර්ෂා ජලය උපරිම ලෙස ප්‍රයෝජනයට ගැනීමත්, " +
            "රෝග හා පලිබෝධ වලින් වගාව ආරක්ෂා කර ගැනීමත්, වාරි ජලය කාර්යක්ෂමව ප්‍රයෝජනයට ගැනීමත් සිදුකළ හැක.\n\n" +
            "වියලි සහ අතරමැදි කලාපවල වර්ෂාපෝෂිත කුඹුරුවල යල සහ මහ කන්නයේ වී වගාව කළ යුතු ආකාරයේ පහත වගු වල සඳහන් වේ."

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFDFFFD6)) // light green background
            .padding(16.dp)
            .verticalScroll(rememberScrollState()), // allow scrolling
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        // Title row with text (left) and image (right)
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Top
        ) {
            Text(
                text = "බීජ වැපිරීම",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF034503),
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .weight(1f)
                    .offset(y = 10.dp),
            )

            Image(
                painter = painterResource(id = R.drawable.sowing),
                contentDescription = "Egg Seed Usage",
                modifier = Modifier
                    .size(100.dp)
                    .offset(y = (-15).dp)
            )
        }

        Spacer(modifier = Modifier.height(8.dp))

        // Page Title
        Text(
            text = "බිත්තර වී භාවිතය",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF034503),
            textAlign = TextAlign.Left,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Page description before tables
        Text(
            text = descriptionText,
            fontSize = 16.sp,
            textAlign = TextAlign.Justify,
            color = Color.Black,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🔊 Speaker icon button near header to read the description
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SpeakerTtsButton(textToSpeak = descriptionText)
        }

        Spacer(modifier = Modifier.height(20.dp))

        // First subtopic card with table
        SubTopicCardWithTable(
            title = "මහ කන්නේ බිම් සැකසීම සහ වැපිරීම සඳහා\nසුදුසු වී වගා කාලසටහන",
            description = "",
            tableData = listOf(
                listOf("වයස් කාණ්ඩය", "බිම් සැකසීම", "වැපිරීම"),
                listOf("මාස 4 – 4   හමාර", "සැප්තැම්බර් මැද", "ඔක්තෝබර් මුල"),
                listOf("මාස 3  හමාර", "සැප්තැම්බර් අග", "ඔක්තෝබර් මැද"),
                listOf("මාස 3", "ඔක්තෝබර් මුල", "ඔක්තෝබර් අග"),
                listOf("දින 80 - 85", "ඔක්තෝබර් මැද", "නොවැම්බර් මුල")
            )
        )

        // Second subtopic card with table
        SubTopicCardWithTable(
            title = "යල කන්නේ බිම් සැකසීම සහ වැපිරීම සඳහා\nසුදුසු වී වගා කාලසටහන",
            description = "",
            tableData = listOf(
                listOf("වයස් කාණ්ඩය", "බිම් සැකසීම", "වැපිරීම"),
                listOf("මාස 4 – 4   හමාර", "මාර්තු මැද", "අප්‍රේල් මුල"),
                listOf("මාස 3  හමාර", "මාර්තු අග", "අප්‍රේල් මැද"),
                listOf("මාස 3", "අප්‍රේල් මුල", "අප්‍රේල් මැද"),
                listOf("දින 80 - 85", "අප්‍රේල්   අග", "මැයි මැද")
            )
        )
    }
}

@Composable
fun SubTopicCardWithTable(title: String, description: String, tableData: List<List<String>>) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RectangleShape,
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFF7E6))
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = title,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF034503)
            )
            Spacer(modifier = Modifier.height(6.dp))
            if (description.isNotEmpty()) {
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
                Spacer(modifier = Modifier.height(8.dp))
            }

            // Table
            SimpleTable(tableData)
        }
    }
}

@Composable
fun SimpleTable(data: List<List<String>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp)
    ) {
        data.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 2.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                row.forEach { cell ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .height(60.dp)
                            .padding(2.dp)
                            .background(Color(0xFFE0F7FA))
                            .padding(6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(
                            text = cell,
                            fontSize = 14.sp,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
