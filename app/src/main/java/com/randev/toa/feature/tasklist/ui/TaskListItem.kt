package com.randev.toa.feature.tasklist.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.toa.R
import com.randev.toa.feature.tasklist.domain.model.Task
import com.randev.toa.ui.components.button.TextButtonCustom
import com.randev.toa.ui.theme.TOATheme

/**
 * @author Raihan Arman
 * @date 25/09/22
 */

@Composable
fun TaskListItem(
    task: Task,
    onRescheduleClicked: (Task) -> Unit = {},
    onDoneClicked: (Task) -> Unit = {}
) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.End
        ) {
            TaskText(
                task.description
            )
            ButtonRow(
                onRescheduleClicked = {
                    onRescheduleClicked(task)
                },
                onDoneClicked = {
                    onDoneClicked(task)
                }
            )
        }
    }
}

@Composable
private fun ButtonRow(
    onRescheduleClicked: () -> Unit,
    onDoneClicked: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        RescheduleButton(onRescheduleClicked)
        DoneButton(onDoneClicked)
    }
}

@Composable
private fun RescheduleButton(onRescheduleClicked: () -> Unit) {
    TextButtonCustom(
        text = stringResource(id = R.string.reschedule),
        onCLick = onRescheduleClicked
    )
}

@Composable
private fun DoneButton(onDoneClicked: () -> Unit) {
    TextButtonCustom(
        text = stringResource(id = R.string.done),
        onCLick = onDoneClicked
    )
}

@Composable
private fun TaskText(description: String) {
    Text(
        text = description,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    )
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
fun TaskListItemPreview() {
    val task = Task(
        description = "Clean my office space"
    )
    TOATheme {
        TaskListItem(task)
    }
}
