package com.austin.sciencelab.ui.screens.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.austin.sciencelab.R
import com.austin.sciencelab.navigation.ROUT_ABOUT
import com.austin.sciencelab.ui.theme.lightGreen


@Composable
fun AboutScreen(navController: NavController){
    Column (
        modifier = Modifier.background(color = Color.White).height(1000.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Spacer(modifier = Modifier.height(90.dp))

        Image(
            painter = painterResource(R.drawable.tube),
            contentDescription = "marketable",
            modifier = Modifier.size(300.dp),
            alignment = Alignment.Center,
        )

        Text(
            text = "About Us",
            color = lightGreen,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
        )
        Spacer(modifier = Modifier.height(30.dp))

        Text(
            text = "Sciencelab is a mobile application with questions both on theory and labwork that students get to do digitally during holidays across areas in Biology, Chemistry and Physics ",
            textAlign = TextAlign.Center,
            fontSize = 20.sp,
            color = lightGreen,

            )
        Spacer(modifier = Modifier.height(60.dp))

        Button(
            onClick = {
                navController.navigate(ROUT_ABOUT)
            },
            colors = ButtonDefaults.buttonColors(lightGreen),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
        )

        {
            Text(text = "Next slide")
        }






    }


}






@Preview
@Composable
fun AboutScreenPreview(){
    AboutScreen(rememberNavController())
}