package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.lifecycle.ViewModel
import com.cevlikalprn.youneedtodo.common.extension.launchInIo
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

    private val _selectedTask: MutableStateFlow<TaskUiState> = MutableStateFlow(TaskUiState())
    val selectedTask: StateFlow<TaskUiState> = _selectedTask

    fun getSelectedTask(taskId: Int) = launchInIo(
        launchBlock = {
            getSelectedTaskUseCase(taskId)?.let { toDoTask ->
                _selectedTask.update { uiState ->
                    uiState.copy(
                        success = true,
                        id = toDoTask.id,
                        title = toDoTask.title,
                        description = toDoTask.description
                    )
                }
            } ?: run {
                _selectedTask.update { uiState ->
                    uiState.copy(success = false)
                }
            }
        },
        errorBlock = {
            _selectedTask.update { uiState ->
                uiState.copy(success = false)
            }
        }
    )
}