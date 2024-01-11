package com.cevlikalprn.youneedtodo.presentation.uipack.iconButton

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.SimpleComposableContent
import com.cevlikalprn.youneedtodo.common.SimpleOnClick
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor

@Composable
fun AppTopBarIconButton(
    onClick: SimpleOnClick,
    onIconAction: SimpleComposableContent? = null,
    icon: ImageVector,
    tint: Color = MaterialTheme.colors.appTopBarContentColor,
    contentDescription: String = EMPTY_STRING
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint
        )
        onIconAction?.invoke()
    }
}

@Composable
fun AppTopBarIconButton(
    onClick: SimpleOnClick,
    onIconAction: SimpleComposableContent? = null,
    icon: Painter,
    tint: Color = MaterialTheme.colors.appTopBarContentColor,
    contentDescription: String = EMPTY_STRING
) {
    IconButton(
        onClick = onClick
    ) {
        Icon(
            painter = icon,
            contentDescription = contentDescription,
            tint = tint
        )
        onIconAction?.invoke()
    }
}