package com.randev.toa.feature.tasklist.ui

import android.content.res.Configuration
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.randev.toa.feature.tasklist.domain.model.Task
import com.randev.toa.ui.theme.TOATheme

/**
 * @author Raihan Arman
 * @date 28/09/22
 */

@Composable
fun TaskListContent(
    viewState: TaskListViewState,
    onRescheduleClicked: (Task) -> Unit,
    onDoneClicked: (Task) -> Unit,
    onAddButtonClicked: () -> Unit
) {
    if (viewState is TaskListViewState.Loaded) {
        LoadedTasksContents(
            viewState,
            onAddButtonClicked,
            onRescheduleClicked,
            onDoneClicked
        )
    }
}

@Composable
private fun LoadedTasksContents(
    viewState: TaskListViewState.Loaded,
    onAddButtonClicked: () -> Unit,
    onRescheduleClicked: (Task) -> Unit,
    onDoneClicked: (Task) -> Unit
) {
    Scaffold(
        floatingActionButton = {
            if (viewState is TaskListViewState.Loaded) {
                AddTaskButton(
                    onClick = onAddButtonClicked
                )
            }
        },
        topBar = {
            TaskListToolbar()
        }
    ) { paddingValues ->
        TaskList(
            tasks = viewState.tasks,
            onRescheduleClicked = onRescheduleClicked,
            onDoneClicked = onDoneClicked,
            modifier = Modifier
                .padding(paddingValues)
        )
    }
}

@Composable
private fun TaskListToolbar() {
    val toolbarHeight = 84.dp
    Surface(
        color = MaterialTheme.colors.primary,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .height(toolbarHeight)
        ) {
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    Icons.Default.KeyboardArrowLeft,
                    contentDescription = null
                )
            }
            Text(
                text = "TODAY",
                modifier = Modifier
                    .weight(1f),
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.h4,
                fontWeight = FontWeight.Bold
            )
            IconButton(
                onClick = { /*TODO*/ },
            ) {
                Icon(
                    Icons.Default.KeyboardArrowRight,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
private fun AddTaskButton(
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick
    ) {
        Icon(
            Icons.Default.Add,
            contentDescription = null
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
fun TaskListContentPreview() {
    val tasks = (1..10).map { index ->
        Task(
            description = "Test task"
        )
    }
    val viewState = TaskListViewState.Loaded(tasks = tasks)
    TOATheme {
        TaskListContent(
            viewState = viewState,
            onDoneClicked = {},
            onRescheduleClicked = {},
            onAddButtonClicked = {}
        )
    }
}
