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
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import com.austin.sciencelab.R
import com.austin.sciencelab.navigation.ROUT_VIRTUALLABS1
import com.austin.sciencelab.ui.screens.physics.PracticalSection
import com.austin.sciencelab.ui.screens.physics.PreviewAnswers
import com.austin.sciencelab.ui.screens.physics.QuestionItem
import com.austin.sciencelab.ui.theme.lightGreen

@Composable
fun CationAnionPracticalsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()
    val answers = remember { mutableStateListOf(*Array(20) { "" }) }
    var showPreview by remember { mutableStateOf(false) }

    val questions = listOf(
        "1. State the aim of qualitative analysis of cations and anions.",
        "2. List five common cations tested in the laboratory.",
        "3. List five common anions tested in the laboratory.",
        "4. Explain the principle of flame tests for cations.",
        "5. What is the importance of confirming reagents?",
        "6. Describe the test for chloride ions using silver nitrate.",
        "7. How are sulfate ions detected?",
        "8. Mention the procedure for detecting carbonate ions.",
        "9. Explain how nitrate ions are detected using brown ring test.",
        "10. Write the procedure for flame test for sodium and potassium.",
        "11. Describe the test for calcium ions using ammonium oxalate.",
        "12. Explain the test for copper ions using ammonium hydroxide.",
        "13. State precautions to avoid contamination during cation-anion tests.",
        "14. Why is a small sample quantity recommended in qualitative tests?",
        "15. Differentiate between confirmatory and preliminary tests.",
        "16. Mention the observations for iron(III) ions with potassium thiocyanate.",
        "17. Explain how ammonium ions are detected using sodium hydroxide.",
        "18. Why must glassware be rinsed with distilled water before tests?",
        "19. State the importance of qualitative analysis in industries.",
        "20. List two sources of error in cation-anion analysis."
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
            text = "Cation-Anion Chemistry Practicals",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // PRACTICAL 1: Flame Tests
        PracticalSection(
            title = "Flame Tests for Cations",
            aim = "To identify metal cations using characteristic flame colors.",
            theory = "Metal cations emit characteristic colors when heated in a flame due to electron excitation and relaxation.",
            apparatus = "• Nichrome wire loop\n• Bunsen burner\n• Dilute HCl\n• Samples of metal salts",
            procedure = "1. Clean the wire loop with dilute HCl.\n" +
                    "2. Dip loop into metal salt sample.\n" +
                    "3. Hold loop in Bunsen burner flame.\n" +
                    "4. Observe flame color and identify cation.",
            diagramRes = R.drawable.flame_test // replace with drawable
        )
        Text(
            text = "The diagram above shows the bright yellow flame showing presence of sodium ions",
            textAlign = TextAlign.Center,
        )

        Spacer(Modifier.height(24.dp))

        // PRACTICAL 2: Precipitation Tests for Anions
        PracticalSection(
            title = "Tests for Anions",
            aim = "To detect common anions such as chloride, sulfate, carbonate, and nitrate.",
            theory = "Anions react with specific reagents to form precipitates or characteristic reactions.",
            apparatus = "• Test tubes\n• Silver nitrate solution\n• Barium chloride solution\n• Dilute acids\n• Unknown sample",
            procedure = "1. For chloride: add AgNO₃, white precipitate indicates Cl⁻.\n" +
                    "2. For sulfate: add BaCl₂, white precipitate indicates SO₄²⁻.\n" +
                    "3. For carbonate: add dilute HCl, effervescence indicates CO₃²⁻.\n" +
                    "4. For nitrate: perform brown ring test with FeSO₄ and H₂SO₄.",
            diagramRes = R.drawable.anion_tests // replace with drawable
        )

        Spacer(Modifier.height(24.dp))

        // PRACTICAL 3: Confirmatory Tests for Cations
        PracticalSection(
            title = "Confirmatory Tests for Cations",
            aim = "To confirm the presence of specific cations using selective reagents.",
            theory = "Cations form characteristic colored precipitates or complexes with specific reagents.",
            apparatus = "• Test tubes\n• Dilute HCl\n• Ammonium hydroxide\n• Ammonium oxalate\n• Unknown samples",
            procedure = "1. For calcium: add ammonium oxalate, white ppt indicates Ca²⁺.\n" +
                    "2. For copper: add ammonium hydroxide, blue complex indicates Cu²⁺.\n" +
                    "3. For iron(III): add potassium thiocyanate, blood red color indicates Fe³⁺.\n" +
                    "4. For ammonium: add NaOH, warm, smell ammonia confirms NH₄⁺.",
            diagramRes = R.drawable.cation_tests // replace with drawable
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
        ) {
            Text(text = "Virtuallabs1")
        }



        if (showPreview) {
            PreviewAnswers(questions = questions, answers = answers)
        }
    }
}
