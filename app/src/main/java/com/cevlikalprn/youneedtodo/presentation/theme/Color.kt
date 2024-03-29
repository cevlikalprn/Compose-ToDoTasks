package com.cevlikalprn.youneedtodo.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val LightGray = Color(0xFFFCFCFC)
val MediumGray = Color(0xFF9C9C9C)
val DarkGray = Color(0xFF141414)

val HighPriorityColor = Color.Red
val MediumPriorityColor = Color.Yellow
val LowPriorityColor = Color.Green
val NonePriorityColor = Color.White

val Colors.appTopBarContentColor: Color
    @Composable get() = if (isSystemInDarkTheme()) LightGray else Color.White

val Colors.appTopBarBackgroundColor: Color
    @Composable get() = if (isSystemInDarkTheme()) Color.Black else Purple500

val Colors.appFabBackgroundColor: Color
    @Composable get() = if (isSystemInDarkTheme()) Purple700 else Teal200

val Colors.taskItemBackgroundColor: Color
    @Composable get() = if (isSystemInDarkTheme()) DarkGray else Color.White

val Colors.taskItemTextColor: Color
    @Composable get() = if (isSystemInDarkTheme()) LightGray else DarkGray
