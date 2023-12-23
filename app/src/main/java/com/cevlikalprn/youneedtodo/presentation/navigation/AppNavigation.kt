package com.cevlikalprn.youneedtodo.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.cevlikalprn.youneedtodo.common.Constants.LIST_SCREEN
import com.cevlikalprn.youneedtodo.presentation.navigation.composable.listScreenComposable
import com.cevlikalprn.youneedtodo.presentation.navigation.composable.taskScreenComposable

@Composable
fun AppNavigation(
    navController: NavHostController
) {
    val navigationContainer = remember(navController) {
        NavigationContainer(navController = navController)
    }

    NavHost(
        navController = navController,
        startDestination = LIST_SCREEN
    ) {
        listScreenComposable(
            navigateToTaskScreen = navigationContainer.navigateToTaskScreen
        )
        taskScreenComposable(
            navigateToListScreen = navigationContainer.navigateToListScreen
        )
    }
}