package com.template.core.designsystem.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.template.core.designsystem.R

val pretendardFontFamily = FontFamily(
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_bold, FontWeight.Bold),
)

val boldStyle = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight(700),
    platformStyle = PlatformTextStyle(
        includeFontPadding = false
    )
)

val mediumStyle = TextStyle(
    fontFamily = pretendardFontFamily,
    fontWeight = FontWeight(500),
    platformStyle = PlatformTextStyle(
        includeFontPadding = false
    )
)

internal val typography = TemplateTypography()

/**
 * Template typography.
 */
@Immutable
data class TemplateTypography(
    // bold
    val b40: TextStyle = boldStyle.copy(fontSize = 40.sp),
    val b36: TextStyle = boldStyle.copy(fontSize = 36.sp),
    val b32: TextStyle = boldStyle.copy(fontSize = 32.sp),
    val b28: TextStyle = boldStyle.copy(fontSize = 28.sp),
    val b24: TextStyle = boldStyle.copy(fontSize = 24.sp),
    val b20: TextStyle = boldStyle.copy(fontSize = 20.sp),
    val b18: TextStyle = boldStyle.copy(fontSize = 18.sp),
    val b16: TextStyle = boldStyle.copy(fontSize = 16.sp),
    val b14: TextStyle = boldStyle.copy(fontSize = 14.sp),
    val b12: TextStyle = boldStyle.copy(fontSize = 12.sp),
    val b11: TextStyle = boldStyle.copy(fontSize = 11.sp),
    val b10: TextStyle = boldStyle.copy(fontSize = 10.sp),

    // medium
    val m40: TextStyle = mediumStyle.copy(fontSize = 40.sp),
    val m36: TextStyle = mediumStyle.copy(fontSize = 36.sp),
    val m32: TextStyle = mediumStyle.copy(fontSize = 32.sp),
    val m28: TextStyle = mediumStyle.copy(fontSize = 28.sp),
    val m24: TextStyle = mediumStyle.copy(fontSize = 24.sp),
    val m20: TextStyle = mediumStyle.copy(fontSize = 20.sp),
    val m18: TextStyle = mediumStyle.copy(fontSize = 18.sp),
    val m16: TextStyle = mediumStyle.copy(fontSize = 16.sp),
    val m15: TextStyle = mediumStyle.copy(fontSize = 15.sp),
    val m14: TextStyle = mediumStyle.copy(fontSize = 14.sp),
    val m12: TextStyle = mediumStyle.copy(fontSize = 12.sp),
    val m11: TextStyle = mediumStyle.copy(fontSize = 11.sp),
    val m10: TextStyle = mediumStyle.copy(fontSize = 10.sp),
)

val LocalTypography = staticCompositionLocalOf { typography }
