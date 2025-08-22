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
import androidx.navigation.NavHostController
import com.austin.sciencelab.R
import androidx.compose.ui.text.font.FontWeight
import com.austin.sciencelab.ui.screens.physics.PracticalSection
import com.austin.sciencelab.ui.screens.physics.PreviewAnswers
import com.austin.sciencelab.ui.screens.physics.QuestionItem

@Composable
fun EnergyChangesPracticalsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    // Store answers for questions
    val answers = remember { mutableStateListOf(*Array(25) { "" }) }
    var showPreview by remember { mutableStateOf(false) }

    // Chemistry – Energy Changes Practical Questions
    val questions = listOf(
        "1. Define exothermic and endothermic reactions with examples.",
        "2. State the law of conservation of energy in chemical reactions.",
        "3. Write the general expression for enthalpy change.",
        "4. Give an example of an exothermic neutralization reaction.",
        "5. Explain how bond breaking and bond formation relate to energy change.",
        "6. Define enthalpy of combustion.",
        "7. List apparatus required for calorimetry experiment.",
        "8. Write the principle of a simple calorimeter.",
        "9. State two sources of error in calorimetry.",
        "10. Draw and label the diagram of a calorimeter.",
        "11. Define enthalpy of neutralization.",
        "12. Give an example of endothermic dissolution reaction.",
        "13. Write the formula for heat change in calorimetry (q = mcΔT).",
        "14. Explain the meaning of specific heat capacity.",
        "15. State the precautions while performing calorimetry experiments.",
        "16. Differentiate between heat and temperature.",
        "17. Explain the role of insulation in a calorimeter.",
        "18. Define standard enthalpy change of reaction.",
        "19. Give an industrial application of exothermic reaction.",
        "20. Mention one everyday example of endothermic reaction.",
        "21. Why is it important to stir the solution in a calorimetry experiment?",
        "22. Explain the energy profile diagram of an exothermic reaction.",
        "23. Explain the energy profile diagram of an endothermic reaction.",
        "24. Define activation energy.",
        "25. Why is energy changes study important in real life chemistry?"
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
            text = "Energy Changes Practicals",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // EXOTHERMIC REACTION
        PracticalSection(
            title = "Exothermic Reaction",
            aim = "To demonstrate an exothermic reaction using neutralization.",
            theory = "Exothermic reactions release heat to the surroundings. Example: HCl + NaOH → NaCl + H₂O + heat.",
            apparatus = "• Calorimeter\n• Beaker\n• Thermometer\n• Stirrer\n• Dilute HCl\n• NaOH solution",
            procedure = "1. Measure a known volume of dilute HCl in calorimeter.\n" +
                    "2. Record its initial temperature.\n" +
                    "3. Add equal volume of NaOH solution quickly.\n" +
                    "4. Stir and record highest temperature reached.\n" +
                    "5. Calculate ΔT and determine heat change using q = mcΔT.",
            diagramRes = R.drawable.exothermic // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // ENDOTHERMIC REACTION
        PracticalSection(
            title = "Endothermic Reaction",
            aim = "To study an endothermic reaction using dissolution of salt.",
            theory = "Endothermic reactions absorb heat from surroundings. Example: Dissolution of NH4Cl in water.",
            apparatus = "• Calorimeter\n• Beaker\n• Thermometer\n• Ammonium chloride crystals\n• Stirrer",
            procedure = "1. Take water in a calorimeter and record initial temperature.\n" +
                    "2. Add known mass of ammonium chloride.\n" +
                    "3. Stir well until it dissolves.\n" +
                    "4. Record lowest temperature reached.\n" +
                    "5. Note the fall in temperature to confirm endothermic reaction.",
            diagramRes = R.drawable.endothermic // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // CALORIMETRY EXPERIMENT
        PracticalSection(
            title = "Calorimetry Experiment",
            aim = "To determine heat of neutralization using calorimeter.",
            theory = "Calorimetry measures heat change in a chemical reaction. Heat change is given by q = mcΔT.",
            apparatus = "• Calorimeter\n• Thermometer\n• HCl solution\n• NaOH solution\n• Measuring cylinder",
            procedure = "1. Place dilute HCl in calorimeter and record initial temperature.\n" +
                    "2. Add equal volume of NaOH solution.\n" +
                    "3. Stir and record final temperature.\n" +
                    "4. Use q = mcΔT to calculate heat of neutralization.",
            diagramRes = R.drawable.calorimeter // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // ENERGY PROFILE DIAGRAMS
        PracticalSection(
            title = "Energy Profile Diagrams",
            aim = "To compare exothermic and endothermic energy profiles.",
            theory = "Exothermic reactions show products at lower energy than reactants; endothermic show products at higher energy.",
            apparatus = "• Graph paper\n• Marker pens\n• Ruler",
            procedure = "1. Draw energy vs reaction progress graph.\n" +
                    "2. For exothermic, plot products below reactants.\n" +
                    "3. For endothermic, plot products above reactants.\n" +
                    "4. Mark activation energy and ΔH in diagrams.",
            diagramRes = R.drawable.energy_profile // replace with your drawable resource
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
