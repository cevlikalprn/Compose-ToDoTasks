package com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem

import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.TopBarSortOnClick
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.presentation.uipack.component.priorityItem.AppPriorityItemWithText
import com.cevlikalprn.youneedtodo.presentation.uipack.iconButton.AppTopBarIconButton

@Composable
fun TopBarSortAction(
    onSortClick: TopBarSortOnClick
) {
    var expanded by remember { mutableStateOf(false) }
    AppTopBarIconButton(
        onClick = { expanded = true },
        icon = painterResource(id = R.drawable.ic_filter),
        onIconAction = {
            ExpandableDropDown(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                onSortClick = { priority ->
                    expanded = false
                    onSortClick(priority)
                }
            )
        }
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
        AppPriorityItemWithText(item = item)
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