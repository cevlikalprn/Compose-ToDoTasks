package com.cevlikalprn.youneedtodo.presentation.navigation

import androidx.navigation.NavHostController
import com.cevlikalprn.youneedtodo.common.Constants.LIST_SCREEN
import com.cevlikalprn.youneedtodo.common.NavigateToListScreen
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreen

class NavigationContainer(navController: NavHostController) {

    val navigateToListScreen: NavigateToListScreen = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val navigateToTaskScreen: NavigateToTaskScreen = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}