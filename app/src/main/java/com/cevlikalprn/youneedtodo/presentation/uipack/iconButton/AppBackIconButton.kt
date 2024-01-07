package com.cevlikalprn.youneedtodo.presentation.uipack.iconButton

import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.BackIconOnClick
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor

@Composable
fun AppBackIconButton(
    onBackClicked: BackIconOnClick,
    icon: ImageVector = Icons.Filled.ArrowBack,
    tint: Color = MaterialTheme.colors.appTopBarContentColor
) {
    AppIconButton(
        onClick = onBackClicked,
        icon = icon,
        tint = tint
    )
}

@Composable
@Preview
private fun AppBackIconButtonPreview() {
    AppBackIconButton(
        onBackClicked = {
            // do nothing
        }
    )
}