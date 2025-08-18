package com.austin.sciencelab.ui.screens.energychanges

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
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
import com.austin.sciencelab.navigation.*
import com.austin.sciencelab.ui.theme.lightGreen

data class LabTopic(val title: String, val imageRes: Int, val route: String)

data class Question(
    val text: String,
    val options: List<String>,
    val answerIndex: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnergyChangesScreen(navController: NavController) {
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
            "Which reaction is exothermic?",
            listOf("HCl + NaOH", "NH₄Cl + H₂O"),
            answerIndex = 0
        ),
        Question(
            "Why is a polystyrene cup used in this experiment?",
            listOf("It’s cheap", "It insulates heat", "It looks good", "It reacts with chemicals"),
            answerIndex = 1
        ),
        Question(
            "Which observation indicates an endothermic reaction?",
            listOf("Temperature rises", "Temperature falls"),
            answerIndex = 1
        ),
        Question(
            "How can energy loss to surroundings be minimized?",
            listOf("Use a lid", "Stir faster", "Add more reactants", "Use glass beaker"),
            answerIndex = 0
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Energy Changes Practical", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back */ }) {
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
                        "© ScienceLab 2025",
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
                    .background(Color(0xFFF5FCF8))
            ) {
                // Banner
                Image(
                    painter = painterResource(R.drawable.equipment),
                    contentDescription = "Energy Changes Banner",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Horizontal Quick-Access
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(horizontalScroll)
                        .padding(start = 16.dp)
                ) {
                    quickAccessTopics.forEach { topic ->
                        Card(
                            modifier = Modifier
                                .size(140.dp, 120.dp)
                                .padding(end = 12.dp)
                                .clickable { navController.navigate(topic.route) },
                            shape = RoundedCornerShape(12.dp),
                            elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                        ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                Image(
                                    painter = painterResource(R.drawable.equipment),
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
                                    topic.title,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.align(Alignment.Center)
                                )
                            }
                        }
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Questions
                Text(
                    "Interactive Questions:",
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
                "$number. ${question.text}",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp
            )

            Spacer(modifier = Modifier.height(12.dp))

            question.options.forEachIndexed { idx, option ->
                val isSelected = selectedOption == idx
                val isCorrect = idx == question.answerIndex
                val bgColor = when {
                    showAnswer && isCorrect -> Color(0xFF4CAF50)
                    showAnswer && isSelected && !isCorrect -> Color(0xFFF44336)
                    else -> Color(0xFFF0F0F0)
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedOption = idx
                            showAnswer = true
                        }
                        .background(bgColor, RoundedCornerShape(8.dp))
                        .padding(12.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = isSelected,
                        onClick = {
                            selectedOption = idx
                            showAnswer = true
                        },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.White,
                            unselectedColor = Color.Gray
                        )
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        option,
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
fun EnergyChangesScreenPreview() {
    EnergyChangesScreen(rememberNavController())
}
