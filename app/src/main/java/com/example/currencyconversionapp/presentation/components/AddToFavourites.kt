package com.example.currencyconversionapp.presentation.components


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.presentation.feature.favourites.FavouritesViewModel
import com.example.currencyconversionapp.presentation.theme.LineShadowColor

@Composable
fun AddToFavourites(
    currencyName: String,
    flag: String,
    code: String,
    onClickIconFavorite: (Boolean) -> Unit
) {
    val favViewModel: FavouritesViewModel = hiltViewModel()
    var checked by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = Unit) {
        val currency = favViewModel.getCurrencyByCode(code)
        checked = (currency != null)
    }
    Column {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Row {
                AsyncImage(
                    model = flag,
                    contentDescription = "flag Image",
                    placeholder = painterResource(id = R.drawable.placeholder),
                    error = painterResource(id = R.drawable.placeholder),
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(48.dp)
                        .clip(CircleShape)
                )
                Column(modifier = Modifier.padding(start = 16.dp)) {
                    Text(
                        modifier = Modifier.padding(bottom = 2.dp),
                        text = currencyName,
                        style = TextStyle(
                            fontSize = 14.sp,
                            fontFamily = FontFamily(Font(R.font.poppins_regular)),
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                    Text(
                        text = stringResource(id = R.string.currency),
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFB8B8B8),
                        )
                    )
                }

            }
            IconButton(
                onClick = {
                    checked = !checked
                    onClickIconFavorite(checked)
                },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (checked) R.drawable.checked
                        else R.drawable.not_checked
                    ),
                    contentDescription = "Add to favourites",
                    tint = if (checked) MaterialTheme.colorScheme.onPrimary
                    else MaterialTheme.colorScheme.secondary
                )
            }

        }
        Divider(
            modifier = Modifier
                .padding(top = 12.dp)
                .fillMaxWidth()
                .height(1.dp)
                .background(LineShadowColor)
        )
    }

}

@Preview(showBackground = true)
@Composable
fun PreviewFav() {
    AddToFavourites(
        "Egyptian Pound",
        "https://cdn.britannica.com/85/185-004-1EA59040/Flag-Egypt.jpg",
        "EGP",
        onClickIconFavorite = {}
    )
}

