package com.austin.sciencelab.ui.screens.books

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.austin.sciencelab.R
import com.austin.sciencelab.ui.theme.lightGreen
import com.austin.sciencelab.ui.theme.lighterGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BooksScreen(navController: NavController){
    //Scaffold

    var selectedIndex by remember { mutableStateOf(0) }

    Scaffold(
        //TopBar
        topBar = {
            TopAppBar(
                title = { Text("Books Screen") },
                navigationIcon = {
                    IconButton(onClick = { /* Handle back/nav */ }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Back")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = lighterGreen,
                    titleContentColor = Color.White,
                    navigationIconContentColor = Color.White
                )
            )
        },

        //BottomBar
        bottomBar = {
            NavigationBar(
                containerColor = lighterGreen
            ){
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Home") },
                    selected = selectedIndex == 0,
                    onClick = { selectedIndex = 0
                        //navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Favorite, contentDescription = "Favorites") },
                    label = { Text("Favorites") },
                    selected = selectedIndex == 1,
                    onClick = { selectedIndex = 1
                        // navController.navigate(ROUT_HOME)
                    }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Person, contentDescription = "Profile") },
                    label = { Text("Profile") },
                    selected = selectedIndex == 2,
                    onClick = { selectedIndex = 2
                        //  navController.navigate(ROUT_HOME)
                    }
                )

            }
        },

        //FloatingActionButton
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /* Add action */ },
                containerColor = Color.LightGray
            ) {
                Icon(Icons.Default.Add, contentDescription = "Add")
            }
        },
        content = { paddingValues ->
            Column(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize()
            ) {
                Spacer(modifier = Modifier.padding(top = 30.dp))


                //Main Contents of the page
                Column (
                    modifier = Modifier.fillMaxWidth().fillMaxSize(),

                    )

                {
                    Row (
                        modifier = Modifier.horizontalScroll(rememberScrollState())
                    ){
                        Card (
                            colors = CardDefaults.cardColors(lightGreen),
                            modifier = Modifier.height(340.dp).width(320.dp)
                        ){
                            Image(
                                painter = painterResource(R.drawable.book),
                                contentDescription = "buy",
                                modifier = Modifier.fillMaxSize()
                                )
                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Card (
                            colors = CardDefaults.cardColors(lightGreen),
                            modifier = Modifier.height(340.dp).width(320.dp)
                        ){
                            Image(
                                painter = painterResource(R.drawable.text),
                                contentDescription = "buy",
                                modifier = Modifier.fillMaxSize()
                            )

                        }
                        Spacer(modifier = Modifier.width(20.dp))
                        Card (
                            colors = CardDefaults.cardColors(lightGreen),
                            modifier = Modifier.height(340.dp).width(320.dp)
                        ){
                            Image(
                                painter = painterResource(R.drawable.prac),
                                contentDescription = "buy",
                                modifier = Modifier.fillMaxSize()
                            )

                        }
                        Spacer(modifier = Modifier.width(20.dp))

                        Card (
                            colors = CardDefaults.cardColors(lightGreen),
                            modifier = Modifier.height(340.dp).width(320.dp)
                        ){  }

                    }
                    Text(text = "We recommend the following books in your journey ")
                }












            }
        }
    )

    //End of scaffold



}




@Preview(showBackground = true)
@Composable
fun BooksScreenPreview(){
    BooksScreen(rememberNavController())
}