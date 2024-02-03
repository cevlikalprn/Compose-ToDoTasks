package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.lifecycle.ViewModel
import com.cevlikalprn.youneedtodo.common.AppResult
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

    private val _selectedTask: MutableStateFlow<TaskUiState> = MutableStateFlow(TaskUiState.Default)
    val selectedTask: StateFlow<TaskUiState> = _selectedTask

    fun getSelectedTask(taskId: Int) = launchInIo {
        when (val toDoTask = getSelectedTaskUseCase(taskId)) {
            is AppResult.Success -> {
                _selectedTask.update { uiState ->
                    uiState.copy(toDoTask = toDoTask.data)
                }
            }

            is AppResult.Error -> {
                _selectedTask.update { uiState ->
                    uiState.copy(
                        errorMessage = toDoTask.error.message.orEmpty()
                    )
                }
            }
        }
    }
}