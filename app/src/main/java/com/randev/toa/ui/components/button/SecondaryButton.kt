package com.randev.toa.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ButtonDefaults.textButtonColors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import com.randev.toa.R
import com.randev.toa.ui.theme.ButtonShape
import com.randev.toa.ui.theme.TOATheme

/**
 * @author Raihan Arman
 * @date 02/09/22
 */

@Composable
fun SecondaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    contentColor: Color = MaterialTheme.colors.primary,
    enabled: Boolean = true
) {

    val buttonColor = textButtonColors(
        contentColor = contentColor
    )

    TextButton(
        onClick = onClick,
        shape = ButtonShape,
        modifier = modifier
            .height(dimensionResource(id = R.dimen.button_height))
            .fillMaxWidth(),
        colors = buttonColor,
        enabled = enabled
    ) {
        Text(
            text = text,
        )
    }
}

@Preview
@Composable
fun PreviewSecondaryButton() {
    TOATheme {
        Surface() {
            SecondaryButton(text = "Button", onClick = { /*TODO*/ })
        }
    }
}
