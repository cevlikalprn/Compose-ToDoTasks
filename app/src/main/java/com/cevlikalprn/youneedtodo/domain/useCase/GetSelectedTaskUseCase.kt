package com.cevlikalprn.youneedtodo.domain.useCase

import com.cevlikalprn.youneedtodo.common.AppResult
import com.cevlikalprn.youneedtodo.common.Constants.ADD_TASK_ID
import com.cevlikalprn.youneedtodo.data.mapper.TaskMapper
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import javax.inject.Inject

class GetSelectedTaskUseCase @Inject constructor(
    private val toDoRepository: ToDoRepository,
    private val taskMapper: TaskMapper
) {

    suspend operator fun invoke(taskId: Int): AppResult<ToDoTask> {
        if (taskId == ADD_TASK_ID) {
            return AppResult.Success(ToDoTask.NewToDoTask)
        }
        return when (val selectedTask = toDoRepository.getSelectedTask(taskId)) {
            is AppResult.Success -> {
                selectedTask.data?.let { toDoTaskEntity ->
                    AppResult.Success(
                        data = taskMapper(toDoTaskEntity)
                    )
                } ?: run {
                    AppResult.Success(ToDoTask.NewToDoTask)
                }
            }

            is AppResult.Error -> {
                selectedTask
            }
        }
    }
}