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

@Composable
fun CellBiologyPracticalScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    // Store answers for preview
    val answers = remember { mutableStateListOf("", "", "", "", "", "", "", "", "", "") }
    var showPreview by remember { mutableStateOf(false) }

    val questions = listOf(
        "1. Draw and label the structure of a typical animal cell as observed under the microscope.",
        "2. State three differences between plant and animal cells based on microscopic observations.",
        "3. Which organelle is responsible for energy production, and why is it often called the 'powerhouse' of the cell?",
        "4. Using Table 1 above, explain the role of ribosomes in protein synthesis.",
        "5. Prepare a wet mount slide of an onion epidermal cell. Record your observations.",
        "6. Identify at least two visible organelles in your slide and describe their functions.",
        "7. Compare your microscopic observations of cheek cells and onion cells.",
        "8. Why do plant cells have a rigid cell wall while animal cells do not?",
        "9. Explain the role of chloroplasts in plant survival.",
        "10. Complete an observation table of your prepared slides (Onion vs Cheek cells)."
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
            text = "Cell Biology Practical",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Intro
        Text(
            text = "This practical focuses on studying cell structures, organelles, and microscopic observation of plant and animal cells.",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Image of Cell Diagram
        Text(
            text = "Figure 1: Labeled Animal Cell",
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = painterResource(id = R.drawable.specimen),
            contentDescription = "Animal Cell Diagram",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Table (Organelles and Functions)
        Text(
            text = "Table 1: Major Organelles and Their Functions",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        CellBiologyTable(
            headers = listOf("Organelle", "Function"),
            rows = listOf(
                listOf("Nucleus", "Controls cell activities, stores genetic material"),
                listOf("Mitochondria", "Site of respiration and energy production"),
                listOf("Chloroplast", "Site of photosynthesis in plant cells"),
                listOf("Ribosomes", "Protein synthesis"),
                listOf("Cell Membrane", "Regulates movement of substances in/out")
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

        // Questions Section
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

        // Another table (Comparison)
        Text(
            text = "Table 2: Comparison of Onion and Cheek Cells",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        CellBiologyTable(
            headers = listOf("Feature", "Onion Cell", "Cheek Cell"),
            rows = listOf(
                listOf("Cell Wall", "Present", "Absent"),
                listOf("Shape", "Rectangular", "Irregular"),
                listOf("Nucleus", "Present", "Present"),
                listOf("Chloroplasts", "Present", "Absent"),
                listOf("Vacuole", "Large central", "Small/absent")
            )
        )

        Spacer(modifier = Modifier.height(24.dp))

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

@Composable
fun QuestionItem(question: String, answer: String, onAnswerChange: (String) -> Unit) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(text = question, fontSize = 15.sp, fontWeight = FontWeight.Medium)
        OutlinedTextField(
            value = answer,
            onValueChange = onAnswerChange,
            placeholder = { Text("Write your answer here...") },
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Composable
fun PreviewAnswers(questions: List<String>, answers: List<String>) {
    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = "Your Answers Preview",
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold
    )
    Spacer(modifier = Modifier.height(8.dp))

    questions.forEachIndexed { i, q ->
        Text(
            text = "$q\nAnswer: ${if (answers[i].isBlank()) "Not answered" else answers[i]}",
            fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}

@Composable
fun CellBiologyTable(headers: List<String>, rows: List<List<String>>) {
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
