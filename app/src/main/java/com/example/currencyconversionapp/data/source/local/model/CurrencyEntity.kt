package com.example.currencyconversionapp.data.source.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "CURRENCY_TABLE")
data class CurrencyEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val code: String,
    val name: String,
    val flag: String
)