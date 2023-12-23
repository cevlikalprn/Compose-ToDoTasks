package com.cevlikalprn.youneedtodo.presentation.uipack.topBar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarBackgroundColor
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor

@Composable
fun AppDefaultToolbar(
    title: String
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = MaterialTheme.colors.appTopBarContentColor
            )
        },
        backgroundColor = MaterialTheme.colors.appTopBarBackgroundColor
    )
}