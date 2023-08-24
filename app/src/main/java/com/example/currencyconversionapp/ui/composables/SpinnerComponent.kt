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
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.ui.theme.CurrencyNameColor
import com.example.currencyconversionapp.ui.theme.FieldColor
import com.example.currencyconversionapp.ui.theme.FieldShadowColor

/* This is a dummy list of some currencies to test the DropDownMenu */
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
@Composable
fun SpinnerComponent(width: Dp, height: Dp) {
    /* this is a mutable state variable to control the dropDown menu whether it's expanded or not
     */
    var isExpanded by remember { mutableStateOf(false) }

    /* this the selected currency that the user will select from the dropDown menu, it's mutableState so it recompose the component every time the user select another currency
     */
    var selectedCurrency by remember { mutableStateOf("EGP") }

    /* The container of the flag, currency name and the drop icon */
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .border(
                width = 0.5.dp,
                color = FieldShadowColor,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .padding(0.5.dp)
            .width(width)
            .height(height)
            .background(color = FieldColor, shape = RoundedCornerShape(size = 20.dp))
    ) {
        /* The flag of the currency */
        Image(
            painter = painterResource(id = R.drawable.egypt_flag),
            contentDescription = "currency flag",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(start = 16.dp)
                .width(25.dp)
                .height(18.dp)
        )

        /* The currency name */
        Text(
            text = selectedCurrency,
            style = TextStyle(
                fontSize = 14.sp,
                /*fontFamily = FontFamily(Font(R.font.open sans)),*/
                fontWeight = FontWeight(400),
                color = CurrencyNameColor,
            ),
            modifier = Modifier
                .padding(start = 8.dp, end = 50.dp, top = 13.dp, bottom = 13.dp)
        )

        /* The drop icon that shows list of all the currencies the user can choose from */
        IconButton(
            onClick = { isExpanded = isExpanded.not() },
            modifier = Modifier
                .padding(end = 16.dp, top = 16.dp, bottom = 16.dp)
                .width(16.dp)
                .height(16.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.drop_icon),
                contentDescription = "Show all currencies",
                modifier = Modifier
                    .padding(1.dp)
            )
        }

        /* The menu of all the currencies where the user can choose only one from it */
        DropdownMenu(
            expanded = isExpanded,
            modifier = Modifier
                .width(width)
                .height(302.dp)
                .background(color = FieldColor),
            onDismissRequest = { isExpanded = isExpanded.not() }) {
            repeat(currenciesList.size) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = currenciesList[it],
                            style = TextStyle(
                                fontSize = 14.sp,
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
