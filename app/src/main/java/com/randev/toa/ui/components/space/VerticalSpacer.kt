package com.randev.toa.ui.core

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp

/**
 * @author Raihan Arman
 * @date 10/09/22
 */

@Composable
fun VerticalSpacer(
    height: Dp
) {
    Spacer(modifier = Modifier.height(height))
}
