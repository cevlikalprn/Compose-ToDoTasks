package com.cevlikalprn.youneedtodo.presentation.navigation.composable

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.cevlikalprn.youneedtodo.common.Constants.LIST_ARGUMENT_KEY
import com.cevlikalprn.youneedtodo.common.Constants.LIST_SCREEN
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreen
import com.cevlikalprn.youneedtodo.presentation.list.ListScreen

fun NavGraphBuilder.listScreenComposable(
    navigateToTaskScreen: NavigateToTaskScreen
) {
    composable(
        route = LIST_SCREEN,
        arguments = listOf(navArgument(LIST_ARGUMENT_KEY) {
            type = NavType.StringType
        })
    ) {
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}