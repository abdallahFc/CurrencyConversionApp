package com.example.currencyconversionapp.ui.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.ui.theme.FieldColor
import com.example.currencyconversionapp.ui.theme.FieldShadowColor

@Composable
fun AmountField(width: Dp, height: Dp) {
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
        textStyle = TextStyle(
            fontWeight = FontWeight(600),
            color = Color(0xFF000000),
            fontSize = 14.sp
        )
    )
}