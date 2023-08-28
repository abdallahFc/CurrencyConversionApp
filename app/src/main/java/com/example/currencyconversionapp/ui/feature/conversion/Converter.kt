package com.example.currencyconversionapp.ui.feature.conversion

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.data.source.local.Currency
import com.example.currencyconversionapp.ui.composables.AmountField
import com.example.currencyconversionapp.ui.composables.ConvertedFiled
import com.example.currencyconversionapp.ui.composables.CustomButton
import com.example.currencyconversionapp.ui.composables.SpinnerComponent
import com.example.currencyconversionapp.ui.theme.CurrencyConversionAppTheme

@Composable
fun Converting(viewModel: ConverterViewModel = hiltViewModel()) {
    Column {
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
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                AmountField(
                    text = viewModel.fromCurrencyAmount.value,
                ) {
                    viewModel.fromCurrencyAmount.value = it
                }
            }
            Column(
                modifier = Modifier
                    .weight(1.5f)
                    .padding(start = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.from),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                SpinnerComponent(
                    Currency(
                        code = "EGP",
                        name = "Egyptian Pound",
                        flag = "https://cdn.britannica.com/85/185-004-1EA59040/Flag-Egypt.jpg"
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
                    .weight(1.5f)
                    .padding(end = 8.dp),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = stringResource(id = R.string.to),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                SpinnerComponent(
                    Currency(
                        code = "USD",
                        name = "US Dollar",
                        flag = "https://cdn.britannica.com/79/4479-050-6EF87027/flag-Stars-and-Stripes-May-1-1795.jpg"
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
                    text = stringResource(id = R.string.amount),
                    style = TextStyle(
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onPrimary,
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
                ConvertedFiled(
                    text = viewModel.toCurrencyAmount.value
                )
            }
        }
        Spacer(modifier = Modifier.height(20.dp))
        CustomButton(stringResource(id = R.string.convert), viewModel::convertButtonClickable)
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFavs() {
    CurrencyConversionAppTheme {
        Converting()
    }

}