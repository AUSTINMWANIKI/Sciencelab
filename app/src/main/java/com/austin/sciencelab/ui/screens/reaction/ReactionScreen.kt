package com.austin.sciencelab.ui.screens.reactionrates

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
import com.austin.sciencelab.navigation.ROUT_QUANTITATIVE
import com.austin.sciencelab.ui.theme.lightGreen

data class RatesQuestion(
    val text: String,
    val options: List<String>,
    val answerIndex: Int
)

@Composable
fun ReactionScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    val questions = listOf(
        RatesQuestion(
            text = "Which factor increases the rate of reaction by lowering the activation energy?",
            options = listOf("Temperature", "Catalyst", "Pressure", "Concentration"),
            answerIndex = 1
        ),
        RatesQuestion(
            text = "If the concentration of a reactant is doubled, the rate doubles. What is the order of reaction with respect to that reactant?",
            options = listOf("Zero", "First", "Second", "Fractional"),
            answerIndex = 1
        ),
        RatesQuestion(
            text = "In the reaction between sodium thiosulfate and hydrochloric acid, the formation of a yellow precipitate indicates:",
            options = listOf("Sulfur is formed", "H₂ gas is released", "CO₂ is released", "The solution is neutral"),
            answerIndex = 0
        ),
        RatesQuestion(
            text = "Increasing temperature generally increases the rate of reaction because:",
            options = listOf(
                "It lowers activation energy",
                "It increases the kinetic energy of particles",
                "It increases concentration",
                "It changes the equilibrium"
            ),
            answerIndex = 1
        ),
        RatesQuestion(
            text = "Which gas is produced when magnesium reacts with hydrochloric acid?",
            options = listOf("CO₂", "O₂", "H₂", "Cl₂"),
            answerIndex = 2
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        Text(
            text = "Reaction Rates Practical",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Learn how different factors affect the speed of chemical reactions, "
                    + "including temperature, concentration, surface area, and catalysts."
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {navController.navigate(ROUT_QUANTITATIVE)}
        ) {
            Text(text = "Quantitative")
        }

        questions.forEachIndexed { index, question ->
            RatesQuestionCard(
                number = index + 1,
                question = question
            )
            Spacer(modifier = Modifier.height(12.dp))
        }
    }
}

@Composable
fun RatesQuestionCard(number: Int, question: RatesQuestion) {
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
                    text = if (isCorrect) "✅ Correct!" else "❌ Correct answer: ${question.options[question.answerIndex]}",
                    color = if (isCorrect) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.error
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ReactionScreenPreview() {
    ReactionScreen(rememberNavController())
}

