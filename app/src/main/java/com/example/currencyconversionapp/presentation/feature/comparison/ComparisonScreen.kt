package com.example.currencyconversionapp.ui.feature.comparison

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.data.source.local.model.CurrencyEntity
import com.example.currencyconversionapp.presentation.components.AmountField
import com.example.currencyconversionapp.presentation.components.ConvertedFiled
import com.example.currencyconversionapp.presentation.components.CustomButton
import com.example.currencyconversionapp.presentation.components.SpinnerComponent
import com.example.currencyconversionapp.presentation.feature.comparison.ComparisonViewModel
import com.example.currencyconversionapp.presentation.feature.conversion.ConverterViewModel
import com.example.currencyconversionapp.presentation.theme.CurrencyConversionAppTheme


@Composable
fun ComparisonScreen(viewModel : ComparisonViewModel = hiltViewModel()) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.amount),
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                AmountField(
                    text = viewModel.fromCurrencyAmount.value,
                    onValueChange = {
                        viewModel.fromCurrencyAmount.value = it
                    }
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.from),
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                SpinnerComponent(
                    CurrencyEntity(
                        code = "EGP",
                        name = "Egyptian Pound",
                        flag = "https://cdn.britannica.com/85/185-004-1EA59040/Flag-Egypt.jpg",
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.targeted_currency),
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                SpinnerComponent(
                    CurrencyEntity(
                        code = "USD",
                        name = "US Dollar",
                        flag = "https://cdn.britannica.com/79/4479-050-6EF87027/flag-Stars-and-Stripes-May-1-1795.jpg",
                    )
                )
            }
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(R.string.targeted_currency),
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                SpinnerComponent(
                    CurrencyEntity(
                        code = "GBP",
                        name = "Sterling Pound",
                        flag = "https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Flag_of_the_United_Kingdom_%283-5%29.svg/1280px-Flag_of_the_United_Kingdom_%283-5%29.svg.png"
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.Top
        ) {
            ConvertedFiled(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp),
                text = viewModel.toCurrency1Amount.value
            )
            ConvertedFiled(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp),
                text = viewModel.toCurrency2Amount.value
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomButton(stringResource(id = R.string.compare), viewModel::onConvertClicked)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFav() {
    CurrencyConversionAppTheme {
        ComparisonScreen()
    }

}
