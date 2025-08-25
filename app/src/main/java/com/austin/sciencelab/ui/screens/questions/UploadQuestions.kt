package com.austin.sciencelab.ui.screens.questions

import android.app.Application
import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.*
import androidx.navigation.NavController
import androidx.room.*
import com.austin.sciencelab.navigation.ROUT_LOGIN
import com.austin.sciencelab.navigation.ROUT_UPLOADQUESTIONS
import com.austin.sciencelab.navigation.ROUT_VIEWQUESTIONS
import com.austin.sciencelab.navigation.ROUT_VIRTUALLABS2
import kotlinx.coroutines.launch

// --------------------- ROOM DATABASE ---------------------
@Entity(tableName = "questions")
data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val subject: String,
    val question: String
)

@Dao
interface QuestionDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertQuestion(question: Question)

    @Query("SELECT * FROM questions WHERE subject = :subject")
    fun getQuestionsBySubject(subject: String): LiveData<List<Question>>

    @Query("SELECT * FROM questions")
    fun getAllQuestions(): LiveData<List<Question>>
}

@Database(entities = [Question::class], version = 1)
abstract class QuestionDatabase : RoomDatabase() {
    abstract fun questionDao(): QuestionDao

    companion object {
        @Volatile private var INSTANCE: QuestionDatabase? = null

        fun getDatabase(context: Context): QuestionDatabase {
            return INSTANCE ?: synchronized(this) {
                Room.databaseBuilder(
                    context.applicationContext,
                    QuestionDatabase::class.java,
                    "question_db"
                ).build().also { INSTANCE = it }
            }
        }
    }
}

// --------------------- VIEWMODEL ---------------------
class QuestionViewModel(application: Application) : AndroidViewModel(application) {
    private val dao = QuestionDatabase.getDatabase(application).questionDao()

    fun insertQuestion(question: Question) {
        viewModelScope.launch {
            dao.insertQuestion(question)
        }
    }

    fun getQuestionsBySubject(subject: String): LiveData<List<Question>> {
        return dao.getQuestionsBySubject(subject)
    }

    fun getAllQuestions(): LiveData<List<Question>> {
        return dao.getAllQuestions()
    }
}

// --------------------- UPLOAD SCREEN ---------------------
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UploadQuestions(
    navController: NavController,
    viewModel: QuestionViewModel = androidx.lifecycle.viewmodel.compose.viewModel()
) {
    var subject by remember { mutableStateOf("Chemistry") }
    var questionText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Upload Questions", fontWeight = FontWeight.Bold) },
                navigationIcon = {
                    IconButton(
                        onClick = {navController.navigate(ROUT_LOGIN)},
                        colors = IconButtonDefaults.iconButtonColors(Color.White),

                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = "menu"
                        )
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF4CAF50),
                    titleContentColor = Color.White
                )
            )
        },
        bottomBar = { BottomNavigationBar(navController) }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Subject Dropdown
            var expanded by remember { mutableStateOf(false) }
            ExposedDropdownMenuBox(
                expanded = expanded,
                onExpandedChange = { expanded = !expanded }
            ) {
                TextField(
                    value = subject,
                    onValueChange = {},
                    readOnly = true,
                    label = { Text("Select Subject") },
                    modifier = Modifier
                        .menuAnchor()
                        .fillMaxWidth()
                )
                ExposedDropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    listOf("Chemistry", "Biology", "Physics").forEach {
                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                subject = it
                                expanded = false
                            }
                        )
                    }
                }
            }

            // Question Input
            OutlinedTextField(
                value = questionText,
                onValueChange = { questionText = it },
                label = { Text("Enter Question") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(
                onClick = {
                    if (questionText.isNotBlank()) {
                        viewModel.insertQuestion(
                            Question(subject = subject, question = questionText)
                        )
                        questionText = ""
                    }
                },
                modifier = Modifier.align(Alignment.End),
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF4CAF50))
            ) {
                Text("Save Question", color = Color.White)
            }
        }
    }
}

// --------------------- BOTTOM NAVIGATION ---------------------
@Composable
fun BottomNavigationBar(navController: NavController) {
    NavigationBar(containerColor = Color(0xFFEEEEEE)) {
        NavigationBarItem(
            icon = { Icon(Icons.Default.Add, contentDescription = "Upload") },
            label = { Text("Upload") },
            selected = false,
            onClick = { navController.navigate(ROUT_UPLOADQUESTIONS) }
        )
        NavigationBarItem(
            icon = { Icon(Icons.Default.List, contentDescription = "View") },
            label = { Text("View") },
            selected = false,
            onClick = { navController.navigate(ROUT_VIEWQUESTIONS) }
        )
    }
}
