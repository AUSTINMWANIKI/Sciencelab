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

// Data model for Slide Preparation Q&A
data class SlidePrepQuestion(
    val question: String,
    val answer: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SlidePreparationScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // Practical questions & answers
    val questions = listOf(
        SlidePrepQuestion(
            "1. What is the purpose of preparing temporary slides?",
            "To observe cells, tissues, or microorganisms quickly under the microscope without permanent mounting."
        ),
        SlidePrepQuestion(
            "2. What materials are required for preparing a temporary slide?",
            "Glass slide, cover slip, specimen (e.g., onion epidermis), water or stain, and forceps."
        ),
        SlidePrepQuestion(
            "3. Describe the procedure of preparing a temporary onion epidermis slide.",
            "Peel a thin onion epidermis layer, place it on a slide with water, cover it with a cover slip, and observe under the microscope."
        ),
        SlidePrepQuestion(
            "4. Why is a cover slip used in slide preparation?",
            "To flatten the specimen, protect the microscope lens, and prevent drying out."
        ),
        SlidePrepQuestion(
            "5. What is the role of stains such as iodine in slide preparation?",
            "Stains highlight cell structures such as the nucleus and cytoplasm, making them more visible under the microscope."
        ),
        SlidePrepQuestion(
            "6. What safety precautions should be observed?",
            "Handle glass slides carefully to avoid cuts, and use stains sparingly to prevent spills."
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Slide Preparation Practical", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
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
                    painter = painterResource(R.drawable.bar), // Replace with your asset
                    contentDescription = "Microscope Banner",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(0.dp)
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                )

                Spacer(modifier = Modifier.height(26.dp))

                Image(
                    painter = painterResource(R.drawable.preparation),
                    contentDescription = "handle",
                    modifier = Modifier.fillMaxSize()
                )




                // Intro section
                Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                    Text(
                        text = "Preparation of Temporary Slides",
                        fontWeight = FontWeight.Bold,
                        fontSize = 22.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Learn how to prepare temporary slides for observing cells and tissues under the microscope.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(20.dp))

                // Expandable question cards
                questions.forEach { item ->
                    SlidePreparationCard(item)
                    Spacer(modifier = Modifier.height(12.dp))
                }

                Spacer(modifier = Modifier.height(40.dp))
            }
        }
    )
}

@Composable
fun SlidePreparationCard(question: SlidePrepQuestion) {
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
fun SlidePreparationPreview() {
    SlidePreparationScreen(rememberNavController())
}
