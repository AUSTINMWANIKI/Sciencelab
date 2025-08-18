package com.austin.sciencelab.ui.screens.biology

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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

// Data class for Cell Biology Practicals
data class CellBiologyPractical(
    val title: String,
    val description: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CellBiologyPracticalsScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // List of Cell Biology practicals
    val practicals = listOf(
        CellBiologyPractical("Observation of Plant Cells", "Use onion epidermis cells to observe cell walls and nuclei under a microscope."),
        CellBiologyPractical("Observation of Animal Cells", "Prepare cheek cell smears to study cell membranes and nuclei."),
        CellBiologyPractical("Staining Techniques", "Apply stains such as iodine or methylene blue to enhance visibility of organelles."),
        CellBiologyPractical("Osmosis in Plant Cells", "Investigate plasmolysis in onion cells placed in salt solution."),
        CellBiologyPractical("Mitosis Observation", "Study stages of mitosis using root tip squash technique."),
        CellBiologyPractical("Chloroplast Distribution", "Observe chloroplast arrangement in Elodea leaves under the microscope."),
        CellBiologyPractical("Cell Size Estimation", "Estimate cell size using an eyepiece graticule and stage micrometer."),
        CellBiologyPractical("Diffusion in Cells", "Demonstrate diffusion using dialysis tubing as a model cell membrane.")
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cell Biology Practicals", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
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
                    contentDescription = "Cell Biology Banner",
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
                        text = "Explore Cell Biology Practicals",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Select a practical to learn procedures and observations in cell biology.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Practicals List
                practicals.forEachIndexed { index, practical ->
                    CellBiologyPracticalCard(number = index + 1, practical = practical)
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    )
}

@Composable
fun CellBiologyPracticalCard(number: Int, practical: CellBiologyPractical) {
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
fun CellBiologyPracticalsScreenPreview() {
    CellBiologyPracticalsScreen(rememberNavController())
}
