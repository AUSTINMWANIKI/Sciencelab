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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.austin.sciencelab.R
import com.austin.sciencelab.ui.screens.physics.PracticalSection
import com.austin.sciencelab.ui.screens.physics.PreviewAnswers
import com.austin.sciencelab.ui.screens.physics.QuestionItem

@Composable
fun MolesPracticalScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    // Store answers for extended questions
    val answers = remember { mutableStateListOf(*Array(20) { "" }) }
    var showPreview by remember { mutableStateOf(false) }

    // Extended questions related to Moles
    val questions = listOf(
        "1. Define a mole in terms of Avogadro’s number.",
        "2. State the molar volume of a gas at STP.",
        "3. Explain the relation between mass, moles, and molar mass.",
        "4. How do you determine the number of moles of a substance from its mass?",
        "5. What is the significance of Avogadro’s hypothesis?",
        "6. State two applications of the mole concept in chemistry.",
        "7. Explain how to calculate empirical formula using experimental data.",
        "8. Differentiate between empirical and molecular formula.",
        "9. Describe a laboratory experiment to determine molar volume of a gas.",
        "10. State precautions in gas collection experiments.",
        "11. Explain how titration is used to determine number of moles in a solution.",
        "12. What is a primary standard? Give examples.",
        "13. Define molarity and normality with examples.",
        "14. Explain how to calculate the number of moles in a given volume of solution.",
        "15. State the aim of the mole ratio experiment in reactions.",
        "16. How do you use balanced equations to determine mole ratios?",
        "17. Mention possible sources of error in mole determination experiments.",
        "18. Describe one real-life application of mole calculations.",
        "19. Why is the mole concept important in stoichiometry?",
        "20. Calculate the number of molecules in 0.5 moles of water."
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
            text = "Moles Chemistry Practical",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // Experiment 1 - Molar Mass Determination
        PracticalSection(
            title = "Molar Mass Determination",
            aim = "To determine the molar mass of a substance using experimental data.",
            theory = "Molar mass (M) = Mass of substance (m) / Number of moles (n). The mole relates mass of a substance to number of particles.",
            apparatus = "• Balance\n• Solid sample (e.g., NaCl)\n• Weighing boat\n• Distilled water",
            procedure = "1. Weigh a known mass of substance.\n" +
                    "2. Dissolve it in water.\n" +
                    "3. Calculate number of moles using n = m / M.\n" +
                    "4. Use data to verify molar mass.",
            diagramRes = R.drawable.moles_mass // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // Experiment 2 - Molar Volume of a Gas
        PracticalSection(
            title = "Molar Volume of a Gas",
            aim = "To determine the molar volume of hydrogen gas at room temperature and pressure.",
            theory = "Molar volume is the volume occupied by one mole of gas at STP, equal to 22.4 dm³.",
            apparatus = "• Conical flask\n• Zinc granules\n• Dilute HCl\n• Gas syringe / measuring cylinder\n• Stopwatch",
            procedure = "1. React zinc with dilute HCl to produce hydrogen.\n" +
                    "2. Collect gas in syringe and record volume.\n" +
                    "3. Measure time and ensure no leakage.\n" +
                    "4. Calculate moles of hydrogen from balanced equation.\n" +
                    "5. Find molar volume = Volume / Number of moles.",
            diagramRes = R.drawable.moles_gas // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // Experiment 3 - Mole Ratio in Reactions
        PracticalSection(
            title = "Mole Ratio Experiment",
            aim = "To determine the mole ratio between reactants in a chemical reaction.",
            theory = "The coefficients in a balanced chemical equation show mole ratios. Experimentally, these can be verified by reacting known amounts.",
            apparatus = "• Measuring cylinder\n• Solutions of NaOH and HCl\n• Burette and pipette\n• Indicator",
            procedure = "1. Pipette known volume of NaOH into conical flask.\n" +
                    "2. Add indicator.\n" +
                    "3. Titrate with standard HCl solution until end point.\n" +
                    "4. Record volumes.\n" +
                    "5. Calculate mole ratio of NaOH to HCl from balanced equation.",
            diagramRes = R.drawable.moles_titration // replace with your drawable resource
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
