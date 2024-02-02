package com.cevlikalprn.youneedtodo.presentation.screen.list

import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity

data class ListUiState(
    var success: Boolean,
    var toDoTaskEntities: List<ToDoTaskEntity>
) {

    companion object {
        val Default = ListUiState(
            success = false,
            toDoTaskEntities = emptyList()
        )
    }
}
