package com.cevlikalprn.youneedtodo.presentation.uipack.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.presentation.theme.LARGE_PADDING
import com.cevlikalprn.youneedtodo.presentation.theme.PRIORITY_ITEM_CIRCLE_SHAPE_SIZE
import com.cevlikalprn.youneedtodo.presentation.theme.Typography

@Composable
fun PriorityItem(item: Priority) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Canvas(
            modifier = Modifier.size(PRIORITY_ITEM_CIRCLE_SHAPE_SIZE),
            onDraw = {
                drawCircle(color = item.color)
            }
        )
        Text(
            modifier = Modifier.padding(start = LARGE_PADDING),
            text = item.name,
            style = Typography.subtitle1,
            color = MaterialTheme.colors.onSurface
        )
    }
}

@Composable
@Preview
private fun PriorityItemPreview() {
    PriorityItem(item = Priority.LOW)
}