package com.example.currencyconversionapp.presentation.feature.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.presentation.components.ModesDropDown
import com.example.currencyconversionapp.presentation.feature.conversion.ConverterScreen
import com.example.currencyconversionapp.presentation.theme.CurrencyConversionAppTheme
import com.example.currencyconversionapp.presentation.feature.comparison.ComparisonScreen
import com.example.currencyconversionapp.presentation.feature.home.combosable.CustomTabSample


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(viewModel: HomeViewModel = hiltViewModel()) {
    val pagerState = rememberPagerState(pageCount = { 2 }, initialPage = 0)
    val context = LocalContext.current
    var language by remember {
        mutableStateOf("en")
    }
    val focusManager = LocalFocusManager.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .pointerInput(Unit) {
                detectTapGestures(onTap = {
                    focusManager.clearFocus()
                })
            }
    ) {
        Box(Modifier.weight(0.3f)) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .paint(
                        painter = painterResource(id = R.drawable.background),
                        contentScale = ContentScale.Crop
                    )
                    .paint(
                        painter = painterResource(id = R.drawable.grad),
                        contentScale = ContentScale.Crop
                    )
                    .padding(start = 16.dp, end = 16.dp, top = 32.dp, bottom = 16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        modifier = Modifier,
                        style = TextStyle(
                            fontSize = 26.sp,
                            fontWeight = FontWeight(700),
                            color = Color.White,
                        )
                    )
                    ModesDropDown(
                        onLanguageChange = {
                            viewModel.onLanguageChange()
                        },
                        onModeChange = {
                            viewModel.onModeChange()
                        },
                        checked = viewModel.isDark()
                    )
                }
                Text(
                    text = stringResource(id = R.string.currency_convert),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 32.dp),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 22.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_bold)),
                        fontWeight = FontWeight(600),
                        color = Color.White,
                    )
                )
                Text(
                    text = stringResource(id = R.string.check_live_exchange_rates),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    textAlign = TextAlign.Center,
                    style = TextStyle(
                        fontSize = 12.sp,
                        fontFamily = FontFamily(Font(R.font.montserrat_regular)),
                        fontWeight = FontWeight(400),
                        color = Color.White,
                    )
                )
            }
            CustomTabSample(
                Modifier
                    .align(Alignment.BottomCenter)
                    .layout { measurable, constraints ->
                        val placeable = measurable.measure(constraints)
                        layout(placeable.width, placeable.height) {
                            placeable.place(0, placeable.height / 2)
                        }
                    }, pagerState
            )
        }
        CurrencyViewPager(Modifier.weight(0.7f), pagerState)
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CurrencyViewPager(modifier: Modifier, pagerState: PagerState) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            userScrollEnabled = false,
            modifier = modifier
                .fillMaxSize()
        ) { page ->
            when (page) {
                0 -> {
                    ConverterScreen()
                }

                1 -> {
                    ComparisonScreen()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewFavourites() {
    CurrencyConversionAppTheme {
        HomeScreen()
    }
}
