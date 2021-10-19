package com.lkrfnr.cinephile.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.lkrfnr.cinephile.R
import com.lkrfnr.cinephile.ui.theme.secondMainColor

@Preview
@Composable
fun Greetings() {

    val name = "ilker"

    Box(
        modifier = Modifier
            .fillMaxWidth(1f)
            .padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 24.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(1f),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {

            // greetings with name
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start
            ) {

                Text(
                    text = "Hi, $name !",
                    fontFamily = FontFamily(Font(R.font.lobster_regular)),
                    fontSize = 24.sp,
                    color = Color.White
                )
                Text(
                    text = "Find your next movie",
                    fontFamily = FontFamily.SansSerif,
                    fontSize = 20.sp,
                    color = Color.White
                )
            }

            // profile icon
            Box(
                modifier = Modifier
                    .size(56.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .background(secondMainColor),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "${name[0]}".capitalize(Locale.current),
                    fontFamily = FontFamily.Default,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
            }
        }

    }

}