package com.lkrfnr.cinephile.ui.movie.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import com.lkrfnr.cinephile.R

@Composable
fun ActionBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth(1f),
    ) {

        val iconSize: Dp = dimensionResource(id = R.dimen.action_icons_size)
        val movieDetailTitleStr: String = stringResource(id = R.string.movie_detail_title)

        Image(
            painter = painterResource(id = R.drawable.white_back_arrow),
            "search icon", Modifier.size(iconSize, iconSize)
        )

        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth(1f)
        ) {
            Text(
                movieDetailTitleStr,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif,
                color = Color.White,
            )
        }
    }
}