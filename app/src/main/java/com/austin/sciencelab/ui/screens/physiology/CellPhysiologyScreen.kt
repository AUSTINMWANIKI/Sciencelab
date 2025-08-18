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

// Data class for practical questions
data class CellPhysiologyQuestion(
    val question: String,
    val answer: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CellPhysiologyScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // List of questions for the practical
    val questions = listOf(
        CellPhysiologyQuestion(
            "1. What is osmosis?",
            "Osmosis is the movement of water molecules from a region of high water potential to a region of low water potential through a semi-permeable membrane."
        ),
        CellPhysiologyQuestion(
            "2. What is plasmolysis?",
            "Plasmolysis is the process in which plant cells lose water in a hypertonic solution, causing the cell membrane to shrink away from the cell wall."
        ),
        CellPhysiologyQuestion(
            "3. How can you demonstrate diffusion?",
            "Diffusion can be demonstrated by placing potassium permanganate crystals in water and observing the spread of purple color without stirring."
        ),
        CellPhysiologyQuestion(
            "4. What is active transport?",
            "Active transport is the movement of molecules across a cell membrane from a region of lower concentration to a region of higher concentration using energy (ATP)."
        ),
        CellPhysiologyQuestion(
            "5. Give an experiment to show osmosis in living cells.",
            "Place a peeled potato in concentrated sugar solution and another in distilled water. The one in sugar solution shrinks while the one in water swells."
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cell Physiology Practical", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
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
                // Banner image
                Image(
                    painter = painterResource(R.drawable.land), // replace with a biology-related banner
                    contentDescription = "Cell Physiology Banner",
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
                        text = "Cell Physiology Experiments",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Explore questions and experiments related to osmosis, diffusion, plasmolysis, and active transport.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Questions list
                questions.forEach { item ->
                    CellPhysiologyCard(item)
                    Spacer(modifier = Modifier.height(12.dp))
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    )
}

@Composable
fun CellPhysiologyCard(question: CellPhysiologyQuestion) {
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
fun CellPhysiologyPreview() {
    CellPhysiologyScreen(rememberNavController())
}
