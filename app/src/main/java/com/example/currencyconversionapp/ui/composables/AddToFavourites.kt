package com.example.currencyconversionapp.ui.composables


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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.currencyconversionapp.R
import com.example.currencyconversionapp.ui.theme.LineShadowColor

@Composable
fun AddToFavourites(
    currencyName: String,
    flag: String,
    isChecked: Boolean,
    onClickIconFavorite: () -> Unit
) {
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
                            fontWeight = FontWeight(400),
                            color = MaterialTheme.colorScheme.onPrimary
                        )
                    )
                    Text(
                        text = "CURRENCY",
                        style = TextStyle(
                            fontSize = 12.sp,
                            fontWeight = FontWeight(400),
                            color = Color(0xFFB8B8B8),
                        )
                    )
                }

            }

            IconButton(
                onClick = { onClickIconFavorite() },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(
                        id = if (isChecked) R.drawable.checked
                        else R.drawable.not_checked
                    ),
                    contentDescription = "Add to favourites",
                    tint = if (isChecked) Color(0xFF363636)
                    else Color(0xFFB8B8B8)
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
        "EGP",
        "https://cdn.britannica.com/85/185-004-1EA59040/Flag-Egypt.jpg",
        isChecked = true,
        onClickIconFavorite = {}
    )
}

