package com.cevlikalprn.youneedtodo.presentation.uipack.topBar

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarBackgroundColor
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor

@Composable
fun AppDefaultToolbar(
    title: String,
    titleColor: Color = MaterialTheme.colors.appTopBarContentColor,
    backgroundColor: Color = MaterialTheme.colors.appTopBarBackgroundColor
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = titleColor
            )
        },
        backgroundColor = backgroundColor
    )
}

@Composable
@Preview
fun AppDefaultToolbarPreview() {
    AppDefaultToolbar(title = "Toolbar Title")
}
