package com.austin.sciencelab.data

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.austin.sciencelab.model.Question
import androidx.room.*


interface QuestionDao {
    @Query("SELECT * FROM questions")
    fun getAllQuestions(): LiveData<List<Question>>

    @Insert
    suspend fun insertQuestion(question: Question)

    @Update
    suspend fun updateQuestion(question: Question)

    @Delete
    suspend fun deleteQuestion(question: Question)
}