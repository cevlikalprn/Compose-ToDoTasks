package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.lifecycle.ViewModel
import com.cevlikalprn.youneedtodo.common.Constants.MAX_TASK_TITLE_LENGTH
import com.cevlikalprn.youneedtodo.common.extension.launchInIo
import com.cevlikalprn.youneedtodo.common.extension.onError
import com.cevlikalprn.youneedtodo.common.extension.onSuccess
import com.cevlikalprn.youneedtodo.domain.model.Priority
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

    fun getSelectedTask(taskId: Int) = launchInIo {
        getSelectedTaskUseCase(taskId)
            .onSuccess { toDoTask ->
                _selectedTask.update { uiState ->
                    uiState.copy(toDoTask = toDoTask)
                }
            }
            .onError { error ->
                _selectedTask.update { uiState ->
                    uiState.copy(
                        errorMessage = error.message.orEmpty()
                    )
                }
            }
    }

    fun updateTaskTitle(title: String) {
        if (title.length > MAX_TASK_TITLE_LENGTH) {
            return
        }
        updateToDoTask(
            selectedTask.value.toDoTask?.copy(
                title = title
            )
        )
    }

    fun updateTaskDescription(description: String) {
        updateToDoTask(
            selectedTask.value.toDoTask?.copy(
                description = description
            )
        )
    }

    fun updateTaskPriority(priority: Priority) {
        updateToDoTask(
            selectedTask.value.toDoTask?.copy(
                priority = priority
            )
        )
    }

    private fun updateToDoTask(toDoTask: ToDoTask?) {
        _selectedTask.update { uiState ->
            uiState.copy(
                toDoTask = toDoTask
            )
        }
    }
}