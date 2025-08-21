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
import com.austin.sciencelab.navigation.ROUT_CELLBIO
import com.austin.sciencelab.ui.theme.lightGreen

// Data model for Q&A
data class CellBioQuestion(
    val question: String,
    val answer: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CellBiologyLabScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // List of questions & answers
    val questions = listOf(
        CellBioQuestion(
            "1. What is the basic structural and functional unit of life?",
            "The cell is the basic structural and functional unit of life."
        ),
        CellBioQuestion(
            "2. Name two differences between prokaryotic and eukaryotic cells.",
            "Prokaryotes lack a nucleus and membrane-bound organelles, while eukaryotes have both."
        ),
        CellBioQuestion(
            "3. What is the function of mitochondria in a cell?",
            "They produce energy (ATP) through cellular respiration and are often called the powerhouse of the cell."
        ),
        CellBioQuestion(
            "4. Which organelle is responsible for protein synthesis?",
            "Ribosomes are responsible for protein synthesis."
        ),
        CellBioQuestion(
            "5. What is the role of the plasma membrane in cells?",
            "It regulates the entry and exit of substances, providing protection and communication."
        ),
        CellBioQuestion(
            "6. Differentiate between rough ER and smooth ER.",
            "Rough ER has ribosomes for protein synthesis, while smooth ER synthesizes lipids and detoxifies drugs."
        ),
        CellBioQuestion(
            "7. What are lysosomes and what is their role in the cell?",
            "They are organelles containing digestive enzymes that break down waste and old cell parts."
        ),
        CellBioQuestion(
            "8. Which organelle contains chlorophyll and carries out photosynthesis?",
            "Chloroplasts contain chlorophyll and carry out photosynthesis in plant cells."
        ),
        CellBioQuestion(
            "9. What is the function of the Golgi apparatus?",
            "It modifies, sorts, and packages proteins and lipids for transport."
        ),
        CellBioQuestion(
            "10. Why is the nucleus considered the control center of the cell?",
            "It contains DNA, which regulates all cell activities and reproduction."
        )

    )


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Cell Biology Practical", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
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

                    Button(
                        onClick ={navController.navigate(ROUT_CELLBIO)},
                        colors = ButtonDefaults.buttonColors(Color.Black)
                    )
                    {
                        Text(text = "CellBio")
                    }
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
                    painter = painterResource(R.drawable.bar), // Replace with your banner
                    contentDescription = "Cell Biology Banner",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                )

                Spacer(modifier = Modifier.height(20.dp))

                // Intro section
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Text(
                        text = "Cell Biology Questions",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Explore the key concepts of cells, their organelles, and their functions through practical Q&A.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Expandable cards
                questions.forEach { item ->
                    CellBiologyCard(item)
                    Spacer(modifier = Modifier.height(12.dp))
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    )
}

@Composable
fun CellBiologyCard(question: CellBioQuestion) {
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
fun CellBiologyPreview() {
    CellBiologyLabScreen(rememberNavController())
}
