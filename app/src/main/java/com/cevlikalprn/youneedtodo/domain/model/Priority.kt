package com.cevlikalprn.youneedtodo.domain.model

import androidx.compose.ui.graphics.Color
import com.cevlikalprn.youneedtodo.presentation.theme.HighPriorityColor
import com.cevlikalprn.youneedtodo.presentation.theme.LowPriorityColor
import com.cevlikalprn.youneedtodo.presentation.theme.MediumPriorityColor
import com.cevlikalprn.youneedtodo.presentation.theme.NonePriorityColor

enum class Priority(val color: Color) {
    HIGH(HighPriorityColor),
    MEDIUM(MediumPriorityColor),
    LOW(LowPriorityColor),
    NONE(NonePriorityColor)
}
