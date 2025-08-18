package com.austin.sciencelab.ui.screens.microbiology

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.austin.sciencelab.R
import com.austin.sciencelab.ui.theme.lightGreen

// Data class for Microbiology Practicals
data class MicrobiologyPractical(
    val title: String,
    val description: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MicrobiologyPracticalsScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // List of microbiology practicals
    val practicals = listOf(
        MicrobiologyPractical("Microscope Handling", "Learn how to use a compound microscope and prepare smears."),
        MicrobiologyPractical("Aseptic Technique", "Understand how to transfer microorganisms without contamination."),
        MicrobiologyPractical("Bacterial Staining", "Perform simple, differential, and Gram staining of bacterial samples."),
        MicrobiologyPractical("Culture Methods", "Explore streak plate, pour plate, and spread plate methods."),
        MicrobiologyPractical("Antibiotic Sensitivity Test", "Investigate the effects of antibiotics using the disc diffusion method."),
        MicrobiologyPractical("Bacterial Growth Curve", "Measure bacterial growth over time using spectrophotometry."),
        MicrobiologyPractical("Fermentation Experiments", "Study microbial fermentation and gas production."),
        MicrobiologyPractical("Water Analysis", "Test for coliform bacteria in water samples."),
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Microbiology Practicals", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = lightGreen)
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
                        color = Color.White,
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
                    .verticalScroll(scrollState)
                    .background(MaterialTheme.colorScheme.background)
            ) {
                // Banner Image
                Image(
                    painter = painterResource(R.drawable.land),
                    contentDescription = "Microbiology Banner",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Intro Text
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        text = "Explore Microbiology Practicals",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Select a practical below to view details and perform virtual experiments.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Practicals List
                practicals.forEachIndexed { index, practical ->
                    MicrobiologyPracticalCard(number = index + 1, practical = practical)
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    )
}

@Composable
fun MicrobiologyPracticalCard(number: Int, practical: MicrobiologyPractical) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable { expanded = !expanded }
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "$number. ${practical.title}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = practical.description,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MicrobiologyPracticalsScreenPreview() {
    MicrobiologyPracticalsScreen(rememberNavController())
}
