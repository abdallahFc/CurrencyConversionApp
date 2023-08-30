package com.example.currencyconversionapp.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeightIn
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity
import com.example.currencyconversionapp.presentation.feature.conversion.CurrencyUiModel


/* This is a dummy list of some currencies to test the DropDownMenu */
//data class Currency(val code: String, val name: String, val flag: String, var isSelected: Boolean)

val currenciesList = listOf(
    CurrencyEntity(
        code = "EGP",
        name = "Egyptian Pound",
        flag = "https://cdn.britannica.com/85/185-004-1EA59040/Flag-Egypt.jpg"
    ),
    CurrencyEntity(
        code = "USD",
        name = "US Dollar",
        flag = "https://cdn.britannica.com/79/4479-050-6EF87027/flag-Stars-and-Stripes-May-1-1795.jpg"
    ),
    CurrencyEntity(
        code = "EUR",
        name = "Euro",
        flag = "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b7/Flag_of_Europe.svg/2560px-Flag_of_Europe.svg.png"
    ),
    CurrencyEntity(
        code = "GBP",
        name = "Sterling Pound",
        flag = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_the_United_Kingdom_%283-5%29.svg/1280px-Flag_of_the_United_Kingdom_%283-5%29.svg.png"
    ),
    CurrencyEntity(
        code = "AED",
        name = "UAE Dirham",
        flag = "https://upload.wikimedia.org/wikipedia/commons/thumb/c/cb/Flag_of_the_United_Arab_Emirates.svg/1280px-Flag_of_the_United_Arab_Emirates.svg.png"
    ),
    CurrencyEntity(
        code = "JPY",
        name = "Japan Yen",
        flag = "https://upload.wikimedia.org/wikipedia/commons/thumb/9/9e/Flag_of_Japan.svg/1280px-Flag_of_Japan.svg.png"
    ),
    CurrencyEntity(
        code = "SAR",
        name = "Saudi Riyal",
        flag = "https://cdn.britannica.com/79/5779-004-DC479508/Flag-Saudi-Arabia.jpg"
    ),
    CurrencyEntity(
        code = "KWD",
        name = "Kuwait Dinar",
        flag = "https://cdn.britannica.com/70/5770-004-A99DD01D/Flag-Kuwait.jpg"
    ),
    CurrencyEntity(
        code = "BHD",
        name = "Bahrain Dinar",
        flag = "https://cdn.britannica.com/67/5767-004-E0FF7201/Flag-Bahrain.jpg"
    )
)


/** The SpinnerComponent is a component where the users can select the currency they want to convert from,
 * it's a dropdown menu that have all the currencies and the user should choose one to convert it to another
 * currency.
 */
@Composable
fun SpinnerComponent(
    currencies: List<CurrencyUiModel>,
    code: String,
    onCurrencySelected: (String) -> Unit
) {
    // this is a mutable state variable to control the dropDown menu whether it's expanded or not

    var isExpanded by remember { mutableStateOf(false) }

    // this the selected currency that the user will select from the dropDown menu, it's mutableState so it recompose the component every time the user select another currency
    val target = currencies.find { it.code == code }
    var selectedCurrencyCode by remember { mutableStateOf(target?.code ?: "") }
    var selectedCurrencyFlag by remember { mutableStateOf(target?.flagUrl ?: "") }

    var size by remember { mutableStateOf(IntSize.Zero) }


    // The container of the flag, currency name and the drop icon
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .border(
                width = 1.dp,
                color = MaterialTheme.colorScheme.secondary,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .padding(0.5.dp)
            .fillMaxWidth()
            .height(48.dp)
            .background(
                color = MaterialTheme.colorScheme.surface,
                shape = RoundedCornerShape(size = 20.dp)
            )
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = { isExpanded = isExpanded.not() }
            )
            .onSizeChanged {
                size = it
            }
    ) {
        // The flag of the currency
        AsyncImage(
            model = if (target?.code == "EGP") "https://cdn.britannica.com/85/185-004-1EA59040/Flag-Egypt.jpg"
            else if (target?.code == "SAR") "https://cdn.britannica.com/79/5779-004-DC479508/Flag-Saudi-Arabia.jpg"
            else target?.flagUrl ?: "",
            contentDescription = "currency flag",
            placeholder = painterResource(id = R.drawable.placeholder),
            error = painterResource(id = R.drawable.placeholder),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(start = 11.dp)
                .width(28.dp)
                .height(20.dp)
        )

        // The currency name
        Text(
            text = target?.code ?: "",
            style = TextStyle(
                fontSize = 16.sp,
                /*fontFamily = FontFamily(Font(R.font.open sans)),*/
                fontWeight = FontWeight(400),
                color = MaterialTheme.colorScheme.onPrimary,
            ),
            modifier = Modifier
                .weight(0.8f)
                .padding(start = 8.dp)
        )

        // The drop icon that shows list of all the currencies the user can choose from

        Image(
            painter = painterResource(id = R.drawable.drop_icon),
            contentDescription = "drop menu icon",
            modifier = Modifier
                .padding(end = 16.dp)
                .size(18.dp),
            colorFilter = ColorFilter.tint(color = MaterialTheme.colorScheme.onPrimary),
            contentScale = ContentScale.FillBounds
        )

        // The menu of all the currencies where the user can choose only one from it
        DropdownMenu(
            expanded = isExpanded,
            modifier = Modifier
                .then(
                    with(LocalDensity.current) {
                        Modifier.width(
                            (size.width - 80).toDp()
                        )
                    }
                )
                .requiredHeightIn(min = 50.dp, max = 200.dp)
                .background(color = MaterialTheme.colorScheme.surface),
            onDismissRequest = { isExpanded = false },
            offset = DpOffset(18.dp, 0.dp)
        ) {
            repeat(currencies.size) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = currencies[it].code,
                            style = TextStyle(
                                fontSize = 16.sp,
                                fontFamily = FontFamily(Font(R.font.poppins_regular)),
                                fontWeight = FontWeight(400),
                                color = MaterialTheme.colorScheme.onPrimary
                            )
                        )
                    },
                    leadingIcon = {
                        AsyncImage(
                            model = if (currencies[it].code == "EGP") "https://cdn.britannica.com/85/185-004-1EA59040/Flag-Egypt.jpg"
                            else if (currencies[it].code == "SAR") "https://cdn.britannica.com/79/5779-004-DC479508/Flag-Saudi-Arabia.jpg"
                            else currencies[it].flagUrl,
                            placeholder = painterResource(id = R.drawable.placeholder),
                            error = painterResource(id = R.drawable.placeholder),
                            contentDescription = "Currency Flag",
                            modifier = Modifier
                                .width(28.dp)
                                .height(20.dp),
                            contentScale = ContentScale.FillBounds
                        )
                    },
                    onClick = {
                        isExpanded = isExpanded.not()
                        selectedCurrencyCode = currencies[it].code
                        onCurrencySelected(currencies[it].code)
                        //selectedCurrencyFlag = currencies[it].flagUrl
                    },
                    modifier = Modifier.background(
                        if (currencies[it].code == selectedCurrencyCode) MaterialTheme.colorScheme.background
                        else MaterialTheme.colorScheme.surface
                    )
                )
            }
        }
    }
}


