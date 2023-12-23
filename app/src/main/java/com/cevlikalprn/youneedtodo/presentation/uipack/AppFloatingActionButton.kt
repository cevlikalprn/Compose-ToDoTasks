package com.cevlikalprn.youneedtodo.presentation.uipack

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.SimpleOnClick

@Composable
fun AppFloatingActionButton(
    onClick: SimpleOnClick,
    iconImageVector: ImageVector,
    iconTint: Color = Color.White,
) {
    FloatingActionButton(
        onClick = onClick
    ) {
        Icon(
            imageVector = iconImageVector,
            contentDescription = EMPTY_STRING,
            tint = iconTint
        )
    }
}