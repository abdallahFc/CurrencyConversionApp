package com.example.currencyconversionapp.ui.composables


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.currencyconversionapp.R

@Composable
fun AddToFavourites(currencyTitle: String, flag: Int) {
    var isChecked by remember { mutableStateOf(false) }
    Row(
        verticalAlignment = Alignment.Top,
        horizontalArrangement = Arrangement.Start,
        modifier = Modifier
            .width(315.dp)
            .padding(vertical = 15.14.dp)
    ) {
        Image(
            painter = painterResource(id = flag),
            contentDescription = "flag Image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(0.08948.dp)
                .width(42.38532.dp)
                .height(42.38532.dp)
                .clip(CircleShape)
        )
        Column(modifier = Modifier.padding(horizontal = 15.41.dp)) {
            Text(
                text = currencyTitle, style = TextStyle(
                    fontSize = 13.49.sp,
                    lineHeight = 23.12.sp,
                    /*fontFamily = FontFamily(Font(R.font.montserrat)),*/
                    fontWeight = FontWeight(400),
                    color = Color(0xFF121212),
                )
            )
            Text(
                text = "CURRENCY",
                style = TextStyle(
                    fontSize = 11.56.sp,
                    lineHeight = 19.27.sp,
                    /*fontFamily = FontFamily(Font(R.font.montserrat)),*/
                    fontWeight = FontWeight(400),
                    color = Color(0xFFB8B8B8),
                )
            )
        }

        IconButton(
            onClick = { isChecked = isChecked.not() },
            modifier = Modifier.padding(start = 160.dp)
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
}
