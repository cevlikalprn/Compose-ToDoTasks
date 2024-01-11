package com.cevlikalprn.youneedtodo.presentation.uipack.topBar.topBarItem

import androidx.compose.foundation.layout.padding
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.R
import com.cevlikalprn.youneedtodo.common.TopBarDeleteOnClick
import com.cevlikalprn.youneedtodo.presentation.theme.LARGE_PADDING
import com.cevlikalprn.youneedtodo.presentation.theme.Typography
import com.cevlikalprn.youneedtodo.presentation.uipack.iconButton.AppTopBarIconButton

@Composable
fun TopBarDeleteAction(
    onDeleteClick: TopBarDeleteOnClick
) {
    var expanded by remember { mutableStateOf(false) }
    AppTopBarIconButton(
        onClick = { expanded = true },
        icon = Icons.Filled.MoreVert,
        onIconAction = {
            ExpandableDropDown(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                onDeleteClick = {
                    expanded = false
                    onDeleteClick()
                }
            )
        }
    )
}

@Composable
private fun ExpandableDropDown(
    expanded: Boolean,
    onDismissRequest: () -> Unit,
    onDeleteClick: TopBarDeleteOnClick
) {
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = onDismissRequest
    ) {
        DropdownMenuItem(
            onClick = onDeleteClick
        ) {
            DeleteAllText()
        }
    }
}

@Composable
private fun DeleteAllText() {
    Text(
        modifier = Modifier.padding(start = LARGE_PADDING),
        text = stringResource(id = R.string.delete_all),
        style = Typography.subtitle2
    )
}

@Composable
@Preview
private fun TopBarDeleteActionPreview() {
    TopBarDeleteAction(
        onDeleteClick = {
            // do nothing
        }
    )
}