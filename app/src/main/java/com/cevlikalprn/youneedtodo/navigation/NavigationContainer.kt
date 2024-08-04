package com.cevlikalprn.youneedtodo.navigation

import androidx.navigation.NavHostController
import com.cevlikalprn.youneedtodo.presentation.util.NavigateToListScreen
import com.cevlikalprn.youneedtodo.presentation.util.NavigateToTaskScreen
import com.cevlikalprn.youneedtodo.navigation.util.Constants.LIST_SCREEN

class NavigationContainer(navController: NavHostController) {

    val navigateToListScreen: NavigateToListScreen = {
        navController.navigate(route = LIST_SCREEN) {
            popUpTo(LIST_SCREEN) { inclusive = true }
        }
    }

    val navigateToTaskScreen: NavigateToTaskScreen = { taskId ->
        navController.navigate(route = "task/$taskId")
    }
}