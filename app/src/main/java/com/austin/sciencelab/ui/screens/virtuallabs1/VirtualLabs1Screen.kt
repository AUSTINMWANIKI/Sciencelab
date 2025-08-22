package com.austin.sciencelab.ui.screens.virtuallabs1

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.austin.sciencelab.R
import com.austin.sciencelab.navigation.*
import com.austin.sciencelab.ui.theme.lightGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VirtualLabs1Screen(navController: NavController) {

    val verticalScroll = rememberScrollState()
    val horizontalScroll = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Virtual Labs-Chemistry", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = lightGreen,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                    ),


                navigationIcon = {
                    IconButton(onClick = {navController.navigate(ROUT_SCIENCE2)}) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "menu"
                        )
                    }
                },



            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = lightGreen,
                content = {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "© ScienceLab 2025",
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(16.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(verticalScroll)
                    .background(MaterialTheme.colorScheme.background)
            ) {

                // Hero Image / Banner
                Image(
                    painter = painterResource(R.drawable.apparatus),
                    contentDescription = "Science Lab Banner",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Intro Text Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Explore Virtual Labs",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Engage with interactive experiments in chemistry and physics. Tap on a lab below to begin.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Horizontal scrollable lab cards
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(horizontalScroll)
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    val labs = listOf(
                        LabData("Quantitative analysis", R.drawable.land, ROUT_QUANTITATIVE),
                        LabData("Moles", R.drawable.land, ROUT_MOLES),
                        LabData("Qualitative analysis", R.drawable.land, ROUT_QUALITATIVE),
                        LabData("Organic analysis", R.drawable.land, ROUT_ORGANIC),
                        LabData("Compounds", R.drawable.land, ROUT_COMPOUNDS),
                        LabData("Inorganic analysis", R.drawable.land, ROUT_INORGANIC),
                        LabData("Cation-Anion test", R.drawable.land, ROUT_CATION),
                        LabData("Solubility", R.drawable.land, ROUT_SOLUBILITY),
                        LabData("Energychanges", R.drawable.land, ROUT_ENERGYCHANGES),
                        LabData("Energy changes", R.drawable.land, ROUT_ENERGY),
                        LabData("Reaction rates", R.drawable.land, ROUT_REACTION),
                        LabData("Reactionrates", R.drawable.land, ROUT_REACTIONRATES),
                        LabData("VirtualLabs2", R.drawable.land, ROUT_VIRTUALLABS2),
                    )

                    labs.forEach { lab ->
                        LabCardHorizontal(lab) {
                            navController.navigate(lab.route)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Extra Content Section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Tips for Using Virtual Labs",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "• Ensure stable internet connection.\n" +
                                "• Read the instructions before starting an experiment.\n" +
                                "• Take notes of your observations.\n" +
                                "• Experiment safely and responsibly.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    )
}

data class LabData(val title: String, val imageRes: Int, val route: String)

@Composable
fun LabCardHorizontal(lab: LabData, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = lightGreen),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(R.drawable.apparatus),
                contentDescription = lab.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(color = androidx.compose.ui.graphics.Color(0x80000000))
            )

            Text(
                text = lab.title,
                color = androidx.compose.ui.graphics.Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center),
                maxLines = 2
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun VirtualLabs1ScreenPreview() {
    VirtualLabs1Screen(rememberNavController())
}
