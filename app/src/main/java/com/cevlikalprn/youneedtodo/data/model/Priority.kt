package com.cevlikalprn.youneedtodo.data.model

import androidx.compose.ui.graphics.Color
import com.cevlikalprn.youneedtodo.ui.theme.HighPriorityColor
import com.cevlikalprn.youneedtodo.ui.theme.LowPriorityColor
import com.cevlikalprn.youneedtodo.ui.theme.MediumPriorityColor
import com.cevlikalprn.youneedtodo.ui.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}
