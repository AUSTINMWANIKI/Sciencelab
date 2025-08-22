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

@Composable
fun OpticsPracticalsScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    // Store answers for questions
    val answers = remember { mutableStateListOf(*Array(35) { "" }) }
    var showPreview by remember { mutableStateOf(false) }

    // Optics practical questions
    val questions = listOf(
        "1. State the aim of verifying the laws of reflection.",
        "2. List the apparatus required for the reflection experiment.",
        "3. Explain the experimental setup for reflection using a plane mirror.",
        "4. State the laws of reflection.",
        "5. Mention two precautions to obtain accurate reflection readings.",
        "6. State the aim of verifying Snell’s Law of refraction.",
        "7. Write the relation between angle of incidence and angle of refraction.",
        "8. Define refractive index.",
        "9. Describe the procedure for determining the refractive index of glass using a protractor.",
        "10. Draw and label the diagram for Snell’s Law experiment.",
        "11. State the aim of finding the focal length of a convex lens.",
        "12. List the apparatus required for convex lens experiment.",
        "13. Explain the pin method for determining focal length of a convex lens.",
        "14. Write the lens formula and its significance.",
        "15. Mention the precautions in convex lens experiment.",
        "16. State the aim of determining the focal length of a concave lens.",
        "17. Explain the experimental procedure for concave lens using convex lens combination method.",
        "18. Write the formula for focal length in terms of image and object distance.",
        "19. Define real and virtual images with examples.",
        "20. Draw and label the ray diagram for image formation by convex lens.",
        "21. State the aim of determining the refractive index of a prism.",
        "22. Define angle of minimum deviation.",
        "23. Explain the procedure for finding angle of minimum deviation using a prism.",
        "24. Draw a well-labeled diagram for prism deviation experiment.",
        "25. Mention two precautions in prism experiment.",
        "26. Define total internal reflection and state its conditions.",
        "27. Explain an application of total internal reflection.",
        "28. What is a critical angle? How is it determined?",
        "29. Define power of a lens and state its SI unit.",
        "30. Differentiate between converging and diverging lenses.",
        "31. Explain the significance of optics experiments in real life.",
        "32. State two sources of error in optics experiments.",
        "33. Explain why parallax should be removed while taking optical readings.",
        "34. Describe an application of lenses in optical instruments.",
        "35. Mention two uses of prisms in daily life."
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
            text = "Optics Practicals",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(Modifier.height(16.dp))

        // REFLECTION EXPERIMENT
        PracticalSection(
            title = "Laws of Reflection",
            aim = "To verify the laws of reflection using a plane mirror.",
            theory = "The angle of incidence is equal to the angle of reflection, and the incident ray, reflected ray, and normal lie on the same plane.",
            apparatus = "• Plane mirror\n• Drawing board\n• Pins\n• Protractor\n• White paper",
            procedure = "1. Fix a plane mirror on a drawing board.\n" +
                    "2. Draw a normal line and mark an incident ray.\n" +
                    "3. Place pins along the incident ray and view their image.\n" +
                    "4. Draw the reflected ray and measure angles.\n" +
                    "5. Verify that angle of incidence = angle of reflection.",
            diagramRes = R.drawable.reflection // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // REFRACTION (SNELL'S LAW)
        PracticalSection(
            title = "Snell’s Law of Refraction",
            aim = "To verify Snell’s Law and determine the refractive index of glass.",
            theory = "Snell’s Law: n = sin i / sin r. The refractive index is the ratio of sine of angle of incidence to sine of angle of refraction.",
            apparatus = "• Glass slab\n• Protractor\n• Drawing board\n• Pins\n• White paper",
            procedure = "1. Place a glass slab on a white sheet.\n" +
                    "2. Draw the outline of the slab.\n" +
                    "3. Mark incident ray and place pins.\n" +
                    "4. Observe refracted ray and trace it.\n" +
                    "5. Measure angles i and r, and calculate refractive index.",
            diagramRes = R.drawable.refraction // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // CONVEX LENS
        PracticalSection(
            title = "Convex Lens Experiment",
            aim = "To determine the focal length of a convex lens using the pin method.",
            theory = "A convex lens converges parallel rays to a focus. Focal length can be determined using lens formula: 1/f = 1/v - 1/u.",
            apparatus = "• Convex lens\n• Lens holder\n• Optical bench\n• Pins",
            procedure = "1. Mount convex lens on optical bench.\n" +
                    "2. Place a pin at distance u.\n" +
                    "3. Adjust second pin until images coincide.\n" +
                    "4. Record v and u, calculate f using 1/f = 1/v - 1/u.",
            diagramRes = R.drawable.convex_lens // replace with your drawable resource
        )

        Spacer(Modifier.height(24.dp))

        // PRISM
        PracticalSection(
            title = "Prism Experiment",
            aim = "To determine the refractive index of a prism by angle of minimum deviation method.",
            theory = "When light passes through a prism, deviation occurs. At minimum deviation, D, refractive index is given by: n = sin((A+D)/2) / sin(A/2).",
            apparatus = "• Glass prism\n• Spectrometer\n• Light source",
            procedure = "1. Place prism on spectrometer table.\n" +
                    "2. Align telescope and collimator.\n" +
                    "3. Rotate prism and measure minimum deviation angle.\n" +
                    "4. Use formula to calculate refractive index.",
            diagramRes = R.drawable.prism // replace with your drawable resource
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
