package com.cevlikalprn.youneedtodo.presentation.uipack.iconButton

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.SimpleComposableContent
import com.cevlikalprn.youneedtodo.common.SimpleOnClick

@Composable
fun AppIconButton(
    onClick: SimpleOnClick,
    onIconAction: SimpleComposableContent? = null,
    icon: ImageVector,
    tint: Color,
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