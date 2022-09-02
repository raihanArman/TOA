package com.randev.toa.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults.buttonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.toa.ui.theme.ButtonShape

/**
 * @author Raihan Arman
 * @date 02/09/22
 */

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    color: Color = MaterialTheme.colors.primary

) {
    val buttonColors = buttonColors(
        backgroundColor = color
    )

    val height = 48.dp

    Button(
        onClick = onClick,
        colors = buttonColors,
        shape = ButtonShape,
        modifier = modifier
            .height(height)
            .fillMaxWidth()
    ) {
        Text(
            text = text
        )
    }
}

@Preview
@Composable
fun PreviewButton() {
    PrimaryButton(text = "Button", onClick = { /*TODO*/ })
}
