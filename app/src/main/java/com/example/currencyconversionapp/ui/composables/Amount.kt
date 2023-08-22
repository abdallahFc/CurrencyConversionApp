package com.example.currencyconversionapp.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Preview(showBackground = true)

@Composable
fun AmountField() {
    Column {


        var amount: String by remember {
            mutableStateOf("")
        }
        var currencyAmount by remember {
            mutableStateOf("Egp")
        }
        Text(text = "Amount")
        Spacer(modifier = Modifier.height(15.dp))
        TextField(value = amount, onValueChange = { amount = it },
            label = {
                Text(text = "1 $currencyAmount",
                    fontWeight = FontWeight.Bold
                )
            }
        )
    }
}