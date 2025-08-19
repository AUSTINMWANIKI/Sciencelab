package com.austin.sciencelab.model

import androidx.room.PrimaryKey

data class Question(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: Double,
    val phone: String,
    val imagePath: String
)
