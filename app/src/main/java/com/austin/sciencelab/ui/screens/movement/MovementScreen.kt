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
fun SupportMovementPracticalScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    val answers = remember { mutableStateListOf("", "", "", "", "", "", "", "", "", "") }
    var showPreview by remember { mutableStateOf(false) }

    val questions = listOf(
        "1. State three functions of the human skeleton.",
        "2. Differentiate between axial and appendicular skeleton with examples.",
        "3. Explain the structural differences between tendons and ligaments.",
        "4. Name the types of joints found in the human body and give one example of each.",
        "5. Using Figure 1, explain how antagonistic muscles bring about movement at the elbow joint.",
        "6. Describe the adaptations of long bones for support and movement.",
        "7. What is the role of cartilage in joints?",
        "8. Explain the importance of synovial fluid in joint movement.",
        "9. Give one example of a hinge joint, ball-and-socket joint, and pivot joint.",
        "10. Complete an observation table comparing bones, muscles, and joints in support and movement."
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
            text = "Support and Movement Practical",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Intro
        Text(
            text = "This practical explores the structure and function of the skeleton, joints, and muscles in support and movement.",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Image
        Text(
            text = "Figure 1: Human Skeleton",
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = painterResource(id = R.drawable.skeleton),
            contentDescription = "Human Skeleton Diagram",
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Another Image
        Text(
            text = "Figure 2: Antagonistic Muscles at the Elbow Joint",
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = painterResource(id = R.drawable.muscles),
            contentDescription = "Muscles Diagram",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Table
        Text(
            text = "Table 1: Skeletal System Components",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        SupportMovementTable(
            headers = listOf("Component", "Function"),
            rows = listOf(
                listOf("Bones", "Provide support, protection, and aid movement"),
                listOf("Joints", "Allow movement between bones"),
                listOf("Ligaments", "Connect bone to bone, stabilize joints"),
                listOf("Tendons", "Connect muscle to bone"),
                listOf("Cartilage", "Reduce friction, absorb shock in joints")
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
            text = "Table 2: Types of Joints",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        SupportMovementTable(
            headers = listOf("Joint Type", "Example", "Movement"),
            rows = listOf(
                listOf("Hinge Joint", "Elbow, knee", "Movement in one plane"),
                listOf("Ball-and-socket", "Shoulder, hip", "Movement in all directions"),
                listOf("Pivot Joint", "Neck (atlas and axis)", "Rotation"),
                listOf("Gliding Joint", "Wrist, ankle", "Sliding movements")
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
fun SupportMovementTable(headers: List<String>, rows: List<List<String>>) {
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
