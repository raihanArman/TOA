package com.randev.toa.feature.tasklist.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.toa.R
import com.randev.toa.feature.tasklist.domain.model.Task
import com.randev.toa.ui.theme.TOATheme

/**
 * @author Raihan Arman
 * @date 25/09/22
 */

@Composable
fun TaskList(
    tasks: List<Task>,
    onRescheduleClicked: (Task) -> Unit,
    onDoneClicked: (Task) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        contentPadding = PaddingValues(dimensionResource(id = R.dimen.list_padding)),
        verticalArrangement = Arrangement.spacedBy(24.dp),
        modifier = modifier
    ) {
        items(tasks) { task ->
            TaskListItem(
                task = task,
                onRescheduleClicked = onRescheduleClicked,
                onDoneClicked = onDoneClicked
            )
        }
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
    val tasks = (1..10).map { index ->
        Task(
            description = "Test task"
        )
    }
    TOATheme {
        TaskList(
            tasks = tasks,
            onDoneClicked = {},
            onRescheduleClicked = {}
        )
    }
}
