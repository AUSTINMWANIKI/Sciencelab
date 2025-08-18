package com.austin.sciencelab.ui.screens.biology

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.austin.sciencelab.R
import com.austin.sciencelab.navigation.ROUT_CELLBIOLOGY
import com.austin.sciencelab.navigation.ROUT_CELLPHYSIOLOGY
import com.austin.sciencelab.navigation.ROUT_PLANTANATOMY
import com.austin.sciencelab.navigation.ROUT_SLIDES
import com.austin.sciencelab.ui.theme.lightGreen

// Data class for practicals
data class BioLabData(val title: String, val imageRes: Int, val route: String)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BiologyPracticalsScreen(navController: NavController) {

    val verticalScroll = rememberScrollState()
    val horizontalScroll = rememberScrollState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Biology Practicals", fontWeight = FontWeight.Bold, fontSize = 20.sp) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = lightGreen,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                ),
                navigationIcon = {
                    IconButton(onClick = { /* open drawer or menu */ }) {
                        Icon(
                            imageVector = Icons.Default.Menu,
                            contentDescription = "Menu"
                        )
                    }
                }
            )
        },
        bottomBar = {
            BottomAppBar(
                containerColor = lightGreen,
                content = {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "© ScienceLab 2025",
                        fontSize = 15.sp,
                        color = MaterialTheme.colorScheme.onPrimary,
                        modifier = Modifier.padding(16.dp)
                    )
                    Spacer(modifier = Modifier.weight(1f))
                }
            )
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .verticalScroll(verticalScroll)
                    .background(MaterialTheme.colorScheme.background)
            ) {

                // Banner
                Image(
                    painter = painterResource(R.drawable.land),
                    contentDescription = "Biology Banner",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(200.dp)
                        .clip(RoundedCornerShape(bottomStart = 16.dp, bottomEnd = 16.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Intro text
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Explore Biology Practicals",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "Engage with interactive biology experiments. Tap on a practical below to begin.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Horizontal scrollable practical cards
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(horizontalScroll)
                        .padding(start = 16.dp, end = 16.dp)
                ) {
                    val practicals = listOf(
                        BioLabData("Cell Biology", R.drawable.land, ROUT_CELLBIOLOGY),
                        BioLabData("Preparation of Temporary Slides", R.drawable.land, ROUT_SLIDES),
                        BioLabData("Cell Physiology", R.drawable.land, ROUT_CELLPHYSIOLOGY),
                        BioLabData("Plant Anatomy", R.drawable.land, ROUT_PLANTANATOMY),

                    )

                    practicals.forEach { lab ->
                        BioLabCardHorizontal(lab) {
                            navController.navigate(lab.route)
                        }
                        Spacer(modifier = Modifier.width(16.dp))
                    }
                }

                Spacer(modifier = Modifier.height(24.dp))

                // Tips section
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp)
                ) {
                    Text(
                        text = "Tips for Biology Practicals",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "• Handle specimens carefully.\n" +
                                "• Label slides properly.\n" +
                                "• Observe under different microscope magnifications.\n" +
                                "• Record detailed diagrams and notes.",
                        fontSize = 16.sp
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }
    )
}

// Card for horizontal layout
@Composable
fun BioLabCardHorizontal(lab: BioLabData, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(180.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = lightGreen),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(lab.imageRes),
                contentDescription = lab.title,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0x80000000))
            )
            Text(
                text = lab.title,
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.align(Alignment.Center),
                maxLines = 2
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BiologyPracticalsScreenPreview() {
    BiologyPracticalsScreen(rememberNavController())
}
