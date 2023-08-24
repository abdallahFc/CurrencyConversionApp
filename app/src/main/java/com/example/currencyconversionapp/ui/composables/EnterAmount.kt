package com.example.currencyconversionapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.currencyconversionapp.ui.theme.FieldColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EnterAmount(width: Dp, height: Dp) {
    var amount: String by remember {
        mutableStateOf("1")
    }
    var currencyAmount by remember {
        mutableStateOf("EGP")
    }
    OutlinedTextField(
        modifier = Modifier
            .height(height)
            .width(width)
            .background(color = FieldColor, shape = RoundedCornerShape(20.dp)),
        value = amount,
        onValueChange = { amount = it },
        placeholder = {
            Text(
                text = "$amount",
            )
        },
        shape = RoundedCornerShape(20.dp),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}