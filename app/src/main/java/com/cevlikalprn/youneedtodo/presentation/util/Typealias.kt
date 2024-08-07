package com.cevlikalprn.youneedtodo.presentation.util

import androidx.compose.runtime.Composable
import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.presentation.model.Action

// General
typealias SimpleOnClick = () -> Unit
typealias SimpleComposableContent = @Composable () -> Unit

// Navigation
typealias NavigateToTaskScreen = (taskId: Int) -> Unit
typealias NavigateToListScreen = () -> Unit

// Button
typealias FabOnClick = () -> Unit

// Top Bar
typealias TopBarSearchOnClick = () -> Unit
typealias TopBarSortOnClick = (priority: Priority) -> Unit
typealias TopBarDeleteOnClick = () -> Unit

// Search
typealias SearchOnTextChange = (text: String) -> Unit
typealias SearchOnCloseClick = () -> Unit
typealias SearchOnSearchClick = (text: String) -> Unit

// Priority Component
typealias PrioritySelectedClick = (priority: Priority) -> Unit

// TextField
typealias TextFieldValueChange = (value: String) -> Unit

// Listener
typealias ActionListener = (action: Action) -> Unit