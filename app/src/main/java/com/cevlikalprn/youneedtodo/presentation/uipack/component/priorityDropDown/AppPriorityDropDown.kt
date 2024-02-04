package com.cevlikalprn.youneedtodo.presentation.uipack.component.priorityDropDown

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.ContentAlpha
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.cevlikalprn.youneedtodo.common.Constants.EMPTY_STRING
import com.cevlikalprn.youneedtodo.common.PrioritySelectedClick
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.presentation.theme.PRIORITY_DROP_DOWN_HEIGHT
import com.cevlikalprn.youneedtodo.presentation.uipack.component.priorityItem.AppPriorityItemShape
import com.cevlikalprn.youneedtodo.presentation.uipack.component.priorityItem.AppPriorityItemWithText

@Composable
fun AppPriorityDropDown(
    priority: Priority,
    onPrioritySelected: PrioritySelectedClick
) {
    var expanded by remember { mutableStateOf(false) }
    val angle: Float by animateFloatAsState(
        targetValue = if (expanded) 180f else 0f,
        label = EMPTY_STRING
    )

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(MaterialTheme.colors.background)
            .height(PRIORITY_DROP_DOWN_HEIGHT)
            .clickable { expanded = true }
            .border(
                width = 1.dp,
                color = MaterialTheme.colors.onSurface.copy(
                    alpha = ContentAlpha.disabled
                ),
                shape = MaterialTheme.shapes.small
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AppPriorityItemShape(
            modifier = Modifier.weight(1f),
            color = priority.color
        )
        Text(
            modifier = Modifier
                .weight(weight = 8f),
            text = priority.name,
            style = MaterialTheme.typography.subtitle2
        )

        IconButton(
            modifier = Modifier
                .alpha(ContentAlpha.medium)
                .rotate(degrees = angle)
                .weight(weight = 1.5f),
            onClick = { expanded = true }
        ) {
            Icon(
                imageVector = Icons.Filled.ArrowDropDown,
                contentDescription = EMPTY_STRING
            )
        }
        PriorityDropDownMenu(
            expanded = expanded,
            onExpandedChange = { expanded = it },
            onPrioritySelected = onPrioritySelected
        )
    }
}

@Composable
fun PriorityDropDownMenu(
    expanded: Boolean,
    onExpandedChange: (expanded: Boolean) -> Unit,
    onPrioritySelected: PrioritySelectedClick
) {
    DropdownMenu(
        modifier = Modifier
            .fillMaxWidth(),
        expanded = expanded,
        onDismissRequest = { onExpandedChange(false) }
    ) {
        DropdownMenuItem(
            onClick = {
                onExpandedChange(false)
                onPrioritySelected(Priority.LOW)
            }
        ) {
            AppPriorityItemWithText(item = Priority.LOW)
        }
        DropdownMenuItem(
            onClick = {
                onExpandedChange(false)
                onPrioritySelected(Priority.MEDIUM)
            }
        ) {
            AppPriorityItemWithText(item = Priority.MEDIUM)
        }
        DropdownMenuItem(
            onClick = {
                onExpandedChange(false)
                onPrioritySelected(Priority.HIGH)
            }
        ) {
            AppPriorityItemWithText(item = Priority.HIGH)
        }
    }
}


@Composable
@Preview
private fun PriorityDropDownPreview() {
    AppPriorityDropDown(
        priority = Priority.LOW,
        onPrioritySelected = {
            // do nothing
        }
    )
}











