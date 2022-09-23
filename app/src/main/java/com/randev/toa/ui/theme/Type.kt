
package com.randev.toa.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.randev.toa.R

private val UrbanistExtraBold = Font(R.font.urbanist_extrabold, FontWeight.ExtraBold)
private val UrbanistSemiBold = Font(R.font.urbanist_semibold, FontWeight.SemiBold)
private val UrbanistBold = Font(R.font.urbanist_bold, FontWeight.Bold)
private val UrbanistMedium = Font(R.font.urbanist_medium, FontWeight.Medium)
private val UrbanistLight = Font(R.font.urbanist_light, FontWeight.Light)
private val UrbanistRegular = Font(R.font.urbanist_regular, FontWeight.Normal)

private val UrbanistFamily = FontFamily(
    listOf(UrbanistBold, UrbanistExtraBold, UrbanistSemiBold, UrbanistMedium, UrbanistRegular, UrbanistLight)
)

val typography = Typography(
    defaultFontFamily = UrbanistFamily
)
