package com.example.currencyconversionapp.presentation.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.presentation.theme.ButtonColor
import com.example.currencyconversionapp.presentation.theme.White

@Composable()
fun CustomButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp) ,
        shape = RoundedCornerShape(20.dp),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            containerColor = ButtonColor,
        ),
        border = BorderStroke(
            color = Color.Transparent,
            width = 1.dp
        )
    ) {
        Text(
            text = text,
            fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color =White
            )
        )
    }
}
