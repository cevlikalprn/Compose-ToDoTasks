package com.cevlikalprn.youneedtodo.presentation.uipack.iconButton

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.SimpleComposableContent
import com.cevlikalprn.youneedtodo.common.SimpleOnClick
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor

@Composable
fun AppThreeDotIconButton(
    onThreeDotIconClick: SimpleOnClick,
    onIconAction: SimpleComposableContent,
    icon: ImageVector = Icons.Filled.MoreVert,
    tint: Color = MaterialTheme.colors.appTopBarContentColor
) {
    AppIconButton(
        onClick = onThreeDotIconClick,
        onIconAction = onIconAction,
        icon = icon,
        tint = tint
    )
}

@Composable
@Preview
private fun AppThreeDotIconButtonPreview() {
    AppThreeDotIconButton(
        onThreeDotIconClick = {
            // do nothing
        },
        onIconAction = {
            // do nothing
        }
    )
}