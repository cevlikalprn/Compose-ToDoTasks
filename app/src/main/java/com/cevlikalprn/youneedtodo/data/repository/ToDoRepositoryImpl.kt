package com.cevlikalprn.youneedtodo.data.repository

import com.cevlikalprn.youneedtodo.data.local.TodoDao
import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ViewModelScoped
class ToDoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao
) : ToDoRepository {

    override fun getAllTasks(): Flow<List<ToDoTask>> {
        return todoDao.getAllTasks()
    }

    override fun getSelectedTask(taskId: Int): ToDoTask? {
        return todoDao.getSelectedTask(taskId)
    }

    override fun getSortedByLowPriority(): Flow<List<ToDoTask>> {
        return todoDao.sortByLowPriority()
    }

    override fun getSortedByHighPriority(): Flow<List<ToDoTask>> {
        return todoDao.sortByHighPriority()
    }

    override suspend fun addTask(todoTask: ToDoTask) {
        todoDao.addTask(todoTask)
    }

    override suspend fun updateTask(todoTask: ToDoTask) {
        todoDao.updateTask(todoTask)
    }

    override suspend fun deleteTask(todoTask: ToDoTask) {
        todoDao.deleteTask(todoTask)
    }

    override suspend fun deleteAllTasks() {
        todoDao.deleteAllTasks()
    }

    override fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>> {
        return todoDao.searchDatabase(searchQuery)
    }
}
