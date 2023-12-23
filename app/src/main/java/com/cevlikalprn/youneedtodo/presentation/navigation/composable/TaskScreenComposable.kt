package com.cevlikalprn.youneedtodo.presentation.navigation.composable

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cevlikalprn.youneedtodo.common.Constants.TASK_ARGUMENT_KEY
import com.cevlikalprn.youneedtodo.common.Constants.TASK_SCREEN
import com.cevlikalprn.youneedtodo.common.NavigateToListScreen

fun NavGraphBuilder.taskScreenComposable(
    navigateToListScreen: NavigateToListScreen
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}