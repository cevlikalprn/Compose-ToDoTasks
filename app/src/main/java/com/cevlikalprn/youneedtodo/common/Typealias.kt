package com.cevlikalprn.youneedtodo.common

import com.cevlikalprn.youneedtodo.domain.model.Priority

// General
typealias SimpleOnClick = () -> Unit

// Navigation
typealias NavigateToTaskScreen = (taskId: Int) -> Unit
typealias NavigateToListScreen = (action: Action) -> Unit

// Button
typealias FabOnClick = () -> Unit

// Toolbar
typealias ToolbarSearchOnClick = () -> Unit
typealias ToolbarSortOnClick = (priority: Priority) -> Unit