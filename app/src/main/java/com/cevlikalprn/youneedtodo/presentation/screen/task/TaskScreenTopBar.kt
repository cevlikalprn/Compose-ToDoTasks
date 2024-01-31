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
import com.cevlikalprn.youneedtodo.common.NavigateToListScreen
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.presentation.model.Action
import com.cevlikalprn.youneedtodo.presentation.uipack.iconButton.AppTopBarIconButton
import com.cevlikalprn.youneedtodo.presentation.uipack.topBar.AppDefaultTopBar

@Composable
fun TaskScreenTopBar(
    navigateToListScreen: NavigateToListScreen
) {
    TopBarForNewTask(
        navigateToListScreen = navigateToListScreen
    )
}

@Composable
private fun TopBarForNewTask(
    navigateToListScreen: NavigateToListScreen
) {
    AppDefaultTopBar(
        title = stringResource(R.string.task_screen_new_task_title),
        navigationIcon = {
            AppTopBarIconButton(
                onClick = { navigateToListScreen(Action.NO_ACTION) },
                icon = Icons.Filled.ArrowBack
            )
        },
        actions = {
            AppTopBarIconButton(
                onClick = { navigateToListScreen(Action.ADD) },
                icon = Icons.Filled.Check
            )
        }
    )
}

@Composable
private fun TopBarForCreatedTask(
    selectedTask: ToDoTask,
    navigateToListScreen: NavigateToListScreen
) {
    AppDefaultTopBar(
        title = selectedTask.title,
        navigationIcon = {
            AppTopBarIconButton(
                onClick = { navigateToListScreen(Action.NO_ACTION) },
                icon = Icons.Filled.Close
            )
        },
        actions = {
            AppTopBarIconButton(
                onClick = { navigateToListScreen(Action.DELETE) },
                icon = Icons.Filled.Delete
            )
            AppTopBarIconButton(
                onClick = { navigateToListScreen(Action.UPDATE) },
                icon = Icons.Filled.Check
            )
        }
    )
}

@Composable
@Preview
private fun TopBarForNewTaskPreview() {
    TopBarForNewTask(
        navigateToListScreen = {
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
        navigateToListScreen = {
            // do nothing
        }
    )
}



