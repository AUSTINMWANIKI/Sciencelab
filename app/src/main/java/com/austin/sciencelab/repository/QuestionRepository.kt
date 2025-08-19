package com.austin.sciencelab.repository

import android.content.Context
import com.austin.sciencelab.model.Question
import com.austin.sciencelab.ui.screens.questions.QuestionDao
import com.austin.sciencelab.ui.screens.questions.QuestionDatabase

class QuestionRepository(context: Context) {
    private val QuestionDao = QuestionDatabase.getDatabase(context).questionDao()

    suspend fun insertQuestion(question: Question) {
        QuestionDao.insertQuestion(question)
    }


}
