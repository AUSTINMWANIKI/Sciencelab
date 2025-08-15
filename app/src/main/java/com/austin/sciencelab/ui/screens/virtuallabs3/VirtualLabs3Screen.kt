package com.austin.sciencelab.ui.screens.virtuallabs3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import com.austin.sciencelab.ui.theme.lightGreen

@Composable
fun VirtualLabs3Screen(navController: NavController){
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
                text = "Microscopy and cell studies",
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
                text = "Physiology experiments",
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
                text = "Support and movement",
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
                text = "Genetics and evolution",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp)


            )
        }












    }

}




@Preview
@Composable
fun VirtualLabs3ScreenPreview(){
    VirtualLabs3Screen(rememberNavController())
}