package com.example.currencyconversionapp.ui.composables

import android.icu.util.CurrencyAmount
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
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
fun AmountField(
    width: Dp,
    height: Dp,
    enable: Boolean,
    currencyAmount: MutableState<String>
    ) {
    OutlinedTextField(
        modifier = Modifier
            .height(height)
            .width(width)
            .background(color = FieldColor, shape = RoundedCornerShape(20.dp)),
        value = currencyAmount.value,
        onValueChange = { currencyAmount.value = it },
        shape = RoundedCornerShape(20.dp),
        enabled = enable,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )
}