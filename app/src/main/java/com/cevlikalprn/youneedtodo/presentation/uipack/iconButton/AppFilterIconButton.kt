package com.cevlikalprn.youneedtodo.presentation.uipack.iconButton

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.SimpleComposableContent
import com.cevlikalprn.youneedtodo.common.SimpleOnClick
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor

@Composable
fun AppFilterIconButton(
    onFilterIconClick: SimpleOnClick,
    onIconAction: SimpleComposableContent,
    icon: Painter = painterResource(id = R.drawable.ic_filter),
    tint: Color = MaterialTheme.colors.appTopBarContentColor,
    contentDescription: String = EMPTY_STRING
) {
    IconButton(
        onClick = onFilterIconClick
    ) {
        Icon(
            painter = icon,
            contentDescription = contentDescription,
            tint = tint
        )
        onIconAction()
    }
}

@Composable
@Preview
private fun AppFilterIconButtonPreview() {
    AppFilterIconButton(
        onFilterIconClick = {
            // do nothing
        },
        onIconAction = {
            // do nothing
        }
    )
}