package com.randev.toa.feature.tasklist.ui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.randev.toa.ui.theme.TOATheme

/**
 * @author Raihan Arman
 * @date 25/09/22
 */

@Composable
fun TaskList(
//    tasks: List<Task>,
//    onRescheduleClicked: () -> Unit,
//    onDoneClicked: () -> Unit
) {
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
        TaskList(
//            tasks = emptyList(),
//            onDoneClicked = {},
//            onRescheduleClicked = {}
        )
    }
}
