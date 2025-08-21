package com.austin.sciencelab.ui.screens.science1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
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
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.austin.sciencelab.R
import com.austin.sciencelab.navigation.ROUT_ABOUT
import com.austin.sciencelab.navigation.ROUT_SCIENCE2
import com.austin.sciencelab.ui.theme.lightGreen

@Composable
fun Science1Screen(navController: NavController){
    Column (
        modifier = Modifier.fillMaxSize().background(color = Color.White).paint(painter = painterResource(R.drawable.scope), contentScale = ContentScale.FillBounds),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {


        Image(
            painter = painterResource(R.drawable.discrete),
            contentDescription = "limit",
            modifier= Modifier.size(300.dp).clip(shape = CircleShape),
            contentScale = ContentScale.Crop,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Divider()

        Text(
            text = "Physical sciences",
            fontSize = 40.sp,
            color = lightGreen,
            fontFamily = FontFamily.Cursive,
            fontWeight = FontWeight.Bold,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "Basic introduction",
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
            color = lightGreen,
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "This is an introduction to a series of slides that make students interact with constituents of matter, energy, compounds",
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(25.dp))

        Text(
            text = "Learners interact with Physics and Chemistry questions as well as notes.",
            fontSize = 15.sp,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(90.dp))

        Button(
            onClick = {
                navController.navigate(ROUT_SCIENCE2)
            },
            colors = ButtonDefaults.buttonColors(lightGreen),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.fillMaxWidth().padding(start = 20.dp, end = 20.dp),
        )

        {
            Text(text = "Science2")
        }
    }

}




@Preview
@Composable
fun Science1ScreenPreview(){
    Science1Screen(rememberNavController())
}