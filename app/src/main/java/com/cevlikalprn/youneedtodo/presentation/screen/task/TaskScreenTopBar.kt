package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.Action
import com.cevlikalprn.youneedtodo.common.NavigateToListScreen
import com.cevlikalprn.youneedtodo.presentation.uipack.iconButton.AppAddIconButton
import com.cevlikalprn.youneedtodo.presentation.uipack.iconButton.AppBackIconButton
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
            AppBackIconButton(
                onBackClicked = {
                    navigateToListScreen(Action.NO_ACTION)
                }
            )
        },
        actions = {
            AppAddIconButton(
                onAddIconClick = {
                    navigateToListScreen(Action.ADD)
                }
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



