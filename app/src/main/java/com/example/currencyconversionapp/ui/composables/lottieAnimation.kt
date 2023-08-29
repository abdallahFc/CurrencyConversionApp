package com.example.currencyconversionapp.ui.composables

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.LottieComposition
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.currencyconversionapp.R

@Composable
fun LottieAnimations(
    composition: Int,
    speed: Float,
    isPlaying: Boolean = true,
    restartPlaying: Boolean = false,
    modifier: Modifier = Modifier
) {
    /*
    var isPlaying by remember {
        mutableStateOf(true)
    }
     */
    var speed by remember {
        mutableStateOf(speed)
    }
    val composition by rememberLottieComposition(
        LottieCompositionSpec.RawRes(composition)
    )

    val progress by animateLottieCompositionAsState(
        composition,
        iterations = LottieConstants.IterateForever,
        isPlaying = isPlaying,
        speed = speed,
        restartOnPlay = restartPlaying
    )
    LottieAnimation(composition, progress, modifier = modifier)
}