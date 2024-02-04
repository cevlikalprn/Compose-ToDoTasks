package com.cevlikalprn.youneedtodo.navigation

import androidx.navigation.NavHostController
import com.cevlikalprn.youneedtodo.common.Constants.LIST_SCREEN
import com.cevlikalprn.youneedtodo.common.NavigateToListScreen
import com.cevlikalprn.youneedtodo.common.NavigateToTaskScreen

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