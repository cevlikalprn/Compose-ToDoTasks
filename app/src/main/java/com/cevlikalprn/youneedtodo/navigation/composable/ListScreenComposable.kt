package com.cevlikalprn.youneedtodo.navigation.composable

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.cevlikalprn.youneedtodo.common.Constants.LIST_SCREEN
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreen
import com.cevlikalprn.youneedtodo.presentation.screen.list.ListScreen

fun NavGraphBuilder.listScreenComposable(
    navigateToTaskScreen: NavigateToTaskScreen
) {
    composable(
        route = LIST_SCREEN
    ) {
        ListScreen(
            navigateToTaskScreen = navigateToTaskScreen
        )
    }
}