package com.cevlikalprn.youneedtodo.presentation.uipack.button

import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.SimpleOnClick

@Composable
fun AppFloatingActionButton(
    onClick: SimpleOnClick,
    iconImageVector: ImageVector,
    contentDescription: String = EMPTY_STRING,
    iconTint: Color = Color.White
) {
    FloatingActionButton(
        onClick = onClick
    ) {
        Icon(
            imageVector = iconImageVector,
            contentDescription = contentDescription,
            tint = iconTint
        )
    }
}

@Composable
@Preview
fun AppFloatingActionButtonPreview() {
    AppFloatingActionButton(
        onClick = {
            // no-op
        },
        iconImageVector = Icons.Filled.ArrowForward
    )
}