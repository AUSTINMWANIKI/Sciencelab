package com.austin.sciencelab.ui.screens.physics

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

data class PhysicsQuestion(
    val text: String,
    val options: List<String>,
    val answerIndex: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MechanicsPracticalScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // Sample Mechanics Practical Questions
    val questions = listOf(
        PhysicsQuestion(
            text = "A block slides down a frictionless incline. Which force acts along the incline?",
            options = listOf("Normal force", "Gravitational component", "Friction", "Tension"),
            answerIndex = 1
        ),
        PhysicsQuestion(
            text = "Which formula calculates acceleration in uniform motion?",
            options = listOf("a = v/t", "a = F/m", "a = s/t", "a = m/F"),
            answerIndex = 1
        ),
        PhysicsQuestion(
            text = "In a free-fall experiment, what is the approximate acceleration due to gravity?",
            options = listOf("9.8 m/s²", "10 m/s", "9.8 m/s", "10 m/s²"),
            answerIndex = 0
        ),
        PhysicsQuestion(
            text = "Which instrument is used to measure the time of a falling object?",
            options = listOf("Stopwatch", "Meter rule", "Spring balance", "Voltmeter"),
            answerIndex = 0
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mechanics Practical", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
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
                    contentDescription = "Mechanics Banner",
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
                        text = "Perform Mechanics Experiments",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Answer the following questions based on mechanics practical experiments.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Questions Section
                questions.forEachIndexed { index, question ->
                    MechanicsQuestionCard(number = index + 1, question = question)
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    )
}

@Composable
fun MechanicsQuestionCard(number: Int, question: PhysicsQuestion) {
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
fun MechanicsPracticalScreenPreview() {
    MechanicsPracticalScreen(rememberNavController())
}
