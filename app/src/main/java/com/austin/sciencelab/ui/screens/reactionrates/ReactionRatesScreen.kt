package com.austin.sciencelab.ui.screens.chemistry

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.austin.sciencelab.R
import com.austin.sciencelab.ui.screens.physics.PracticalSection
import com.austin.sciencelab.ui.screens.physics.PreviewAnswers
import com.austin.sciencelab.ui.screens.physics.QuestionItem

@Composable
fun ReactionRatesPracticalsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val answers = remember { mutableStateListOf(*Array(20) { "" }) }
    var showPreview by remember { mutableStateOf(false) }

    val questions = listOf(
        "1. Define reaction rate in chemistry.",
        "2. State factors affecting the rate of a chemical reaction.",
        "3. Explain how concentration affects reaction rate.",
        "4. How does temperature influence reaction rate?",
        "5. Describe the effect of a catalyst on reaction rate.",
        "6. Write the chemical equation for the reaction between hydrochloric acid and sodium thiosulfate.",
        "7. Explain how the disappearance of reactants can be used to measure rate.",
        "8. What is the significance of collision theory in reaction rates?",
        "9. Describe a simple experiment to study the effect of concentration on reaction rate.",
        "10. Describe a simple experiment to study the effect of temperature on reaction rate.",
        "11. How is the half-life of a reaction determined?",
        "12. Define order of reaction and give examples.",
        "13. Explain how to plot a rate vs concentration graph.",
        "14. How can surface area of solids affect reaction rate?",
        "15. Mention the precautions when measuring reaction rates experimentally.",
        "16. How can reaction rate be measured using color change?",
        "17. Explain the effect of pressure on reactions involving gases.",
        "18. State two applications of reaction rate studies in industry.",
        "19. Describe how reaction rates are relevant in food preservation.",
        "20. Mention two sources of error in reaction rate experiments."
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF9FAFB))
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // Title
        Text(
            text = "Reaction Rates Chemistry Practical",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // PRACTICAL 1: Effect of Concentration
        PracticalSection(
            title = "Effect of Concentration on Reaction Rate",
            aim = "To investigate how varying the concentration of reactants affects the reaction rate.",
            theory = "Increasing concentration increases the number of reacting particles per unit volume, leading to more frequent collisions and a higher reaction rate.",
            apparatus = "• Conical flask\n• Sodium thiosulfate solution\n• Hydrochloric acid\n• Stopwatch\n• Measuring cylinders",
            procedure = "1. Measure a fixed volume of sodium thiosulfate into a flask.\n" +
                    "2. Add hydrochloric acid and start the stopwatch.\n" +
                    "3. Observe the time for the solution to turn cloudy.\n" +
                    "4. Repeat with different concentrations and record times.",
            diagramRes = R.drawable.reaction_rate_concentration // replace with drawable
        )

        Spacer(Modifier.height(24.dp))

        // PRACTICAL 2: Effect of Temperature
        PracticalSection(
            title = "Effect of Temperature on Reaction Rate",
            aim = "To study how temperature affects the rate of a chemical reaction.",
            theory = "Raising the temperature increases kinetic energy of molecules, causing more frequent and energetic collisions, increasing reaction rate.",
            apparatus = "• Conical flask\n• Sodium thiosulfate solution\n• Hydrochloric acid\n• Water bath\n• Stopwatch",
            procedure = "1. Prepare sodium thiosulfate solutions at different temperatures.\n" +
                    "2. Add hydrochloric acid and start the stopwatch.\n" +
                    "3. Record time taken for cloudiness to appear.\n" +
                    "4. Plot reaction rate vs temperature graph.",
            diagramRes = R.drawable.reaction_rate_temperature // replace with drawable
        )

        Spacer(Modifier.height(24.dp))

        // PRACTICAL 3: Effect of Catalyst
        PracticalSection(
            title = "Effect of Catalyst on Reaction Rate",
            aim = "To investigate the effect of a catalyst on the decomposition of hydrogen peroxide.",
            theory = "Catalysts provide an alternative pathway with lower activation energy, increasing reaction rate without being consumed.",
            apparatus = "• Hydrogen peroxide solution\n• Manganese(IV) oxide (catalyst)\n• Conical flask\n• Gas syringe\n• Stopwatch",
            procedure = "1. Add hydrogen peroxide to a flask.\n" +
                    "2. Add manganese(IV) oxide and start stopwatch.\n" +
                    "3. Measure volume of oxygen evolved over time.\n" +
                    "4. Compare with reaction without catalyst.",
            diagramRes = R.drawable.reaction_rate_catalyst // replace with drawable
        )

        Spacer(Modifier.height(24.dp))

        // Questions Section
        Text("Extended Practical Questions", fontWeight = FontWeight.Bold, fontSize = 18.sp)
        Spacer(Modifier.height(12.dp))

        questions.forEachIndexed { index, q ->
            QuestionItem(
                question = q,
                answer = answers[index],
                onAnswerChange = { answers[index] = it }
            )
        }

        Spacer(Modifier.height(24.dp))

        // Preview Button
        Button(
            onClick = { showPreview = !showPreview },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(if (showPreview) "Hide Preview" else "Show Preview")
        }

        if (showPreview) {
            PreviewAnswers(questions = questions, answers = answers)
        }
    }
}
