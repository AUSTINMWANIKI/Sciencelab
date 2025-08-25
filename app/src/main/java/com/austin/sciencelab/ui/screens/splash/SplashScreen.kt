package com.austin.sciencelab.ui.screens.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.*
import com.austin.sciencelab.R
import com.austin.sciencelab.navigation.ROUT_REGISTER
import com.austin.sciencelab.ui.theme.lightGreen
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {

    // Navigate after delay
    LaunchedEffect(Unit) {
        delay(2500)
        navController.navigate(ROUT_REGISTER) {
            popUpTo(0) // clears splash from backstack
        }
    }

    Column(

        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly // space out content across full screen

    ) {
        // Top: App Title
        Text(
            text = "⚛ ScienceLab",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = lightGreen,
            textAlign = TextAlign.Center
        )

        // Middle: Lottie Animation
        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.boyreadscience)
        )
        val progress by animateLottieCompositionAsState(composition, iterations = LottieConstants.IterateForever)

        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.size(250.dp)
        )

        // Tagline
        Text(
            text = "Curiosity is the compass,\nKnowledge is the journey",
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Center,
            color = lightGreen,
            modifier = Modifier.padding(horizontal = 24.dp)
        )

        // Extra inspirational note
        Text(
            text = "🔬 Explore • Discover • Learn",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = lightGreen
        )

        // Bottom: Progress indicator
        CircularProgressIndicator(
            color = lightGreen,
            strokeWidth = 4.dp,
            modifier = Modifier.size(48.dp)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun SplashScreenPreview() {
    SplashScreen(rememberNavController())
}
