package com.cevlikalprn.youneedtodo.presentation.screen.task

import androidx.lifecycle.ViewModel
import com.cevlikalprn.youneedtodo.common.Constants.MAX_TASK_TITLE_LENGTH
import com.cevlikalprn.youneedtodo.common.extension.ioScope
import com.cevlikalprn.youneedtodo.domain.model.Priority
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.useCase.AddTaskUseCase
import com.cevlikalprn.youneedtodo.domain.useCase.DeleteTaskUseCase
import com.cevlikalprn.youneedtodo.domain.useCase.GetSelectedTaskUseCase
import com.cevlikalprn.youneedtodo.domain.useCase.UpdateTaskUseCase
import com.cevlikalprn.youneedtodo.presentation.model.Action
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val getSelectedTaskUseCase: GetSelectedTaskUseCase,
    private val addTaskUseCase: AddTaskUseCase,
    private val updateTaskUseCase: UpdateTaskUseCase,
    private val deleteTaskUseCase: DeleteTaskUseCase
) : ViewModel() {

    private val _selectedTask: MutableStateFlow<TaskUiState> = MutableStateFlow(TaskUiState.Default)
    val selectedTask: StateFlow<TaskUiState> = _selectedTask

    fun updateErrorMessage(message: String?) {
        _selectedTask.update { it.copy(errorMessage = message) }
    }

    fun getSelectedTask(taskId: Int) = ioScope {
        getSelectedTaskUseCase(taskId)
            .catch {
                updateErrorMessage(it.message)
            }
            .collect { toDoTask ->
                _selectedTask.update { uiState ->
                    uiState.copy(toDoTask = toDoTask)
                }
            }
    }

    private fun addTask(toDoTask: ToDoTask?) = ioScope {
        addTaskUseCase(toDoTask = toDoTask)
    }


    private fun updateTask(toDoTask: ToDoTask?) = ioScope {
        updateTaskUseCase(toDoTask)
    }

    private fun deleteTask(toDoTask: ToDoTask?) = ioScope {
        deleteTaskUseCase(toDoTask)
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

    fun isReadyForAction(action: Action): Boolean {
        val toDoTask = selectedTask.value.toDoTask
        return if (action == Action.UPDATE || action == Action.ADD) {
            !(toDoTask?.title.isNullOrEmpty() || toDoTask?.description.isNullOrEmpty())
        } else {
            true
        }
    }

    fun applyAction(action: Action) {
        val toDoTask = selectedTask.value.toDoTask
        when (action) {
            Action.ADD -> {
                addTask(toDoTask)
            }

            Action.UPDATE -> {
                updateTask(toDoTask)
            }

            Action.DELETE -> {
                deleteTask(toDoTask)
            }

            Action.NO_ACTION -> {
                // do nothing
            }
        }
    }
}