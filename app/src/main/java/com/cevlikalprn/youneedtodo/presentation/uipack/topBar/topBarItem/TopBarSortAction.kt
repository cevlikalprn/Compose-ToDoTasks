package com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.TopBarSortOnClick
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.presentation.theme.appTopBarContentColor
import com.cevlikalprn.youneedtodo.presentation.uipack.component.PriorityItemWithText

@Composable
fun TopBarSortAction(
    onSortClick: TopBarSortOnClick,
    iconTint: Color = MaterialTheme.colors.appTopBarContentColor
) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(
        onClick = { expanded = true }
    ) {
        Icon(
            painter = painterResource(id = R.drawable.ic_filter),
            contentDescription = EMPTY_STRING,
            tint = iconTint
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            TopBarDropDownMenuItem(
                onClick = { expanded = it },
                onSortClick = onSortClick,
                item = Priority.LOW
            )
            TopBarDropDownMenuItem(
                onClick = { expanded = it },
                onSortClick = onSortClick,
                item = Priority.HIGH
            )
            TopBarDropDownMenuItem(
                onClick = { expanded = it },
                onSortClick = onSortClick,
                item = Priority.NONE
            )
        }
    }
}

@Composable
private fun TopBarDropDownMenuItem(
    onClick: (expanded: Boolean) -> Unit,
    onSortClick: TopBarSortOnClick,
    item: Priority
) {
    DropdownMenuItem(
        onClick = {
            onClick(false)
            onSortClick(item)
        }
    ) {
        PriorityItemWithText(item = item)
    }
}

@Composable
@Preview
private fun TopBarSortActionPreview() {
    TopBarSortAction(
        onSortClick = {
            // no-op
        }
    )
}