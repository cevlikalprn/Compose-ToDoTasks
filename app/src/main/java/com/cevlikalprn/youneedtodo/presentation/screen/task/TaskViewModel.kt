package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.lifecycle.ViewModel
import com.cevlikalprn.youneedtodo.common.extension.launchInIo
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.useCase.GetSelectedTaskUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getSelectedTaskUseCase: GetSelectedTaskUseCase
) : ViewModel() {

    private val _selectedTask: MutableStateFlow<TaskUiState> = MutableStateFlow(TaskUiState.Default)
    val selectedTask: StateFlow<TaskUiState> = _selectedTask

    fun getSelectedTask(taskId: Int) = launchInIo(
        launchBlock = {
            val toDoTask = getSelectedTaskUseCase(taskId)
            _selectedTask.update { uiState ->
                uiState.copy(
                    toDoTask = toDoTask
                )
            }
        },
        errorBlock = {
            _selectedTask.update { uiState ->
                uiState.copy(
                    toDoTask = ToDoTask.Default,
                    errorMessage = it.message.orEmpty()
                )
            }
        }
    )
}