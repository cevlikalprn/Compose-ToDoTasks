package com.cevlikalprn.youneedtodo.presentation.uipack.component.priorityItem

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.common.model.Priority
import com.cevlikalprn.youneedtodo.presentation.theme.LARGE_PADDING
import com.cevlikalprn.youneedtodo.presentation.theme.Typography

@Composable
fun AppPriorityItemWithText(item: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        AppPriorityItemShape(color = item.color)
        ItemText(name = item.name)
    }
}

@Composable
private fun ItemText(name: String) {
    Text(
        modifier = Modifier.padding(start = LARGE_PADDING),
        text = name,
        style = Typography.subtitle1,
        color = MaterialTheme.colors.onSurface
    )
}

@Composable
@Preview
private fun AppPriorityItemPreview() {
    AppPriorityItemWithText(item = Priority.LOW)
}