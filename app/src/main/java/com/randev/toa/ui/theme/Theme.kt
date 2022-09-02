package com.randev.toa.ui.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable

@Composable
fun TOATheme(content: @Composable () -> Unit) {
    val colors = lightColorPalatte

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
