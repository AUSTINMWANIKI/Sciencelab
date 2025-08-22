package com.austin.sciencelab.ui.screens.biology

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
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
import com.austin.sciencelab.navigation.ROUT_CELLPHYSIOLOGY
import com.austin.sciencelab.navigation.ROUT_VIRTUALLABS1
import com.austin.sciencelab.ui.theme.lightGreen

// Data class for Plant Anatomy Q&A
data class PlantAnatomyQuestion(
    val question: String,
    val answer: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantAnatomyScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // Plant anatomy practical questions
    val questions = listOf(
        PlantAnatomyQuestion(
            "1. What are the main tissues in plants?",
            "The main plant tissues are dermal tissue, ground tissue, and vascular tissue (xylem and phloem)."
        ),
        PlantAnatomyQuestion(
            "2. How can you distinguish between monocot and dicot stems under a microscope?",
            "Monocot stems show scattered vascular bundles, while dicot stems have vascular bundles arranged in a ring."
        ),
        PlantAnatomyQuestion(
            "3. What is the function of xylem?",
            "Xylem transports water and dissolved minerals from roots to other parts of the plant."
        ),
        PlantAnatomyQuestion(
            "4. What is the function of phloem?",
            "Phloem transports food (mainly sucrose) produced during photosynthesis from leaves to other plant parts."
        ),
        PlantAnatomyQuestion(
            "5. Give an experiment to observe stomata.",
            "Peel the lower epidermis of a leaf (e.g., Rhoeo), mount it on a slide with water, and observe under a microscope."
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Plant Anatomy Sample Questions", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = lightGreen),
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_CELLPHYSIOLOGY) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
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
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.padding(12.dp)
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
                // Banner
                Image(
                    painter = painterResource(R.drawable.parts), // Replace with a plant image
                    contentDescription = "Plant Anatomy Banner",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Intro
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Text(
                        text = "Plant Anatomy Questions",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Learn about plant tissues, vascular systems, and microscopic anatomy through practical experiments.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Questions
                questions.forEach { item ->
                    PlantAnatomyCard(item)
                    Spacer(modifier = Modifier.height(12.dp))
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    )
}

@Composable
fun PlantAnatomyCard(question: PlantAnatomyQuestion) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 5.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = question.question,
                fontWeight = FontWeight.Medium,
                fontSize = 16.sp
            )

            if (expanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = question.answer,
                    fontSize = 14.sp,
                    color = Color.DarkGray
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PlantAnatomyPreview() {
    PlantAnatomyScreen(rememberNavController())
}
