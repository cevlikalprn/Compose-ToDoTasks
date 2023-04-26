package com.cevlikalprn.youneedtodo.data.repository

import com.cevlikalprn.youneedtodo.data.local.TodoDao
import com.cevlikalprn.youneedtodo.data.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) : ToDoRepository {

    override val getAllTasks: Flow<List<ToDoTask>> = todoDao.getAllTasks()

    override val sortByLowPriority: Flow<List<ToDoTask>> = todoDao.sortByLowPriority()

    override val sortByHighPriority: Flow<List<ToDoTask>> = todoDao.sortByHighPriority()

    override fun getSelectedTask(taskId: Int): Flow<ToDoTask> = todoDao.getSelectedTask(taskId)

    override suspend fun addTask(todoTask: ToDoTask) {
        todoDao.addTask(todoTask)
    }

    override suspend fun updateTask(todoTask: ToDoTask) {
        todoDao.updateTask(todoTask)
    }

    override suspend fun deleteTask(todoTask: ToDoTask) {
        todoDao.deleteTask(todoTask)
    }

    override suspend fun deleteAllTasks() = todoDao.deleteAllTasks()

    override fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>> =
        todoDao.searchDatabase(searchQuery)
}
