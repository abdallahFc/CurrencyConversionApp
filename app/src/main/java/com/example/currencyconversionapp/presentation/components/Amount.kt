package com.example.currencyconversionapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun AmountField(
    modifier: Modifier = Modifier,
    text: String = "",
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp),
        value = text,
        onValueChange = onValueChange,
        shape = RoundedCornerShape(20.dp),
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        colors= TextFieldDefaults.outlinedTextFieldColors(
            backgroundColor =MaterialTheme.colorScheme.surface,
            focusedBorderColor = MaterialTheme.colorScheme.secondary,
            unfocusedBorderColor = MaterialTheme.colorScheme.secondary,
            textColor=MaterialTheme.colorScheme.onPrimary,
        ),
    )
}

@Composable
fun ConvertedFiled(
    modifier: Modifier = Modifier,
    text: String = "",
){
    Text(
        text=text,
        modifier = modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(size = 20.dp))
            .border(width = 1.dp, color =MaterialTheme.colorScheme.secondary, shape = RoundedCornerShape(size = 20.dp))
            .background(MaterialTheme.colorScheme.surface)
            .padding(16.dp),
        color =MaterialTheme.colorScheme.onPrimary
    ,
    )

}