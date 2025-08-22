package com.austin.sciencelab.ui.screens.physics

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
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
import com.austin.sciencelab.navigation.ROUT_OPTICS
import com.austin.sciencelab.navigation.ROUT_THERMODYNAMICS
import com.austin.sciencelab.navigation.ROUT_VIRTUALLABS2
import com.austin.sciencelab.ui.theme.lightGreen

data class WavesQuestion(
    val text: String,
    val options: List<String>,
    val answerIndex: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WavesPracticalScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // Sample Waves Practical Questions
    val questions = listOf(
        WavesQuestion(
            text = "What is the formula for wave speed?",
            options = listOf("v = fλ", "v = λ/f", "v = f/λ", "v = λ + f"),
            answerIndex = 0
        ),
        WavesQuestion(
            text = "Which type of wave requires a medium?",
            options = listOf("Light wave", "Sound wave", "Radio wave", "X-ray"),
            answerIndex = 1
        ),
        WavesQuestion(
            text = "What is the unit of frequency?",
            options = listOf("Hz", "m/s", "N", "J"),
            answerIndex = 0
        ),
        WavesQuestion(
            text = "In a ripple tank experiment, what is used to generate waves?",
            options = listOf("Vibrator", "Spring balance", "Thermometer", "Pendulum"),
            answerIndex = 0
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Waves Practical", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = lightGreen),
                navigationIcon = {
                    IconButton(onClick = {navController.navigate(ROUT_THERMODYNAMICS)}) {
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
                    painter = painterResource(R.drawable.img_3),
                    contentDescription = "Waves Banner",
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
                        text = "Perform Waves Experiments",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Answer the following questions based on waves practical experiments.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Questions Section
                questions.forEachIndexed { index, question ->
                    WavesQuestionCard(number = index + 1, question = question)
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    )
}

@Composable
fun WavesQuestionCard(number: Int, question: WavesQuestion) {
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var showAnswer by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "$number. ${question.text}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            question.options.forEachIndexed { optionIndex, optionText ->
                val isSelected = selectedOption == optionIndex
                val isCorrect = optionIndex == question.answerIndex
                val backgroundColor = when {
                    showAnswer && isCorrect -> Color(0xFF4CAF50)
                    showAnswer && isSelected && !isCorrect -> Color(0xFFF44336)
                    else -> Color(0xFFF0F0F0)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedOption = optionIndex
                            showAnswer = true
                        }
                        .padding(8.dp)
                        .background(backgroundColor, RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = isSelected,
                        onClick = {
                            selectedOption = optionIndex
                            showAnswer = true
                        },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.White,
                            unselectedColor = Color.Gray
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = optionText,
                        color = if (showAnswer && (isSelected || isCorrect)) Color.White else Color.Black
                    )
                }
            }

            if (showAnswer) {
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = if (selectedOption == question.answerIndex) "✅ Correct!" else "❌ Incorrect. Correct answer: ${question.options[question.answerIndex]}",
                    color = if (selectedOption == question.answerIndex) Color(0xFF4CAF50) else Color(0xFFF44336),
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun WavesPracticalScreenPreview() {
    WavesPracticalScreen(rememberNavController())
}

