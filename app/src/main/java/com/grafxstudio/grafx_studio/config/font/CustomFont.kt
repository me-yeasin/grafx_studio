package com.grafxstudio.grafx_studio.config.font

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import com.grafxstudio.grafx_studio.R

val montFamily = FontFamily(
    Font(R.font.mont_regular, weight = FontWeight.Normal),
    Font(R.font.mont_thin, weight = FontWeight.Thin),
    Font(R.font.mont_thin_italic, weight = FontWeight.Thin, style = FontStyle.Italic),
    Font(R.font.mont_semi_bold, weight = FontWeight.SemiBold),
    Font(R.font.mont_semi_bold_italic, weight = FontWeight.SemiBold, style = FontStyle.Italic),
    Font(R.font.mont_bold, weight = FontWeight.Bold),
    Font(R.font.mont_bold_italic, weight = FontWeight.Bold, style = FontStyle.Italic),
    Font(R.font.mont_extra_bold, weight = FontWeight.ExtraBold),
    Font(R.font.mont_extra_bold_italic, weight = FontWeight.ExtraBold, style = FontStyle.Italic),
    Font(R.font.mont_black, weight = FontWeight.Black),
    Font(R.font.mont_black_italic, weight = FontWeight.Black, style = FontStyle.Italic),
    Font(R.font.mont_light, weight = FontWeight.Light),
    Font(R.font.mont_light_italic, weight = FontWeight.Light, style = FontStyle.Italic),
    Font(R.font.mont_extra_light, weight = FontWeight.ExtraLight),
    Font(R.font.mont_extra_light_italic, weight = FontWeight.ExtraLight, style = FontStyle.Italic),
    Font(R.font.mont_medium, weight = FontWeight.Medium),
    Font(R.font.mont_medium_italic, weight = FontWeight.Medium, style = FontStyle.Italic),
    Font(R.font.mont_italic, style = FontStyle.Italic)
)