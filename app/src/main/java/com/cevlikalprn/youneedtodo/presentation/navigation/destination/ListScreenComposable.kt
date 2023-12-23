package com.cevlikalprn.youneedtodo.presentation.navigation.destination

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cevlikalprn.youneedtodo.common.Constants.LIST_ARGUMENT_KEY
import com.cevlikalprn.youneedtodo.common.Constants.LIST_SCREEN
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreenAction
import com.cevlikalprn.youneedtodo.presentation.list.ListScreen

fun NavGraphBuilder.listScreenComposable(
    navigateToTaskScreen: NavigateToTaskScreenAction
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigateToTaskScreenAction = navigateToTaskScreen
        )
    }
}