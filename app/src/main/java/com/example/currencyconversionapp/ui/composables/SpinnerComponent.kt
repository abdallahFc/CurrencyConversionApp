package com.example.currencyconversionapp.ui.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.ui.theme.CurrencyNameColor
import com.example.currencyconversionapp.ui.theme.FieldColor
import com.example.currencyconversionapp.ui.theme.FieldShadowColor


private val currenciesList = listOf(
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
    "CNY - CHINESE YUAN",
    "EGP - EGYPTIAN POUND",
    "USD - US DOLLAR",
    "EUR - EURO",
    "AED - UAE DIRHAM",
    "SAR - SAUDI RIYAL",
    "JPY - JAPANESE YEN",
    "CNY - CHINESE YUAN"
)

/** The SpinnerComponent is a component where the users can select the currency they want to convert from,
 * it's a dropdown menu that have all the currencies and the user should choose one to convert it to another
 * currency.
 */
@Preview
@Composable
fun SpinnerComponent() {
    var isExpanded by remember { mutableStateOf(false) }
    var selectedCurrency by remember { mutableStateOf("EGP - EGYPTIAN POUND") }
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .border(
                width = 0.5.dp,
                color = FieldShadowColor,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .padding(0.5.dp)
            .width(302.dp)
            .height(48.dp)
            .background(color = FieldColor, shape = RoundedCornerShape(size = 10.dp))
    ) {


        Image(
            painter = painterResource(id = R.drawable.egypt_flag),
            contentDescription = "currency flag",
            contentScale = ContentScale.Fit,
            modifier = Modifier
                .padding(start = 16.dp)
                .width(28.dp)
                .height(20.dp)
        )
        Text(
            text = selectedCurrency,
            style = TextStyle(
                fontSize = 16.sp,
                /*fontFamily = FontFamily(Font(R.font.open sans)),*/
                fontWeight = FontWeight(400),
                color = CurrencyNameColor,
            ),
            modifier = Modifier
                .padding(start = 8.dp, end = 50.dp, top = 13.dp, bottom = 13.dp)
        )
        IconButton(
            onClick = { isExpanded = isExpanded.not() },
            modifier = Modifier
                .padding(end = 16.dp, top = 16.dp, bottom = 16.dp)
                .width(20.dp)
                .height(20.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.frame),
                contentDescription = "Show all currencies",
                modifier = Modifier
                    .padding(1.dp)
            )
        }

        DropdownMenu(
            expanded = isExpanded,
            modifier = Modifier
                .width(302.dp)
                .height(302.dp)
                .background(color = FieldColor),
            onDismissRequest = { isExpanded = isExpanded.not() }) {
            repeat(currenciesList.size) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = currenciesList[it],
                            style = TextStyle(
                                fontSize = 16.sp,
                                /*fontFamily = FontFamily(Font(R.font.open sans)),*/
                                fontWeight = FontWeight(400),
                                color = CurrencyNameColor,
                            )
                        )
                    }, onClick = {
                        selectedCurrency = currenciesList[it]
                        isExpanded = isExpanded.not()
                    }
                )
            }
        }
    }
}
