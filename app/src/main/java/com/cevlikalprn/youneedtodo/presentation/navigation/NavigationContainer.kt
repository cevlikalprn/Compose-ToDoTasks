package com.cevlikalprn.youneedtodo.presentation.navigation

import androidx.navigation.NavHostController
import com.cevlikalprn.youneedtodo.common.Action
import com.cevlikalprn.youneedtodo.common.Constants.LIST_SCREEN

class NavigationContainer(navController: NavHostController) {
    val navigateToListScreen: (Action) -> Unit = { action ->
        navController.navigate(route = "list/${action.name}") {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }
    val navigateToTaskScreen: (Int) -> Unit = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}