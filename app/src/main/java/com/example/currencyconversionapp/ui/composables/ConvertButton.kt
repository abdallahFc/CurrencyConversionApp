package com.example.currencyconversionapp.ui.composables

import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.ui.theme.ButtonColor

@Composable()
fun CustomButton(text: String, onClick: Unit,) {
    OutlinedButton(
        modifier = Modifier
            .width(315.dp)
            .height(48.dp) ,
        shape = RoundedCornerShape(20.dp),
        onClick = {
                  onClick
        },
        colors = ButtonDefaults.buttonColors(
            ButtonColor
        ),
    ) {
        Text(
            text = text,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFFFFFFFF),
            )
        )
    }
}
