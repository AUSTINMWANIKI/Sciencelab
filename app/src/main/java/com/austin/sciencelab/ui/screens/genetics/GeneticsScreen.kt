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
fun GeneticsPracticalScreen(navController: NavHostController) {
    val scrollState = rememberScrollState()

    val answers = remember { mutableStateListOf("", "", "", "", "", "", "", "", "", "") }
    var showPreview by remember { mutableStateOf(false) }

    val questions = listOf(
        "1. Define genetics and state its importance in biology.",
        "2. Draw and label the structure of a DNA molecule.",
        "3. Differentiate between genotype and phenotype with examples.",
        "4. Using a Punnett square, show the cross between a heterozygous tall pea plant (Tt) and a homozygous short pea plant (tt).",
        "5. What is Mendel’s Law of Segregation? Give an example.",
        "6. State two differences between mitosis and meiosis.",
        "7. Explain the role of chromosomes in inheritance.",
        "8. Why are sex-linked traits more common in males than in females?",
        "9. Define mutation and give two examples of genetic disorders caused by mutations.",
        "10. Complete an observation table comparing dominant and recessive traits."
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
            text = "Genetics Biology Practical",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Intro
        Text(
            text = "This practical explores genetics concepts such as DNA, inheritance patterns, Mendel’s laws, and genetic disorders.",
            fontSize = 16.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Image 1: DNA
        Text(
            text = "Figure 1: Structure of DNA",
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = painterResource(id = R.drawable.dna_structure),
            contentDescription = "DNA Diagram",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Table 1: Genotype vs Phenotype
        Text(
            text = "Table 1: Genotype vs Phenotype",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        GeneticsTable(
            headers = listOf("Term", "Definition", "Example"),
            rows = listOf(
                listOf("Genotype", "Genetic makeup of an organism", "TT, Tt, tt"),
                listOf("Phenotype", "Observable characteristics", "Tall plant, short plant")
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Image 2: Punnett Square
        Text(
            text = "Figure 2: Punnett Square Example",
            fontWeight = FontWeight.SemiBold
        )
        Image(
            painter = painterResource(id = R.drawable.punnett_square),
            contentDescription = "Punnett Square",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(8.dp)
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

        // Table 2: Dominant vs Recessive Traits
        Text(
            text = "Table 2: Dominant vs Recessive Traits",
            fontWeight = FontWeight.SemiBold,
            fontSize = 16.sp
        )
        Spacer(modifier = Modifier.height(8.dp))

        GeneticsTable(
            headers = listOf("Trait Type", "Description", "Example"),
            rows = listOf(
                listOf("Dominant", "Expressed when at least one allele is present", "Tall (T)"),
                listOf("Recessive", "Expressed only when two alleles are present", "Short (t)")
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
fun GeneticsTable(headers: List<String>, rows: List<List<String>>) {
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
