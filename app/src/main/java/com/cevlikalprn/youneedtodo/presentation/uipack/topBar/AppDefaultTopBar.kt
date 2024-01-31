package com.cevlikalprn.youneedtodo.presentation.uipack.topBar

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarBackgroundColor
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor

@Composable
fun AppDefaultTopBar(
    title: String,
    titleColor: Color = MaterialTheme.colors.appTopBarContentColor,
    titleMaxLines: Int = 1,
    titleOverflow: TextOverflow = TextOverflow.Ellipsis,
    backgroundColor: Color = MaterialTheme.colors.appTopBarBackgroundColor,
    navigationIcon: @Composable (() -> Unit)? = null,
    actions: @Composable RowScope.() -> Unit = {}
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = titleColor,
                maxLines = titleMaxLines,
                overflow = titleOverflow
            )
        },
        navigationIcon = navigationIcon,
        actions = actions,
        backgroundColor = backgroundColor
    )
}


@Composable
@Preview
private fun AppDefaultTopBarPreview() {
    AppDefaultTopBar(
        title = "Top bar title"
    )
}
