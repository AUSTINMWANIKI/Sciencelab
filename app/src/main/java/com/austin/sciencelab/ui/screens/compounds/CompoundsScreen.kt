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
fun OrganicChemistryPracticalsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    // Store answers
    val answers = remember { mutableStateListOf(*Array(25) { "" }) }
    var showPreview by remember { mutableStateOf(false) }

    // Questions list
    val questions = listOf(
        "1. State the aim of testing organic compounds by solubility method.",
        "2. List four general solubility tests for organic compounds.",
        "3. What inference can be drawn if a compound is soluble in water?",
        "4. State the principle of detecting functional groups in organic chemistry.",
        "5. Write the observation and inference when phenol reacts with neutral FeCl₃ solution.",
        "6. State the aim of the test for unsaturation using bromine water.",
        "7. Explain the procedure for bromine water test and expected results.",
        "8. Write the chemical equation for decolorisation of bromine by alkenes.",
        "9. State the aim of Baeyer's test for unsaturation.",
        "10. Describe the result of Baeyer's test with alkenes and alkynes.",
        "11. Mention the apparatus required for identification of aldehydes using Tollen’s reagent.",
        "12. Explain the principle of Tollen’s test.",
        "13. State the aim of Fehling’s test and expected observation.",
        "14. Describe the procedure for the iodoform test.",
        "15. List the compounds that give a positive iodoform test.",
        "16. Write the chemical equation for the iodoform test with ethanol.",
        "17. State two precautions during organic qualitative analysis.",
        "18. Define functional group and give two examples.",
        "19. Differentiate between aliphatic and aromatic compounds.",
        "20. Mention one application of functional group analysis in industries.",
        "21. State the aim of esterification test.",
        "22. Explain the procedure for preparing an ester from carboxylic acid and alcohol.",
        "23. Write the characteristic property of esters.",
        "24. Mention two safety precautions when handling organic reagents.",
        "25. Explain the importance of organic qualitative analysis in medicine."
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
            text = "Organic Chemistry Practicals",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // PRACTICAL 1: Solubility Tests
        PracticalSection(
            title = "Solubility Test",
            aim = "To classify organic compounds based on their solubility in different solvents.",
            theory = "The solubility of an organic compound gives information about its polarity and functional groups. Polar compounds dissolve in polar solvents like water, while nonpolar dissolve in organic solvents.",
            apparatus = "• Test tubes\n• Distilled water\n• Dilute NaOH\n• Dilute HCl\n• Organic solvents",
            procedure = "1. Take a small amount of compound in a test tube.\n" +
                    "2. Add water and shake.\n" +
                    "3. Repeat with NaOH, HCl, and ethanol.\n" +
                    "4. Record solubility pattern and infer possible functional groups.",
            diagramRes = R.drawable.solubility // replace with drawable
        )

        Spacer(Modifier.height(24.dp))

        // PRACTICAL 2: Unsaturation Test
        PracticalSection(
            title = "Test for Unsaturation",
            aim = "To detect the presence of carbon-carbon double or triple bonds using bromine water.",
            theory = "Unsaturated hydrocarbons decolorize bromine water due to addition reaction across the double or triple bond.",
            apparatus = "• Test tubes\n• Bromine water\n• Dropper\n• Unknown sample",
            procedure = "1. Add 2 ml of bromine water to the test tube.\n" +
                    "2. Add a few drops of the organic compound.\n" +
                    "3. Shake well and observe color change.\n" +
                    "4. Decolorisation confirms unsaturation.",
            diagramRes = R.drawable.bromine_test // replace with drawable
        )

        Spacer(Modifier.height(24.dp))

        // PRACTICAL 3: Aldehyde Test
        PracticalSection(
            title = "Tollen’s Test for Aldehydes",
            aim = "To distinguish aldehydes from ketones using Tollen’s reagent.",
            theory = "Aldehydes reduce Tollen’s reagent (ammoniacal silver nitrate) to metallic silver, forming a silver mirror deposit.",
            apparatus = "• Test tubes\n• Tollen’s reagent\n• Water bath\n• Organic sample",
            procedure = "1. Add 2 ml of Tollen’s reagent to a test tube.\n" +
                    "2. Add a few drops of the organic sample.\n" +
                    "3. Warm gently in a water bath.\n" +
                    "4. Observe formation of a silver mirror for aldehydes.",
            diagramRes = R.drawable.tollens_test // replace with drawable
        )

        Spacer(Modifier.height(24.dp))

        // PRACTICAL 4: Esterification
        PracticalSection(
            title = "Esterification Test",
            aim = "To prepare an ester from alcohol and carboxylic acid.",
            theory = "When alcohol reacts with carboxylic acid in the presence of concentrated H₂SO₄, esters are formed which have a fruity smell.",
            apparatus = "• Test tubes\n• Ethanol\n• Acetic acid\n• Conc. H₂SO₄\n• Water bath",
            procedure = "1. Mix ethanol and acetic acid in a test tube.\n" +
                    "2. Add a few drops of conc. H₂SO₄.\n" +
                    "3. Warm in a water bath for 5 minutes.\n" +
                    "4. Smell carefully for fruity ester odor.",
            diagramRes = R.drawable.esterification // replace with drawable
        )

        Spacer(Modifier.height(24.dp))

        // Extended Questions
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
