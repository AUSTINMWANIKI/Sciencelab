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
import com.austin.sciencelab.navigation.ROUT_VIRTUALLABS1
import com.austin.sciencelab.ui.screens.physics.PracticalSection
import com.austin.sciencelab.ui.screens.physics.PreviewAnswers
import com.austin.sciencelab.ui.screens.physics.QuestionItem
import com.austin.sciencelab.ui.theme.lightGreen

@Composable
fun OrganicAnalysisPracticalScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    val answers = remember { mutableStateListOf(*Array(20) { "" }) }
    var showPreview by remember { mutableStateOf(false) }

    val questions = listOf(
        "1. State the aim of organic analysis in chemistry.",
        "2. Describe how a combustion test is used to detect carbon and hydrogen in organic compounds.",
        "3. Explain the solubility test and its importance in classifying organic compounds.",
        "4. What observations indicate the presence of unsaturation in the bromine water test?",
        "5. Explain how the Baeyer's test (KMnO₄) confirms the presence of double bonds.",
        "6. Differentiate between primary, secondary, and tertiary alcohols based on Lucas test results.",
        "7. State the principle behind the iodoform test and the functional group it identifies.",
        "8. How can you distinguish between aldehydes and ketones using Tollen’s reagent?",
        "9. Describe the Fehling’s solution test and its application in organic analysis.",
        "10. State precautions when handling concentrated sulfuric acid in dehydration experiments.",
        "11. What is esterification and how can it be tested in the laboratory?",
        "12. How can infrared spectroscopy complement wet tests in organic analysis?",
        "13. Explain the difference between qualitative and quantitative organic analysis.",
        "14. State how carboxylic acids can be identified in the lab.",
        "15. Describe the test for phenols using neutral FeCl₃ solution.",
        "16. Why is organic analysis important in pharmaceuticals?",
        "17. Explain the principle of chromatography in separation of organic compounds.",
        "18. What are functional group tests and why are they important?",
        "19. Give two safety rules to observe in an organic chemistry lab.",
        "20. Compare the use of modern instrumental methods with classical wet tests."
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
            text = "Organic Analysis Practical",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // Experiment 1 - Combustion Test
        PracticalSection(
            title = "Combustion Test",
            aim = "To detect the presence of carbon and hydrogen in organic compounds.",
            theory = "When an organic compound burns in oxygen, carbon dioxide and water are formed, confirming the presence of carbon and hydrogen.",
            apparatus = "• Combustion tube\n• Copper(II) oxide\n• Drying agent (CaCl₂)\n• U-tube with lime water",
            procedure = "1. Place sample in combustion tube with copper(II) oxide.\n" +
                    "2. Heat strongly in presence of oxygen.\n" +
                    "3. Pass gases through CaCl₂ to remove water.\n" +
                    "4. Bubble gases into lime water.\n" +
                    "5. Record formation of water and CO₂.",
            diagramRes = R.drawable.organic_combustion // replace with your drawable
        )

        Spacer(Modifier.height(24.dp))

        // Experiment 2 - Bromine Water Test
        PracticalSection(
            title = "Bromine Water Test",
            aim = "To test for unsaturation (double or triple bonds) in organic compounds.",
            theory = "Bromine water is decolorized by alkenes and alkynes due to addition reactions, but not by alkanes.",
            apparatus = "• Test tubes\n• Bromine water\n• Organic samples",
            procedure = "1. Add a few drops of bromine water to organic sample.\n" +
                    "2. Shake the mixture.\n" +
                    "3. Observe decolorization if unsaturation is present.",
            diagramRes = R.drawable.organic_bromine // replace with your drawable
        )

        Spacer(Modifier.height(24.dp))

        // Experiment 3 - Tollen’s Test
        PracticalSection(
            title = "Tollen’s Test",
            aim = "To distinguish between aldehydes and ketones.",
            theory = "Tollen’s reagent oxidizes aldehydes to acids while reducing itself to metallic silver, producing a silver mirror.",
            apparatus = "• Test tubes\n• Tollen’s reagent\n• Aldehyde and ketone samples",
            procedure = "1. Add freshly prepared Tollen’s reagent to sample in a test tube.\n" +
                    "2. Warm gently in a water bath.\n" +
                    "3. Observe silver mirror with aldehyde, no reaction with ketone.",
            diagramRes = R.drawable.organic_tollens // replace with your drawable
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

        Spacer(Modifier.height(4.dp))

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
            colors = ButtonDefaults.buttonColors(lightGreen),
        )
        {
            Text(text = "Virtuallabs2")
        }

        if (showPreview) {
            PreviewAnswers(questions = questions, answers = answers)
        }
    }
}
