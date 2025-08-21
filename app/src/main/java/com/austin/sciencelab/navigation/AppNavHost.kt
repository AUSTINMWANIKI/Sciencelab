package com.austin.sciencelab.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.austin.sciencelab.repository.UserRepository

import com.austin.sciencelab.ui.screens.auth.LoginScreen
import com.austin.sciencelab.ui.screens.auth.RegisterScreen
import com.austin.sciencelab.viewmodel.AuthViewModel
import com.austin.sciencelab.data.UserDatabase
import com.austin.sciencelab.ui.screens.about.AboutScreen
import com.austin.sciencelab.ui.screens.biology.BiologyLabsScreen
import com.austin.sciencelab.ui.screens.biology.CellBiologyLabScreen
import com.austin.sciencelab.ui.screens.biology.CellBiologyPracticalScreen
import com.austin.sciencelab.ui.screens.biology.CellPhysiologyScreen
import com.austin.sciencelab.ui.screens.biology.PlantAnatomyScreen
import com.austin.sciencelab.ui.screens.biology.SlidePreparationScreen
import com.austin.sciencelab.ui.screens.energychanges.EnergyChangesScreen
import com.austin.sciencelab.ui.screens.home.HomeScreen
import com.austin.sciencelab.ui.screens.inorganic.InorganicScreen
import com.austin.sciencelab.ui.screens.organic.OrganicScreen
import com.austin.sciencelab.ui.screens.physics.ElectricityPracticalScreen
import com.austin.sciencelab.ui.screens.physics.MechanicsPracticalScreen
import com.austin.sciencelab.ui.screens.physics.MechanicsPracticalsScreen
import com.austin.sciencelab.ui.screens.physics.OpticsPracticalScreen
import com.austin.sciencelab.ui.screens.physics.ThermodynamicsPracticalScreen
import com.austin.sciencelab.ui.screens.physics.WavesPracticalScreen
import com.austin.sciencelab.ui.screens.qualitative.QualitativeScreen
import com.austin.sciencelab.ui.screens.quantitative.QuantitativeScreen
import com.austin.sciencelab.ui.screens.questions.UploadQuestions
import com.austin.sciencelab.ui.screens.questions.ViewQuestions
import com.austin.sciencelab.ui.screens.reactionrates.ReactionScreen
import com.austin.sciencelab.ui.screens.splash.SplashScreen
import com.austin.sciencelab.ui.screens.science1.Science1Screen
import com.austin.sciencelab.ui.screens.science2.Science2Screen
import com.austin.sciencelab.ui.screens.virtuallabs1.VirtualLabs1Screen
import com.austin.sciencelab.ui.screens.virtuallabs2.VirtualLabs2Screen


@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = ROUT_SPLASH,
    ) {

    val context= LocalContext.current

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(ROUT_HOME) {
            HomeScreen(navController)
        }

        composable(ROUT_ABOUT) {
            AboutScreen(navController)
        }

        composable(ROUT_SPLASH) {
            SplashScreen(navController)
        }

        composable(ROUT_SCIENCE1) {
            Science1Screen(navController)
        }

        composable(ROUT_SCIENCE2) {
            Science2Screen(navController)
        }

        composable(ROUT_VIRTUALLABS1) {
            VirtualLabs1Screen(navController)
        }

        composable(ROUT_VIRTUALLABS2) {
            VirtualLabs2Screen(navController)
        }

        composable(ROUT_VIRTUALLABS3) {
            BiologyLabsScreen(navController)
        }

        composable(ROUT_CELLBIO) {
            CellBiologyPracticalScreen(navController)
        }

        composable(ROUT_CELLBIOLOGY) {
            CellBiologyLabScreen(navController)
        }

        composable(ROUT_PRACTICAL) {
            MechanicsPracticalsScreen(navController)
        }






        composable(ROUT_CELLPHYSIOLOGY) {
            CellPhysiologyScreen(navController)
        }

        composable(ROUT_PLANTANATOMY) {
            PlantAnatomyScreen(navController)
        }

        composable(ROUT_SLIDES) {
            SlidePreparationScreen(navController)
        }

        composable(ROUT_UPLOADQUESTIONS) {
            UploadQuestions(navController)
        }


        composable(ROUT_VIEWQUESTIONS) {
            ViewQuestions(navController)
        }

        composable(ROUT_QUALITATIVE) {
           QualitativeScreen(navController)
        }

        composable(ROUT_QUANTITATIVE) {
            QuantitativeScreen(navController)
        }

        composable(ROUT_ORGANIC) {
            OrganicScreen(navController)
        }

        composable(ROUT_INORGANIC) {
            InorganicScreen(navController)
        }

        composable(ROUT_REACTION) {
            ReactionScreen(navController)
        }

        composable(ROUT_ENERGY) {
            EnergyChangesScreen(navController)
        }

        composable(ROUT_MECHANICS) {
           MechanicsPracticalScreen(navController)
        }

        composable(ROUT_PRACTICALS) {
            MechanicsPracticalsScreen(navController)
        }



        composable(ROUT_THERMODYNAMICS) {
            ThermodynamicsPracticalScreen(navController)
        }

        composable(ROUT_WAVES) {
            WavesPracticalScreen(navController)
        }

        composable(ROUT_OPTICS) {
            OpticsPracticalScreen(navController)
        }

        composable(ROUT_ELECTRICITYANDMAGNETISM) {
            ElectricityPracticalScreen(navController)
        }






        //AUTHENTICATION

        // Initialize Room Database and Repository for Authentication
        val appDatabase = UserDatabase.getDatabase(context)
        val authRepository = UserRepository(appDatabase.userDao())
        val authViewModel: AuthViewModel = AuthViewModel(authRepository)

        composable(ROUT_REGISTER) {
            RegisterScreen(authViewModel, navController) {
                navController.navigate(ROUT_LOGIN) {
                    popUpTo(ROUT_REGISTER) { inclusive = true }
                }
            }
        }

        composable(ROUT_LOGIN) {
            LoginScreen(authViewModel, navController) {
                navController.navigate(ROUT_HOME) {
                    popUpTo(ROUT_LOGIN) { inclusive = true }
                }
            }
        }
        // END OF AUTHENTICATION
    }
}