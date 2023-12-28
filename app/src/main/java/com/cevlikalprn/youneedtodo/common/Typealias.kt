package com.cevlikalprn.youneedtodo.common

import com.cevlikalprn.youneedtodo.domain.model.Priority

// General
typealias SimpleOnClick = () -> Unit

// Navigation
typealias NavigateToTaskScreen = (taskId: Int) -> Unit
typealias NavigateToListScreen = (action: Action) -> Unit

// Button
typealias FabOnClick = () -> Unit

// Top Bar
typealias TopBarSearchOnClick = () -> Unit
typealias TopBarSortOnClick = (priority: Priority) -> Unit
typealias TopBarDeleteOnClick = () -> Unit