package com.austin.sciencelab.ui.screens.biology

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
fun TemporarySlidesPracticalsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    val answers = remember { mutableStateListOf(*Array(15) { "" }) }
    var showPreview by remember { mutableStateOf(false) }

    val questions = listOf(
        "1. Define a temporary slide.",
        "2. State the importance of preparing temporary slides in biology.",
        "3. Mention three examples of specimens observed using temporary slides.",
        "4. State precautions taken when preparing slides.",
        "5. Explain why staining is necessary.",
        "6. Differentiate between temporary and permanent slides.",
        "7. Describe preparation of an onion epidermis slide.",
        "8. Why is iodine used in onion slide preparation?",
        "9. Mention two advantages of using cover slips.",
        "10. Role of mounting fluid in temporary slides.",
        "11. List possible errors in slide preparation.",
        "12. How to ensure specimen lies flat on slide?",
        "13. One real-life application of temporary slide preparation.",
        "14. Differentiate wet mount and dry mount preparations.",
        "15. Why must air bubbles be avoided?"
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
            text = "Preparation of Temporary Slides",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // EXPERIMENT 1
        PracticalSection(
            title = "Onion Epidermis Slide",
            aim = "To prepare a temporary slide of an onion epidermis to observe plant cells.",
            theory = "Onion epidermis cells are ideal for studying cell walls, cytoplasm, and nucleus.",
            apparatus = "• Onion bulb\n• Forceps\n• Microscope slide\n• Cover slip\n• Iodine solution\n• Needle",
            procedure = "1. Peel thin epidermis from onion using forceps.\n" +
                    "2. Place epidermis on clean slide.\n" +
                    "3. Add a drop of iodine solution.\n" +
                    "4. Place cover slip carefully to avoid air bubbles.\n" +
                    "5. Observe under microscope.",
            diagramRes = R.drawable.temp_onion_slide // replace with your drawable
        )

        Spacer(Modifier.height(24.dp))

        // EXPERIMENT 2
        PracticalSection(
            title = "Leaf Peel Slide",
            aim = "To prepare a temporary slide of a leaf peel to observe stomata.",
            theory = "Leaf peels allow observation of stomatal distribution and guard cells.",
            apparatus = "• Leaf\n• Forceps\n• Slide & cover slip\n• Water or stain\n• Needle",
            procedure = "1. Peel lower epidermis of a leaf.\n" +
                    "2. Place on slide with a drop of water or stain.\n" +
                    "3. Cover with cover slip.\n" +
                    "4. Observe under microscope.",
            diagramRes = R.drawable.temp_slide_leaf // replace with your drawable
        )

        Spacer(Modifier.height(24.dp))

        // EXPERIMENT 3
        PracticalSection(
            title = "Cheek Cells Slide",
            aim = "To prepare a temporary slide of human cheek cells to observe animal cells.",
            theory = "Cheek cells help study cell membrane, cytoplasm, and nucleus of animal cells.",
            apparatus = "• Sterile swab\n• Slide & cover slip\n• Methylene blue",
            procedure = "1. Gently scrape inner cheek using swab.\n" +
                    "2. Smear sample on slide.\n" +
                    "3. Add drop of methylene blue.\n" +
                    "4. Place cover slip carefully.\n" +
                    "5. Observe under microscope.",
            diagramRes = R.drawable.temp_slide_cheek // replace with your drawable
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
