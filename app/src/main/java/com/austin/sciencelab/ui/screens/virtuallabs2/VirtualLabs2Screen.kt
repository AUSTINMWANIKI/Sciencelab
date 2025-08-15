package com.austin.sciencelab.ui.screens.virtuallabs2

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.austin.sciencelab.navigation.ROUT_INORGANIC
import com.austin.sciencelab.ui.theme.lightGreen

@Composable
fun VirtualLabs2Screen(navController: NavController){

    Column (
        modifier = Modifier.fillMaxSize().background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Mechanics",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Thermodynamics",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp)


            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Waves",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp)


            )

        }

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Optics",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp)


            )
        }

        Spacer(modifier = Modifier.height(20.dp))


        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Electricity and Magnetism",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp)


            )

        }

        Button(
            onClick = {navController.navigate(ROUT_INORGANIC)}
        )
        {
            Text(text = "Mechanics")

        }









    }
}







@Preview
@Composable
fun VirtualLabs2ScreenPreview(){
    VirtualLabs2Screen(rememberNavController())
}