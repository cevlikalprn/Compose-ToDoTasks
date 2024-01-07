package com.cevlikalprn.youneedtodo.presentation.uipack.iconButton

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.SimpleOnClick
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor

@Composable
fun AppSearchIconButton(
    onSearchClick: SimpleOnClick,
    icon: ImageVector = Icons.Filled.Search,
    tint: Color = MaterialTheme.colors.appTopBarContentColor
) {
    AppIconButton(
        onClick = onSearchClick,
        icon = icon,
        tint = tint
    )
}

@Composable
@Preview
private fun AppSearchIconButtonPreview() {
    AppSearchIconButton(
        onSearchClick = {
            // do nothing
        }
    )
}