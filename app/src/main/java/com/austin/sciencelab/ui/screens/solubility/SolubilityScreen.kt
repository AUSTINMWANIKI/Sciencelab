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
import com.austin.sciencelab.navigation.ROUT_VIRTUALLABS1
import com.austin.sciencelab.ui.screens.physics.PracticalSection
import com.austin.sciencelab.ui.screens.physics.PreviewAnswers
import com.austin.sciencelab.ui.screens.physics.QuestionItem
import com.austin.sciencelab.ui.theme.lightGreen

@Composable
fun SolubilityPracticalsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    // Store answers for questions
    val answers = remember { mutableStateListOf(*Array(25) { "" }) }
    var showPreview by remember { mutableStateOf(false) }

    // Solubility practical questions
    val questions = listOf(
        "1. State the aim of determining the solubility of a salt in water at room temperature.",
        "2. Define solubility and give its SI unit.",
        "3. List the apparatus required for solubility determination.",
        "4. Explain the procedure of preparing a saturated solution of salt.",
        "5. How is the mass of solute required for saturation determined?",
        "6. Write the formula used to calculate solubility in g/100 g of water.",
        "7. State the precautions to be observed during solubility determination.",
        "8. Explain how temperature affects solubility.",
        "9. Why is stirring important when preparing a saturated solution?",
        "10. Define a saturated solution with an example.",
        "11. State the difference between solubility and concentration.",
        "12. List two factors that affect solubility other than temperature.",
        "13. What is the significance of determining solubility in industries?",
        "14. Describe how solubility curves are plotted.",
        "15. What information can be obtained from a solubility curve?",
        "16. Define miscible and immiscible liquids with examples.",
        "17. Explain the term 'solvent extraction'.",
        "18. State Henry’s law and its application in solubility of gases.",
        "19. Why is solubility of gases higher at low temperature?",
        "20. Give two examples of gases whose solubility is important in everyday life.",
        "21. Explain the concept of crystallization from saturated solutions.",
        "22. Differentiate between electrolytes and non-electrolytes in solubility.",
        "23. Why is solubility an important parameter in pharmaceuticals?",
        "24. Mention two sources of error in solubility experiments.",
        "25. Explain how impurities affect solubility results."
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
            text = "Solubility Practicals",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // EXPERIMENT 1
        PracticalSection(
            title = "Solubility of a Salt",
            aim = "To determine the solubility of potassium nitrate in water at room temperature.",
            theory = "Solubility is the maximum amount of solute that can dissolve in 100 g of solvent at a given temperature to form a saturated solution.",
            apparatus = "• Beaker\n• Balance\n• Spatula\n• Stirring rod\n• Measuring cylinder\n• Thermometer",
            procedure = "1. Measure 50 cm³ of distilled water into a beaker.\n" +
                    "2. Gradually add potassium nitrate with stirring until no more dissolves.\n" +
                    "3. Filter the solution to remove excess solute.\n" +
                    "4. Evaporate a known volume of filtrate and weigh the dry residue.\n" +
                    "5. Calculate solubility using: Solubility = (Mass of solute / Mass of solvent) × 100.",
            diagramRes = R.drawable.solubility_salts // replace with your drawable
        )

        Spacer(Modifier.height(24.dp))

        // EXPERIMENT 2
        PracticalSection(
            title = "Effect of Temperature on Solubility",
            aim = "To study the variation of solubility of potassium nitrate with temperature.",
            theory = "Solubility generally increases with temperature. A solubility curve can be plotted by measuring solubility at different temperatures.",
            apparatus = "• Beaker\n• Thermometer\n• Balance\n• Stirring rod\n• Hot plate\n• Ice bath",
            procedure = "1. Prepare a saturated solution of potassium nitrate at a high temperature.\n" +
                    "2. Record the temperature at which crystals just begin to form upon cooling.\n" +
                    "3. Repeat at different temperatures.\n" +
                    "4. Plot a graph of solubility (g/100 g water) vs temperature.",
            diagramRes = R.drawable.solubility_curve // replace with your drawable
        )

        Spacer(Modifier.height(24.dp))

        // EXPERIMENT 3
        PracticalSection(
            title = "Solubility of Gases",
            aim = "To study the effect of temperature on solubility of carbon dioxide in water.",
            theory = "The solubility of gases decreases with increase in temperature and increases with pressure (Henry’s law).",
            apparatus = "• Bottle of soda water\n• Beaker\n• Thermometer\n• Delivery tube\n• Water bath",
            procedure = "1. Cool soda water and observe gas release when opened.\n" +
                    "2. Warm soda water and observe effervescence.\n" +
                    "3. Compare solubility of CO₂ at different temperatures.",
            diagramRes = R.drawable.solubility_gas // replace with your drawable
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
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(lightGreen)
        ) {
            Text(if (showPreview) "Hide Preview" else "Show Preview")
        }

        Button(
            onClick = {navController.navigate(ROUT_VIRTUALLABS1)},
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(lightGreen)

        )
        {
            Text(text = "Virtuallabs1")
        }

        if (showPreview) {
            PreviewAnswers(questions = questions, answers = answers)
        }
    }
}
