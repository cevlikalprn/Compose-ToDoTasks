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
        FilterIcon(tint = iconTint)
        ExpandableDropDown(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            onSortClick = { priority ->
                expanded = false
                onSortClick(priority)
            }
        )
    }
}

@Composable
private fun FilterIcon(tint: Color) {
    Icon(
        painter = painterResource(id = R.drawable.ic_filter),
        contentDescription = EMPTY_STRING,
        tint = tint
    )
}

@Composable
private fun ExpandableDropDown(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onSortClick: TopBarSortOnClick
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        TopBarDropDownMenuItem(
            onSortClick = onSortClick,
            item = Priority.LOW
        )
        TopBarDropDownMenuItem(
            onSortClick = onSortClick,
            item = Priority.HIGH
        )
        TopBarDropDownMenuItem(
            onSortClick = onSortClick,
            item = Priority.NONE
        )
    }
}

@Composable
private fun TopBarDropDownMenuItem(
    onSortClick: TopBarSortOnClick,
    item: Priority
) {
    DropdownMenuItem(
        onClick = {
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
            // do nothing
        }
    )
}