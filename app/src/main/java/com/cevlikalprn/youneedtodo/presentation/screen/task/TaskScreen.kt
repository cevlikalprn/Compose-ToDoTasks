package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import com.cevlikalprn.youneedtodo.common.NavigateToListScreen

@Composable
fun TaskScreen(
    taskId: Int,
    navigateToListScreen: NavigateToListScreen
) {
    Scaffold(
        topBar = {
            TaskScreenTopBar(navigateToListScreen = navigateToListScreen)
        },
        content = { paddingValues ->
            paddingValues
        }
    )
}