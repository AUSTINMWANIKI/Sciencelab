package com.austin.sciencelab.ui.screens.physics

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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.austin.sciencelab.R
import com.austin.sciencelab.navigation.ROUT_VIRTUALLABS2
import com.austin.sciencelab.ui.theme.lightGreen

@Composable
fun MechanicsPracticalsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    // Increased number of questions (now 35 instead of 20)
    val answers = remember { mutableStateListOf(
        *Array(35) { "" }
    ) }
    var showPreview by remember { mutableStateOf(false) }

    // Extended Questions
    val questions = listOf(
        // Mechanics ones (kept from before)
        "1. State the aim of verifying Hooke’s Law using a helical spring.",
        "2. What apparatus are required for the Hooke’s Law experiment?",
        "3. Explain the step-by-step procedure for Hooke’s Law practical.",
        "4. Plot a graph of extension vs load for a helical spring and describe its shape.",
        "5. Define elastic limit and explain how it is observed in this experiment.",
        "6. State the precautions taken while performing Hooke’s Law experiment.",
        "7. Write down the aim of verifying the principle of moments.",
        "8. List the apparatus required for the principle of moments experiment.",
        "9. Describe the experimental procedure for principle of moments.",
        "10. Explain why the sum of clockwise moments equals sum of anticlockwise moments.",
        "11. Draw and label the diagram of the setup for the principle of moments.",
        "12. Write the observation table for the moments experiment.",
        "13. State the aim of determining the acceleration due to gravity using a simple pendulum.",
        "14. List the apparatus required for the simple pendulum experiment.",
        "15. Derive the formula for the period of oscillation of a simple pendulum.",
        "16. Explain the procedure for obtaining accurate value of ‘g’.",
        "17. Why are small oscillations recommended in the simple pendulum experiment?",
        "18. Construct an observation table for the pendulum experiment.",
        "19. State two sources of error in the pendulum experiment.",
        "20. Explain the significance of mechanics practicals in understanding physics.",


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
            text = "Physics additional Practicals",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // HOOKE'S LAW PRACTICAL
        PracticalSection(
            title = "Hooke’s Law Experiment",
            aim = "To verify Hooke’s Law using a helical spring.",
            theory = "Hooke’s Law states that the extension in a spring is directly proportional to the applied load, provided the elastic limit is not exceeded.",
            apparatus = "• Retort stand\n• Helical spring\n• Weights and hanger\n• Meter rule\n• Pointer",
            procedure = "1. Suspend the spring from the retort stand.\n" +
                    "2. Attach a pointer to the lower end of the spring.\n" +
                    "3. Add weights one by one and record the extension.\n" +
                    "4. Plot a graph of load vs extension.\n" +
                    "5. Verify that the graph is a straight line.",
            diagramRes = R.drawable.elastic
        )

        Spacer(Modifier.height(24.dp))

        // PRINCIPLE OF MOMENTS PRACTICAL
        PracticalSection(
            title = "Principle of Moments",
            aim = "To verify the principle of moments using a meter rule.",
            theory = "According to the principle of moments, when a body is in equilibrium, the sum of clockwise moments equals the sum of anticlockwise moments about a pivot.",
            apparatus = "• Meter rule\n• Knife edge (fulcrum)\n• Weights and hangers\n• Thread",
            procedure = "1. Balance the meter rule horizontally on the knife edge.\n" +
                    "2. Suspend weights at different points on either side of the pivot.\n" +
                    "3. Record distances of weights from the fulcrum.\n" +
                    "4. Compare clockwise and anticlockwise moments.\n" +
                    "5. Verify that they are equal.",
            diagramRes = R.drawable.rule
        )

        Spacer(Modifier.height(24.dp))

        // SIMPLE PENDULUM PRACTICAL
        PracticalSection(
            title = "Simple Pendulum",
            aim = "To determine acceleration due to gravity (g) using a simple pendulum.",
            theory = "The period of a pendulum depends on its length and acceleration due to gravity, given by T = 2π√(L/g).",
            apparatus = "• String\n• Bob\n• Stopwatch\n• Clamp stand",
            procedure = "1. Suspend a small metallic bob using a string.\n" +
                    "2. Measure the length from the point of suspension to the bob’s center.\n" +
                    "3. Displace the bob slightly and release.\n" +
                    "4. Measure the time for 20 oscillations.\n" +
                    "5. Calculate period and determine g using the formula.",
            diagramRes = R.drawable.pendulum
        )

        Spacer(Modifier.height(24.dp))

        // Questions
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
            onClick = {navController.navigate(ROUT_VIRTUALLABS2)},
            modifier = Modifier.align(Alignment.CenterHorizontally),
            colors = ButtonDefaults.buttonColors(lightGreen)

        ) {
            Text(
                text="Virtuallabs2",
            )
        }

        if (showPreview) {
            PreviewAnswers(questions = questions, answers = answers)
        }
    }
}

@Composable
fun PracticalSection(title: String, aim: String, theory: String, apparatus: String, procedure: String, diagramRes: Int) {
    Text(title, fontWeight = FontWeight.Bold, fontSize = 20.sp)
    Spacer(Modifier.height(8.dp))

    Text("Aim:", fontWeight = FontWeight.Bold); Text(aim)
    Spacer(Modifier.height(8.dp))

    Text("Theory:", fontWeight = FontWeight.Bold); Text(theory)
    Spacer(Modifier.height(8.dp))

    Text("Apparatus:", fontWeight = FontWeight.Bold); Text(apparatus)
    Spacer(Modifier.height(8.dp))

    Text("Procedure:", fontWeight = FontWeight.Bold); Text(procedure)
    Spacer(Modifier.height(8.dp))

    Image(
        painter = painterResource(id = diagramRes),
        contentDescription = "$title diagram",
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(8.dp)
    )
    Spacer(Modifier.height(16.dp))
}

@Composable
fun QuestionItem(question: String, answer: String, onAnswerChange: (String) -> Unit) {
    Column(Modifier.padding(vertical = 8.dp)) {
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
    Spacer(Modifier.height(16.dp))
    Text("Your Answers Preview", fontSize = 18.sp, fontWeight = FontWeight.Bold)
    Spacer(Modifier.height(8.dp))

    questions.forEachIndexed { i, q ->
        Text(
            text = "$q\nAnswer: ${if (answers[i].isBlank()) "Not answered" else answers[i]}",
            fontSize = 14.sp,
            modifier = Modifier.padding(vertical = 4.dp)
        )
    }
}
