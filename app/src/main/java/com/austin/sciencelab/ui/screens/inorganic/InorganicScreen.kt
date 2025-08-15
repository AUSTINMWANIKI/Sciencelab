package com.austin.sciencelab.ui.screens.inorganic

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
import com.austin.sciencelab.navigation.ROUT_REACTION
import com.austin.sciencelab.ui.theme.lightGreen

data class InorganicQuestion(
    val text: String,
    val options: List<String>,
    val answerIndex: Int
)

@Composable
fun InorganicScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // Sample inorganic chemistry practical questions
    val questions = listOf(
        InorganicQuestion(
            text = "Which gas is produced when a carbonate reacts with dilute acid?",
            options = listOf("Oxygen", "Hydrogen", "Carbon dioxide", "Ammonia"),
            answerIndex = 2
        ),
        InorganicQuestion(
            text = "What is the colour of the precipitate formed when sodium hydroxide is added to copper(II) sulfate solution?",
            options = listOf("White", "Blue", "Green", "Brown"),
            answerIndex = 1
        ),
        InorganicQuestion(
            text = "A flame test produces a brick-red colour. Which cation is present?",
            options = listOf("Sodium", "Calcium", "Potassium", "Barium"),
            answerIndex = 1
        ),
        InorganicQuestion(
            text = "Which reagent is used to test for the presence of chloride ions?",
            options = listOf("Barium chloride", "Silver nitrate", "Lead(II) nitrate", "Ammonium hydroxide"),
            answerIndex = 1
        ),
        InorganicQuestion(
            text = "When hydrogen sulfide gas is passed through lead(II) acetate solution, the colour observed is:",
            options = listOf("Yellow", "Black", "Brown", "Green"),
            answerIndex = 1
        ),
        InorganicQuestion(
            text = "Which cation produces a white precipitate that dissolves in excess NaOH?",
            options = listOf("Al³⁺", "Cu²⁺", "Fe²⁺", "Fe³⁺"),
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
            text = "Inorganic Chemistry Practical Questions",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {navController.navigate(ROUT_REACTION)}) { }

        questions.forEachIndexed { index, question ->
            InorganicQuestionCard(
                number = index + 1,
                question = question
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun InorganicQuestionCard(number: Int, question: InorganicQuestion) {
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
fun InorganicScreenPreview() {
    InorganicScreen(rememberNavController())
}
