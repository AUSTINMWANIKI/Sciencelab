package com.austin.sciencelab.ui.screens.splash

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.austin.sciencelab.R
import com.austin.sciencelab.navigation.ROUT_REGISTER
import com.austin.sciencelab.ui.theme.lightGreen
import kotlinx.coroutines.delay


@Composable
fun SplashScreen(navController: NavController){

    // Runs only once when the Composable enters the composition
    LaunchedEffect(Unit) {
        delay(2000)
        navController.navigate(ROUT_REGISTER)
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        // Lottie Animation
        val composition by rememberLottieComposition(
            LottieCompositionSpec.RawRes(R.raw.boyreadscience)
        )
        val progress by animateLottieCompositionAsState(composition)

        LottieAnimation(
            composition,
            progress,
            modifier = Modifier.size(300.dp)
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Curiosity is the compass, knowledge is the journey",
            fontSize = 18.sp,
            color = lightGreen,
        )

        Spacer(modifier = Modifier.height(10.dp))



        Spacer(modifier = Modifier.height(10.dp))

        CircularProgressIndicator(
            color = lightGreen,
        )
    }
}






@Preview
@Composable
fun SplashScreenPreview(){
    SplashScreen(rememberNavController())
}