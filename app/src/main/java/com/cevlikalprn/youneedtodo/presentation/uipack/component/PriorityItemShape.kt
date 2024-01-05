package com.cevlikalprn.youneedtodo.presentation.uipack.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.cevlikalprn.youneedtodo.presentation.theme.PRIORITY_ITEM_CIRCLE_SHAPE_SIZE

@Composable
fun PriorityItemShape(color: Color) {
    Canvas(
        modifier = Modifier.size(PRIORITY_ITEM_CIRCLE_SHAPE_SIZE),
        onDraw = {
            drawCircle(color = color)
        }
    )
}

@Composable
@Preview
private fun PriorityItemShapePreview() {
    PriorityItemShape(
        color = Color.Red
    )
}