package com.austin.sciencelab.ui.screens.quantitative

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
import com.austin.sciencelab.ui.theme.lightGreen

data class Question(
    val text: String,
    val options: List<String>,
    val answerIndex: Int
)

@Composable
fun QuantitativeScreen(navController: NavController) {
    val scrollState = rememberScrollState()

    // Chemistry Quantitative Analysis Practical Questions
    val questions = listOf(
        Question(
            text = "In an acid-base titration, which indicator is commonly used when titrating a strong acid with a strong base?",
            options = listOf("Phenolphthalein", "Methyl orange", "Bromothymol blue", "Litmus"),
            answerIndex = 0
        ),
        Question(
            text = "What is the molarity of a solution prepared by dissolving 5.00 g of NaOH in 250 mL of solution? (NaOH Molar mass = 40 g/mol)",
            options = listOf("0.25 M", "0.50 M", "1.00 M", "2.00 M"),
            answerIndex = 1
        ),
        Question(
            text = "During titration, the volume of acid required is 25.00 cm³. If the concentration of the acid is 0.10 M, how many moles of acid were used?",
            options = listOf("0.0025 mol", "0.025 mol", "0.00025 mol", "0.250 mol"),
            answerIndex = 0
        ),
        Question(
            text = "Which apparatus is used to accurately measure the volume of a solution in a titration?",
            options = listOf("Measuring cylinder", "Pipette", "Conical flask", "Beaker"),
            answerIndex = 1
        ),
        Question(
            text = "In gravimetric analysis, the mass of the precipitate is used to determine:",
            options = listOf("Volume of gas", "Concentration of ions", "pH of solution", "Boiling point"),
            answerIndex = 1
        ),
        Question(
            text = "Which safety precaution is most important during titration?",
            options = listOf("Keep burette vertical", "Wear safety goggles", "Add acid to water", "Use distilled water"),
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
            text = "Chemistry Quantitative Analysis Questions",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {navController.navigate(ROUT_INORGANIC)}
        ) {
            Text(text = "Inorganic")
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
fun QuantitativeScreenPreview() {
    QuantitativeScreen(rememberNavController())
}
