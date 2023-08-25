package com.example.currencyconversionapp.data.source.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Image_table")
data class Currency(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val code: String,
    val title: String,
    val flag: String,
)