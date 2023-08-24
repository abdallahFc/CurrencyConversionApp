package com.example.currencyconversionapp.ui.feature.Comparison

import androidx.compose.foundation.interaction.HoverInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.ui.composables.AmountField
import com.example.currencyconversionapp.ui.composables.CustomButton
import com.example.currencyconversionapp.ui.composables.EnterAmount
import com.example.currencyconversionapp.ui.composables.SpinnerComponent

@Preview(showBackground = true, device = Devices.PIXEL_3)
@Composable
fun ComparisonScreen() {
    Column(
        modifier = Modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Amount",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                EnterAmount(width = 152.dp, height =50.dp )
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "From",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                SpinnerComponent()
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Targeted currency",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = Color.Black,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                SpinnerComponent()
            }
            Column(
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "Targeted currency",
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = Color(0xFF000000),
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                SpinnerComponent()
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
              AmountField(width = 145.dp, height = 35.dp)
                AmountField(width = 145.dp, height =  35.dp,true)
        }
        Spacer(modifier = Modifier.height(38.dp))
        CustomButton("Compare")
    }
}