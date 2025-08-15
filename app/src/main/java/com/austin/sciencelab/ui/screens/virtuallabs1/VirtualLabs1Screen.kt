package com.austin.sciencelab.ui.screens.virtuallabs1

import androidx.compose.foundation.Image
import androidx.compose.material3.TopAppBar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
import com.austin.sciencelab.navigation.ROUT_INORGANIC
import com.austin.sciencelab.navigation.ROUT_QUANTITATIVE
import com.austin.sciencelab.navigation.ROUT_VIRTUALLABS2
import com.austin.sciencelab.ui.theme.lightGreen

@Composable
fun VirtualLabs1Screen(navController: NavController){

    Column (
        modifier = Modifier.fillMaxSize().background(color = Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Image(painter = painterResource(R.drawable.img),
              contentDescription = "equipment",
              modifier = Modifier.height(240.dp).width(340.dp),

            )


        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Quantitative analysis",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp, top = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,

            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Qualitative analysis",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp, top = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )



        }

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Organic analysis",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp, top = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Inorganic analysis",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp, top = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,


            )
        }

        Spacer(modifier = Modifier.height(20.dp))


        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Energy changes",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp, top = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,


            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        Card (
            modifier = Modifier.height(70.dp).width(370.dp),
            colors = CardDefaults.cardColors(lightGreen)
        ){
            Text(
                text = "Reaction rates",
                color = Color.White,
                modifier = Modifier.padding(start = 130.dp, top = 20.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
            )
        }
        Button(onClick = {navController.navigate(ROUT_QUANTITATIVE)}
        ) {
            Text(text = "Quantitative")
        }





    }
}






@Preview
@Composable
fun VirtualLabs1ScreenPreview(){
    VirtualLabs1Screen(rememberNavController())
}