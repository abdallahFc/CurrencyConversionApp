package com.example.currencyconversionapp.ui.composables

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.ui.theme.ButtonColor
import com.example.currencyconversionapp.ui.theme.White

@Composable()
fun CustomButton(text: String, onClick: () -> Unit) {
    OutlinedButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
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
        Box (
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = text,
                fontFamily = FontFamily(Font(R.font.poppins_extrabold)),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontWeight = FontWeight(700),
                    color =White
                ),
                modifier = Modifier.align(Alignment.Center)
            )
            LottieAnimations(composition = R.raw.animation_llvjriol, speed = 1f,
                modifier = Modifier
                    .size(50.dp)
                    .align(Alignment.CenterEnd)
            )
        }
    }
}
