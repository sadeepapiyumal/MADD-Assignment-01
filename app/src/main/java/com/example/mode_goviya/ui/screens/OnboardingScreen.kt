package com.example.mode_goviya.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.mode_goviya.R
import com.example.mode_goviya.util.Prefs
import kotlinx.coroutines.launch
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.ExperimentalFoundationApi

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnboardingScreen(navController: NavController, prefs: Prefs) {
    // define pages
    val pages = listOf(
        OnboardPage(
            imageRes = R.drawable.logo2,
            description = "නිවැරදි ක්‍රමයෙට වගා කිරීමෙන් හා ගබඩා කිරීමෙන්\nඔබේ අස්වැන්න වැඩි කරගත හැකි බව ඔබ දන්නවාද?\n\n\n වගා කරන හරිම ක්රමය \n" +
                    "දැන් ඔබේ අතේ",
            textOffsetY = -100

        ),
        OnboardPage(
            imageRes = R.drawable.logo2,
            description = "නිවැරදි උපදෙස් ලබා ගැනීමට අදාළ ලැයිස්තුවෙන් දිස්රික්කය  සහ වී වර්ගය තෝරන්න",
            textOffsetY = 0

        ),
        OnboardPage(
            imageRes = R.drawable.logo2,
            description = "අවශ්ය උපදෙස් කියවීමට හෝ සවන් දීමට අදාළ නම මත ස්පර්ශ කරන්න.",
            textOffsetY = -100

        ),
        OnboardPage(
            imageRes = R.drawable.logo2,
            description = "අදාළ විස්තරයට සවන් දීම සඳහා         බොත්තම ඔබන්න",
            textOffsetY = 0

        )
    )

    val pageCount = pages.size
    val pagerState = rememberPagerState(initialPage = 0, pageCount = { pageCount })
    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(10.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Pager
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
        ) { page ->
            OnboardingPageView(pages[page], pageIndex = page)
        }

        // Indicators
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.fillMaxWidth()
        ) {
            for (i in 0 until pageCount) {
                val selected = pagerState.currentPage == i
                Box(
                    modifier = Modifier
                        .padding(4.dp)
                        .size(if (selected) 12.dp else 8.dp)
                        .clip(RoundedCornerShape(6.dp))
                        .background(if (selected) Color(0xFF034503) else Color(0x804CAF50))
                )
            }
        }

        // Buttons: Skip / Next or Get Started
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 12.dp, bottom = 12.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Skip
            Text(
                text = "මඟහරින්න",
                modifier = Modifier
                    .padding(start = 8.dp)
                    .clickableNoRipple {
                        prefs.setFirstLaunch(false)
                        navController.navigate("district_selection") {
                            popUpTo("onboarding") { inclusive = true }
                        }
                    },
                color = Color(0xFF034503),
                fontSize = 16.sp
            )

            // Next / Get Started
            val isLast = pagerState.currentPage == pageCount - 1
            Button(
                onClick = {
                    if (!isLast) {
                        scope.launch { pagerState.animateScrollToPage(pagerState.currentPage + 1) }
                    } else {
                        prefs.setFirstLaunch(false)
                        navController.navigate("district_selection") {
                            popUpTo("onboarding") { inclusive = true }
                        }
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF034503)),
                shape = RoundedCornerShape(20),
                modifier = Modifier.padding(end = 8.dp)
            ) {
                Text(
                    text = if (isLast) "ආරම්භ කරන්න" else "ඊළඟ",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp)
                )
            }
        }
    }
}

@Composable
private fun OnboardingPageView(page: OnboardPage, pageIndex: Int ) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(2.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {
            Spacer(modifier = Modifier.height(0.dp))

            Image(
                painter = painterResource(id = page.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .size(270.dp)
                    .padding(bottom = 140.dp)
            )

            /*Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = page.title,
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold),
                textAlign = TextAlign.Center,
                color = Color(0xFF034503),
                modifier = Modifier.padding(top = 8.dp)
            )*/

            //Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = page.description,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier
                    .padding(horizontal = 2.dp)
                    .offset(y = page.textOffsetY.dp),
                fontSize = 24.sp,
                lineHeight = 35.sp,

                )


        if (pageIndex == 2) {
            Image(
                painter = painterResource(id = R.drawable.onboard_ss), // replace with your image
                contentDescription = "Extra Image",
                modifier = Modifier
                    .size(500.dp)
                    .offset(x = 0.dp, y = (-50).dp) // manually set location
            )
        }


            if (pageIndex == 3) {
                Image(
                    painter = painterResource(id = R.drawable.icons_speaker), // replace with your image
                    contentDescription = "Extra Image",
                    modifier = Modifier
                        .size(40.dp)
                        .offset(x = (-135).dp, y = (-38).dp) // manually set location
                )
            }



    }
       }
}

// ---------- small helpers & types ----------

private data class OnboardPage( val description: String, val imageRes: Int, val textOffsetY: Int = 0)

/** clickable without ripple for skip link */
@Composable
fun Modifier.clickableNoRipple(onClick: () -> Unit): Modifier =
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }
    ) { onClick() }

