package com.randev.toa.ui.components.button

import android.content.res.Configuration
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.compose.ui.tooling.preview.Preview
import com.randev.toa.ui.theme.TOATheme

/**
 * @author Raihan Arman
 * @date 25/09/22
 */

@Composable
fun TextButtonCustom(
    text: String,
    onCLick: () -> Unit
) {
    TextButton(onClick = onCLick) {
        Text(
            text = text.toUpperCase(Locale.current),
            style = MaterialTheme.typography.caption
        )
    }
}

@Preview(
    name = "Night Mode",
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
@Preview(
    name = "Day Mode",
    uiMode = Configuration.UI_MODE_NIGHT_NO
)
@Composable
fun TextButtonCustomPreview() {
    TOATheme {
        TextButtonCustom(
            text = "Done",
            onCLick = {}
        )
    }
}
