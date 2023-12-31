package com.example.currencyconversionapp.presentation.feature.comparison

import androidx.compose.foundation.gestures.detectTapGestures
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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.presentation.components.AmountField
import com.example.currencyconversionapp.presentation.components.ContentVisibility
import com.example.currencyconversionapp.presentation.components.ConvertedFiled
import com.example.currencyconversionapp.presentation.components.CustomButton
import com.example.currencyconversionapp.presentation.components.Loading
import com.example.currencyconversionapp.presentation.components.NetworkError
import com.example.currencyconversionapp.presentation.components.SpinnerComponent
import com.example.currencyconversionapp.presentation.theme.CurrencyConversionAppTheme


@Composable
fun ComparisonScreen(viewModel: ComparisonViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState()
    ComparisonContent(state, viewModel)

}

@Composable
fun ComparisonContent(
    state: CompareUiState,
    listener: CompareInteractionListener
) {
    val focusManager = LocalFocusManager.current
    Loading(state = state.isLoading || state.isLoadingList)
    NetworkError(state = state.isError, error = "Error with network")
    ContentVisibility(state = !state.isLoading && !state.isError && !state.isLoadingList) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp)
                .pointerInput(Unit) {
                    detectTapGestures(onTap = {
                        focusManager.clearFocus()
                    })
                },
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
                        text = state.amount.toString(),
                        onValueChange = {
                            listener.onAmountChanged(it)
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
                        state.currencies, state.baseCurrency.code
                    ) {
                        listener.onBaseCurrencyChanged(it)
                    }
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
                        state.currencies, state.targetOneCurrency.code
                    ) {
                        listener.onTargetOneCurrencyChanged(it)
                    }
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
                        state.currencies, state.targetTwoCurrency.code
                    ) {
                        listener.onTargetTwoCurrencyChanged(it)
                    }
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
                    text = state.convertedAmountOne
                )
                ConvertedFiled(
                    modifier = Modifier
                        .weight(1f)
                        .padding(start = 8.dp),
                    text = state.convertedAmountTwo
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            CustomButton(stringResource(id = R.string.compare)) {
                listener.onCompareClicked()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFav() {
    CurrencyConversionAppTheme {
        ComparisonScreen()
    }

}
