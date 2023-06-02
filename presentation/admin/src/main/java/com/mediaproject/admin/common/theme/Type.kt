package com.mediaproject.admin.common.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.mediaproject.admin.R

internal val robotoFamily = FontFamily(
    Font(R.font.roboto_black, FontWeight.Black),
    Font(R.font.roboto_black, FontWeight.Black, FontStyle.Italic),
    Font(R.font.roboto_bold, FontWeight.Bold),
    Font(R.font.roboto_bold, FontWeight.Bold, FontStyle.Italic),
    Font(R.font.roboto_light, FontWeight.Light),
    Font(R.font.roboto_light, FontWeight.Light, FontStyle.Italic),
    Font(R.font.roboto_thin, FontWeight.Thin),
    Font(R.font.roboto_thin, FontWeight.Thin, FontStyle.Italic),
    Font(R.font.roboto_medium, FontWeight.Medium),
    Font(R.font.roboto_medium, FontWeight.Medium, FontStyle.Italic),
    Font(R.font.roboto_regular, FontWeight.Normal),
    Font(R.font.roboto_italic, FontWeight.Normal, FontStyle.Italic),
)

internal val notoSansFamily = FontFamily(
    Font(R.font.notosans_kr_black, FontWeight.Black, FontStyle.Normal),
    Font(R.font.notosans_kr_bold, FontWeight.Bold, FontStyle.Normal),
    Font(R.font.notosans_kr_medium, FontWeight.Medium, FontStyle.Normal),
    Font(R.font.notosans_kr_regular, FontWeight.Normal, FontStyle.Normal),
    Font(R.font.notosans_kr_light, FontWeight.Light, FontStyle.Normal),
    Font(R.font.notosans_kr_thin, FontWeight.Thin, FontStyle.Normal),
)

internal val abhayaLibreFamily = FontFamily(
    Font(R.font.abhayalibre_regular, FontWeight.Normal),
)

object ReRollBagTypography {

    val title = TextStyle(
        fontFamily = notoSansFamily,
        fontWeight = FontWeight(400),
        fontStyle = FontStyle.Normal,
        fontSize = 28.sp,
        lineHeight = 41.sp
    )

    val subtitle = TextStyle(
        fontFamily = notoSansFamily,
        fontWeight = FontWeight(400),
        fontStyle = FontStyle.Normal,
        fontSize = 20.sp,
        lineHeight = 30.sp
    )

    val body = TextStyle(
        fontFamily = notoSansFamily,
        fontWeight = FontWeight(400),
        fontStyle = FontStyle.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )

    val title2 = TextStyle(
        fontFamily = notoSansFamily,
        fontWeight = FontWeight(400),
        fontStyle = FontStyle.Normal,
        fontSize = 13.sp,
        lineHeight = 19.sp
    )

    val title3 = TextStyle(
        fontFamily = notoSansFamily,
        fontWeight = FontWeight(400),
        fontStyle = FontStyle.Normal,
        fontSize = 10.sp,
        lineHeight = 15.sp
    )

}

val Typography = Typography(

//    bodyLarge = TextStyle(
//        fontFamily = FontFamily.Default,
//        fontWeight = FontWeight.Normal,
//        fontSize = 16.sp,
//        lineHeight = 24.sp,
//        letterSpacing = 0.5.sp
//    )
    /* Other default text styles to override
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 22.sp,
        lineHeight = 28.sp,
        letterSpacing = 0.sp
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        fontSize = 11.sp,
        lineHeight = 16.sp,
        letterSpacing = 0.5.sp
    )
    */
)

//object Typo {
//    val title = TextStyle(
//        fontWeight = noto
//    )
//}