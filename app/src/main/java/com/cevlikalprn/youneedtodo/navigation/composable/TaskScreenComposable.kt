package com.cevlikalprn.youneedtodo.navigation.composable

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cevlikalprn.youneedtodo.presentation.util.NavigateToListScreen
import com.cevlikalprn.youneedtodo.navigation.util.Constants.TASK_ARGUMENT_KEY
import com.cevlikalprn.youneedtodo.navigation.util.Constants.TASK_SCREEN
import com.cevlikalprn.youneedtodo.presentation.screen.task.TaskScreen

fun NavGraphBuilder.taskScreenComposable(
    navigateToListScreen: NavigateToListScreen
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) { navBackStackEntry ->
        val taskId = navBackStackEntry.arguments?.getInt(TASK_ARGUMENT_KEY)
        taskId?.let { id ->
            TaskScreen(
                taskId = id,
                navigateToListScreen = navigateToListScreen
            )
        }
    }
}