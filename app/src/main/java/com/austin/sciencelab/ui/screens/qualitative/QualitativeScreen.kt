package com.austin.sciencelab.ui.screens.qualitative

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
import com.austin.sciencelab.ui.theme.lightGreen

data class Question(
    val text: String,
    val options: List<String>,
    val answerIndex: Int
)

@Composable
fun QualitativeScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // Chemistry Qualitative Analysis Practical Questions
    val questions = listOf(
        Question(
            text = "Which reagent is used to test for chloride ions in a solution?",
            options = listOf("Barium chloride", "Silver nitrate", "Ammonium hydroxide", "Lead(II) nitrate"),
            answerIndex = 1
        ),
        Question(
            text = "What observation confirms the presence of sulphate ions after adding barium chloride?",
            options = listOf("White precipitate", "Effervescence", "Brown precipitate", "No change"),
            answerIndex = 0
        ),
        Question(
            text = "Which gas is identified by turning limewater milky?",
            options = listOf("Oxygen", "Carbon dioxide", "Hydrogen", "Ammonia"),
            answerIndex = 1
        ),
        Question(
            text = "What colour flame is produced by sodium ions in a flame test?",
            options = listOf("Lilac", "Yellow", "Crimson red", "Blue-green"),
            answerIndex = 1
        ),
        Question(
            text = "Ammonia gas has a characteristic:",
            options = listOf("Sweet smell", "Sharp pungent smell", "Odourless nature", "Fruity smell"),
            answerIndex = 1
        ),
        Question(
            text = "Which reagent is used to test for carbonate ions?",
            options = listOf("Hydrochloric acid", "Sodium hydroxide", "Ammonium chloride", "Nitric acid"),
            answerIndex = 0
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Chemistry Qualitative Analysis Questions",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))

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
fun QualitativeScreenPreview() {
    QualitativeScreen(rememberNavController())
}
