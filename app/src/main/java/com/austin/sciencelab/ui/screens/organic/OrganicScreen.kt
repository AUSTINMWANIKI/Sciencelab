package com.austin.sciencelab.ui.screens.organic

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.austin.sciencelab.navigation.ROUT_INORGANIC
import com.austin.sciencelab.navigation.ROUT_ORGANIC
import com.austin.sciencelab.ui.theme.lightGreen

data class Question(
    val text: String,
    val options: List<String>,
    val answerIndex: Int
)

@Composable
fun OrganicScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // Organic Chemistry Analysis Questions
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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Organic Chemistry Analysis Questions",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {navController.navigate(ROUT_ORGANIC)}
        ) {
            Text(text = "Organic")
        }


        questions.forEachIndexed { index, question ->
            QuestionCard(
                number = index + 1,
                question = question
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun QuestionCard(number: Int, question: Question) {
    var selectedOption by remember { mutableStateOf<Int?>(null) }
    var showAnswer by remember { mutableStateOf(false) }

    Card(
        colors = CardDefaults.cardColors(containerColor = lightGreen),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "$number. ${question.text}",
                style = MaterialTheme.typography.titleMedium
            )

            Spacer(modifier = Modifier.height(8.dp))

            question.options.forEachIndexed { optionIndex, optionText ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable {
                            selectedOption = optionIndex
                            showAnswer = true
                        }
                        .padding(8.dp)
                ) {
                    RadioButton(
                        selected = selectedOption == optionIndex,
                        onClick = {
                            selectedOption = optionIndex
                            showAnswer = true
                        }
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(text = optionText)
                }
            }

            if (showAnswer) {
                val isCorrect = selectedOption == question.answerIndex
                Text(
                    text = if (isCorrect) "✅ Correct!" else "❌ Incorrect. Correct answer: ${question.options[question.answerIndex]}",
                    color = if (isCorrect) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun OrganicScreenPreview() {
    OrganicScreen(rememberNavController())
}
