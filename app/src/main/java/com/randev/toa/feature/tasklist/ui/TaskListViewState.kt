package com.randev.toa.feature.tasklist.ui

import com.randev.toa.feature.UIText
import com.randev.toa.feature.tasklist.domain.model.Task

/**
 * @author Raihan Arman
 * @date 28/09/22
 */

sealed class TaskListViewState {
    object Loading : TaskListViewState()
    data class Loaded(
        val tasks: List<Task>
    ) : TaskListViewState()
    data class Error(
        val errorMessage: UIText
    ) : TaskListViewState()
}
