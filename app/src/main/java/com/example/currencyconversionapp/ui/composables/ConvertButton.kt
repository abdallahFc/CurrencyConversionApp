package com.example.currencyconversionapp.ui.composables

import android.icu.text.ListFormatter.Width
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.model.content.RectangleShape
import com.example.currencyconversionapp.ui.theme.Black
import com.example.currencyconversionapp.ui.theme.ButtonColor

@Preview(showBackground = true)

@Composable()
fun ConvertButton() {

        TextButton(
            onClick = { },
            colors = ButtonDefaults.buttonColors(
                ButtonColor), shape = RoundedCornerShape(3.dp),

        ) {
            Text(text = "Convert",
                fontSize = 15.sp,
                color = Color.White
            )
        }
    }
