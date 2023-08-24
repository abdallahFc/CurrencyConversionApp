package com.example.currencyconversionapp.ui.feature.LiveExchange

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.ui.composables.CurrencyItem

@Composable
fun LiveExchange() {
    val currenciesList = listOf(
        "EGP - EGYPTIAN POUND",
        "USD",
        "USD - US DOLLAR",
        "EUR - EURO",
        "AED - UAE DIRHAM",
        "SAR - SAUDI RIYAL",
        "JPY - JAPANESE YEN",
        "CNY - CHINESE YUAN",
        "EGP - EGYPTIAN POUND",
        "USD - US DOLLAR",
        "EUR - EURO",
        "AED - UAE DIRHAM",
        "SAR - SAUDI RIYAL",
        "JPY - JAPANESE YEN",
        "CNY - CHINESE YUAN",
        "EGP - EGYPTIAN POUND",
        "USD - US DOLLAR",
        "EUR - EURO",
        "AED - UAE DIRHAM",
        "SAR - SAUDI RIYAL",
        "JPY - JAPANESE YEN",
        "CNY - CHINESE YUAN"
    )
    Column(
        horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .width(400.dp)
            .fillMaxHeight()
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "live exchange rates",
                style = TextStyle(
                    fontSize = 16.84.sp,
                    fontWeight = FontWeight(600),
                    color = Color(0xFF202020),
                )
            )
            /*Clickable button navigates to the favorite screen contains favorite currencies list*/

            OutlinedButton(
                onClick = {
                    /*Navigate to the favorite list selection screen*/
                },
                modifier = Modifier
                    .width(150.dp)
                    .height(35.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.AddCircle,
                    contentDescription = "Add",
                    tint = Color.Black
                )
                Spacer(modifier = Modifier.width(5.dp))
                Text(
                    text = stringResource(R.string.add_to_favorites),
                    style = TextStyle(
                        fontSize = 10.87.sp,
                        fontWeight = FontWeight(500),
                        color = Color(0xFF363636),
                    )
                )
            }
        }

        Text(
            text = stringResource(R.string.my_portfolio),
            style = TextStyle(
                fontSize = 18.sp,
                lineHeight = 24.sp,
                fontWeight = FontWeight(700),
                color = Color(0xFF121212),
            ),
            modifier = Modifier
                .padding(top = 20.dp)
                .padding(horizontal = 20.dp).padding(bottom = 10.dp)
        )
        CurrencyItem(currencyList = currenciesList)
    }
}