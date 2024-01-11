package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.NavigateToListScreen
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
private fun TopBarForCreatedTask() {

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



