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
fun ElectricityPracticalsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    // Expanded list of answers (35 as before for consistency)
    val answers = remember { mutableStateListOf(*Array(35) { "" }) }
    var showPreview by remember { mutableStateOf(false) }

    // Electricity practical questions
    val questions = listOf(
        "1. State the aim of verifying Ohm’s Law.",
        "2. List the apparatus required for Ohm’s Law experiment.",
        "3. Explain the experimental setup of Ohm’s Law.",
        "4. Draw the graph of current (I) vs potential difference (V).",
        "5. Define resistance and how it is determined in this experiment.",
        "6. Mention the precautions for accurate Ohm’s Law results.",
        "7. State the aim of verifying resistors in series combination.",
        "8. Write the formula for equivalent resistance in series.",
        "9. Describe the experimental procedure for resistors in series.",
        "10. Why does the total resistance increase in series connection?",
        "11. Draw and label the circuit diagram for resistors in series.",
        "12. State the aim of verifying resistors in parallel combination.",
        "13. Write the formula for equivalent resistance in parallel.",
        "14. Describe the procedure for resistors in parallel experiment.",
        "15. Why does the total resistance decrease in parallel connection?",
        "16. Draw and label the circuit diagram for resistors in parallel.",
        "17. State the aim of determining internal resistance of a cell using potentiometer.",
        "18. List the apparatus required for potentiometer experiment.",
        "19. Explain the step-by-step procedure for determining internal resistance.",
        "20. Write down two precautions taken in potentiometer experiment.",
        "21. Define electromotive force (emf) and terminal voltage.",
        "22. State two sources of error in Ohm’s Law experiment.",
        "23. Explain the significance of plotting V-I graphs.",
        "24. What is a rheostat and why is it used?",
        "25. Differentiate between emf and potential difference.",
        "26. Define resistivity and give its SI unit.",
        "27. How does temperature affect resistance of a conductor?",
        "28. Explain why copper is preferred in connecting wires.",
        "29. Describe a method to verify Joule’s Law of heating experimentally.",
        "30. Write the expression for electrical power.",
        "31. State the aim of verifying Kirchhoff’s Laws.",
        "32. Write Kirchhoff’s Current Law (KCL) and Kirchhoff’s Voltage Law (KVL).",
        "33. Explain the experimental procedure for verifying KVL.",
        "34. Draw and label the diagram for Kirchhoff’s Laws experiment.",
        "35. Explain the importance of electricity practicals in daily life applications."
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
            text = "Electricity Practicals",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // OHM'S LAW PRACTICAL
        PracticalSection(
            title = "Ohm’s Law Experiment",
            aim = "To verify Ohm’s Law by plotting a graph of V against I.",
            theory = "Ohm’s Law states that the current through a conductor is directly proportional to the potential difference across it, provided the temperature remains constant.",
            apparatus = "• Voltmeter\n• Ammeter\n• Rheostat\n• Battery\n• Key\n• Resistor\n• Connecting wires",
            procedure = "1. Connect the circuit with resistor, voltmeter, ammeter, and battery.\n" +
                    "2. Adjust the rheostat to vary current.\n" +
                    "3. Record voltmeter and ammeter readings.\n" +
                    "4. Plot a graph of V against I.\n" +
                    "5. Verify that the graph is a straight line passing through the origin.",
            diagramRes = R.drawable.img_10 // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // RESISTORS IN SERIES
        PracticalSection(
            title = "Resistors in Series",
            aim = "To verify the law of resistances in series.",
            theory = "For resistors connected in series, the total resistance is equal to the sum of the individual resistances.",
            apparatus = "• Resistors\n• Battery\n• Ammeter\n• Voltmeter\n• Key\n• Wires",
            procedure = "1. Connect two or more resistors in series.\n" +
                    "2. Pass current through the circuit and measure voltage across each resistor.\n" +
                    "3. Calculate equivalent resistance using R = V/I.\n" +
                    "4. Compare with the theoretical value R = R1 + R2 + R3...",
            diagramRes = R.drawable.series // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // RESISTORS IN PARALLEL
        PracticalSection(
            title = "Resistors in Parallel",
            aim = "To verify the law of resistances in parallel.",
            theory = "For resistors connected in parallel, the reciprocal of the equivalent resistance is equal to the sum of the reciprocals of the individual resistances.",
            apparatus = "• Resistors\n• Battery\n• Ammeter\n• Voltmeter\n• Key\n• Wires",
            procedure = "1. Connect two or more resistors in parallel.\n" +
                    "2. Pass current through the circuit and measure total current.\n" +
                    "3. Measure voltage across each resistor.\n" +
                    "4. Calculate equivalent resistance using 1/R = 1/R1 + 1/R2 + ...\n" +
                    "5. Compare with theoretical value.",
            diagramRes = R.drawable.parallels // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // KIRCHHOFF'S LAWS
        PracticalSection(
            title = "Kirchhoff’s Laws",
            aim = "To verify Kirchhoff’s Current Law and Voltage Law.",
            theory = "KCL: The algebraic sum of currents meeting at a junction is zero.\n" +
                    "KVL: The algebraic sum of potential differences around any closed loop is zero.",
            apparatus = "• Resistors\n• Battery eliminator\n• Voltmeter\n• Ammeter\n• Key\n• Wires",
            procedure = "1. Set up a network with two loops.\n" +
                    "2. Measure currents entering and leaving a junction.\n" +
                    "3. Verify that sum of currents is zero (KCL).\n" +
                    "4. Measure voltages around a loop.\n" +
                    "5. Verify that algebraic sum of voltages is zero (KVL).",
            diagramRes = R.drawable.kirchhoff // replace with your drawable resource
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
            colors = ButtonDefaults.buttonColors(lightGreen),

        ) {
            Text(
                text = "Virtuallabs2"
            )
        }

        if (showPreview) {
            PreviewAnswers(questions = questions, answers = answers)
        }
    }
}
