package com.cevlikalprn.youneedtodo.presentation.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cevlikalprn.youneedtodo.common.Constants.TASK_ARGUMENT_KEY
import com.cevlikalprn.youneedtodo.common.Constants.TASK_SCREEN
import com.cevlikalprn.youneedtodo.common.NavigateToListScreenAction

fun NavGraphBuilder.taskComposable(
    navigateToListScreen: NavigateToListScreenAction
) {
    composable(
        route = TASK_SCREEN,
        arguments = listOf(navArgument(TASK_ARGUMENT_KEY) {
            type = NavType.IntType
        })
    ) {

    }
}