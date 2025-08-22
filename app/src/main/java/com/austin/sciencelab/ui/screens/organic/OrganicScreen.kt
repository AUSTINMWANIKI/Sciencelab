package com.austin.sciencelab.ui.screens.organic

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import com.austin.sciencelab.navigation.*
import com.austin.sciencelab.ui.theme.lightGreen

data class Question(
    val text: String,
    val options: List<String>,
    val answerIndex: Int
)

data class LabTopic(val title: String, val imageRes: Int, val route: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrganicScreen(navController: NavController) {

    val scrollState = rememberScrollState()
    val horizontalScroll = rememberScrollState()

    val quickAccessTopics = listOf(
        LabTopic("Quantitative", R.drawable.land, ROUT_QUANTITATIVE),
        LabTopic("Qualitative", R.drawable.land, ROUT_QUALITATIVE),
        LabTopic("Organic", R.drawable.land, ROUT_ORGANIC),
        LabTopic("Inorganic", R.drawable.land, ROUT_INORGANIC),
        LabTopic("Energy", R.drawable.land, ROUT_ENERGY),
        LabTopic("Reaction", R.drawable.land, ROUT_REACTION),
        LabTopic("VirtualLabs2", R.drawable.land, ROUT_VIRTUALLABS2),
    )

    val questions = listOf(
        Question(
            text = "Which reagent is used to test for unsaturation in organic compounds?",
            options = listOf("Tollens' reagent", "Bromine water", "Fehling's solution", "2,4-DNP"),
            answerIndex = 1
        ),
        Question(
            text = "A silver mirror is formed when a compound reacts with Tollens' reagent. The compound is likely:",
            options = listOf("A ketone", "An aldehyde", "An alcohol", "An ester"),
            answerIndex = 1
        ),
        Question(
            text = "What is the observation when phenol reacts with neutral FeCl₃ solution?",
            options = listOf("White precipitate", "Violet colour", "Effervescence", "Brown precipitate"),
            answerIndex = 1
        ),
        Question(
            text = "Which reagent is used to detect the presence of carbonyl compounds?",
            options = listOf("2,4-DNP", "Benedict's solution", "Bromine water", "Conc. H₂SO₄"),
            answerIndex = 0
        ),
        Question(
            text = "Effervescence is observed when a carboxylic acid reacts with:",
            options = listOf("Sodium carbonate", "Phenol", "Ethanol", "Fehling's solution"),
            answerIndex = 0
        ),
        Question(
            text = "Which test is used to distinguish between primary, secondary, and tertiary alcohols?",
            options = listOf("Iodoform test", "Lucas test", "Fehling's test", "Tollens' test"),
            answerIndex = 1
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Organic Analysis", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = { navController.navigate(ROUT_INORGANIC) }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
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
                    .verticalScroll(scrollState)
                    .padding(paddingValues)
                    .background(Color(0xFFF5F5F5))
            ) {
                // Banner Image
                Image(
                    painter = painterResource(R.drawable.img_5),
                    contentDescription = "Chemistry Banner",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Horizontal Scrollable Quick-Access Topics
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(horizontalScroll)
                        .padding(start = 16.dp)
                ) {
                    quickAccessTopics.forEach { topic ->
                        Card(
                            modifier = Modifier
                                .size(width = 140.dp, height = 120.dp)
                                .padding(end = 12.dp)
                                .clickable { navController.navigate(topic.route) },
                            shape = RoundedCornerShape(12.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(R.drawable.img_5),
                                    contentDescription = topic.title,
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.fillMaxSize()
                                )
                                Box(
                                    modifier = Modifier
                                        .fillMaxSize()
                                        .background(Color(0x80000000))
                                )
                                Text(
                                    text = topic.title,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                Text(
                    text = "Interactive Questions:",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold,
                    modifier = Modifier.padding(horizontal = 16.dp)
                )

                Spacer(modifier = Modifier.height(16.dp))

                questions.forEachIndexed { index, question ->
                    QuestionCardModern(number = index + 1, question = question)
                    Spacer(modifier = Modifier.height(16.dp))
                }

                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    )
}

@Composable
fun QuestionCardModern(number: Int, question: Question) {
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
fun OrganicScreenPreview() {
    OrganicScreen(rememberNavController())
}
