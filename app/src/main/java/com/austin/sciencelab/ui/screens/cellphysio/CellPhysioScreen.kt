package com.austin.sciencelab.ui.screens.biology

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.austin.sciencelab.R
import com.austin.sciencelab.navigation.ROUT_VIRTUALLABS3
import com.austin.sciencelab.ui.theme.lightGreen

@Composable
fun CellPhysiologyPracticalScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    val answers = remember { mutableStateListOf("", "", "", "", "", "", "", "", "", "") }
    var showPreview by remember { mutableStateOf(false) }

    val questions = listOf(
        "1. Define osmosis and explain its importance in maintaining cell turgor.",
        "2. Using potato cylinders, describe how you would investigate the effect of sucrose concentration on osmosis.",
        "3. Differentiate between diffusion and active transport in terms of energy requirement and direction of movement.",
        "4. What role does the plasma membrane play in regulating transport of substances?",
        "5. Using Table 1 above, explain how enzymes accelerate biochemical reactions in cells.",
        "6. State the effect of temperature on enzyme activity and explain what happens at very high temperatures.",
        "7. Using your observations, compare the rate of diffusion in liquids and gases.",
        "8. Why is active transport important in absorption of mineral ions in plant roots?",
        "9. Explain the significance of osmoregulation in animal cells.",
        "10. Complete an observation table comparing passive and active transport."
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF7F9FC))
            .padding(16.dp)
            .verticalScroll(scrollState)
    ) {
        // Title
        Text(
            text = "Cell Physiology Practical",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Intro
        Text(
            text = "This practical explores physiological processes of cells such as osmosis, diffusion, enzyme activity, and active transport.",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Image
        Text(
            text = "Figure 1: Osmosis in Plant Cells",
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = painterResource(id = R.drawable.specimen),
            contentDescription = "Osmosis Diagram",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Table
        Text(
            text = "Table 1: Key Physiological Processes",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        CellPhysiologyTable(
            headers = listOf("Process", "Description"),
            rows = listOf(
                listOf("Osmosis", "Movement of water across a semi-permeable membrane"),
                listOf("Diffusion", "Movement of molecules from high to low concentration"),
                listOf("Active Transport", "Movement against concentration gradient using energy"),
                listOf("Enzyme Activity", "Catalysis of biochemical reactions"),
                listOf("Osmoregulation", "Maintenance of water balance in cells")
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Questions
        Text(
            text = "Practical Questions",
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(12.dp))

        questions.forEachIndexed { index, q ->
            QuestionItem(
                question = q,
                answer = answers[index],
                onAnswerChange = { answers[index] = it }
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Another Table
        Text(
            text = "Table 2: Passive vs Active Transport",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        CellPhysiologyTable(
            headers = listOf("Feature", "Passive Transport", "Active Transport"),
            rows = listOf(
                listOf("Energy Requirement", "Not required", "Required (ATP)"),
                listOf("Direction", "Down concentration gradient", "Against gradient"),
                listOf("Examples", "Osmosis, diffusion", "Ion uptake in roots"),
                listOf("Speed", "Slower", "Faster with energy input")
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        // Buttons
        Button(
            onClick = { showPreview = !showPreview },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(lightGreen)
        ) {
            Text(if (showPreview) "Hide Preview" else "Show Preview")
        }

        Button(
            onClick = { navController.navigate(ROUT_VIRTUALLABS3) },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(lightGreen),
        ) {
            Text(text = "Virtuallabs3")
        }

        if (showPreview) {
            PreviewAnswers(questions = questions, answers = answers)
        }
    }
}

@Composable
fun CellPhysiologyTable(headers: List<String>, rows: List<List<String>>) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.White)
            .padding(8.dp)
    ) {
        // Header Row
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFFB3E5FC))
                .padding(6.dp)
        ) {
            headers.forEach { header ->
                Text(
                    text = header,
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .weight(1f)
                        .padding(4.dp),
                    textAlign = TextAlign.Center
                )
            }
        }

        // Data Rows
        rows.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(6.dp)
            ) {
                row.forEach { cell ->
                    Text(
                        text = cell,
                        fontSize = 14.sp,
                        modifier = Modifier
                            .weight(1f)
                            .padding(4.dp),
                        textAlign = TextAlign.Center
                    )
                }
            }
        }
    }
}
