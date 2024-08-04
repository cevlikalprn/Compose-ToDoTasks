package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.presentation.util.ActionListener
import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.presentation.model.ToDoTask
import com.cevlikalprn.youneedtodo.navigation.util.Constants.ADD_TASK_ID
import com.cevlikalprn.youneedtodo.presentation.model.Action
import com.cevlikalprn.youneedtodo.presentation.uipack.iconButton.AppTopBarIconButton
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.AppDefaultTopBar

@Composable
fun TaskScreenTopBar(
    uiState: TaskUiState,
    onActionClicked: ActionListener
) {
    if (uiState.toDoTask != null && uiState.toDoTask.id != ADD_TASK_ID) {
        TopBarForCreatedTask(uiState.toDoTask, onActionClicked)
    } else {
        TopBarForNewTask(
            onActionClicked = onActionClicked
        )
    }
}

@Composable
private fun TopBarForNewTask(
    onActionClicked: ActionListener
) {
    AppDefaultTopBar(
        title = stringResource(R.string.task_screen_new_task_title),
        navigationIcon = {
            AppTopBarIconButton(
                onClick = { onActionClicked(Action.NO_ACTION) },
                icon = Icons.Filled.ArrowBack
            )
        },
        actions = {
            AppTopBarIconButton(
                onClick = { onActionClicked(Action.ADD) },
                icon = Icons.Filled.Check
            )
        }
    )
}

@Composable
private fun TopBarForCreatedTask(
    selectedTask: ToDoTask,
    onActionClicked: ActionListener
) {
    AppDefaultTopBar(
        title = selectedTask.title,
        navigationIcon = {
            AppTopBarIconButton(
                onClick = { onActionClicked(Action.NO_ACTION) },
                icon = Icons.Filled.Close
            )
        },
        actions = {
            AppTopBarIconButton(
                onClick = { onActionClicked(Action.DELETE) },
                icon = Icons.Filled.Delete
            )
            AppTopBarIconButton(
                onClick = {
                    onActionClicked(Action.UPDATE)
                },
                icon = Icons.Filled.Check
            )
        }
    )
}

@Composable
@Preview
private fun TopBarForNewTaskPreview() {
    TopBarForNewTask(
        onActionClicked = {
            // do nothing
        }
    )
}

@Composable
@Preview
private fun TopBarForCreatedTaskPreview() {
    TopBarForCreatedTask(
        selectedTask = ToDoTask(
            id = 0,
            title = "Created Task",
            description = "",
            priority = Priority.HIGH
        ),
        onActionClicked = {
            // do nothing
        }
    )
}



