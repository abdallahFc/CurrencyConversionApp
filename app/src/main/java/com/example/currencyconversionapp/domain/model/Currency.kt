package com.example.currencyconversionapp.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CURRENCY_TABLE")
data class Currency(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val code: String,
    val name: String,
    val flag: String
)