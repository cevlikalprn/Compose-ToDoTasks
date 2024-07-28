package com.cevlikalprn.youneedtodo.data.repository

import com.cevlikalprn.youneedtodo.common.AppDispatchers
import com.cevlikalprn.youneedtodo.data.local.TodoDao
import com.cevlikalprn.youneedtodo.domain.model.ToDoTaskEntity
import com.cevlikalprn.youneedtodo.domain.repository.ToDoRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ToDoRepositoryImpl @Inject constructor(
    private val todoDao: TodoDao,
    private val externalScope: CoroutineScope,
    private val appDispatchers: AppDispatchers
) : ToDoRepository {

    override fun getAllTasks(): Flow<List<ToDoTaskEntity>?> {
        return todoDao.getAllTasks()
    }

    override fun getSelectedTask(taskId: Int): Flow<ToDoTaskEntity?> {
        return todoDao.getSelectedTask(taskId)
    }

    override fun getSortedByLowPriority(): Flow<List<ToDoTaskEntity>> {
        return todoDao.sortByLowPriority()
    }

    override fun getSortedByHighPriority(): Flow<List<ToDoTaskEntity>> {
        return todoDao.sortByHighPriority()
    }

    override suspend fun addTask(todoTaskEntity: ToDoTaskEntity) {
        externalScope.launch(appDispatchers.io) {
            todoDao.addTask(todoTaskEntity)
        }.join()
    }

    override suspend fun updateTask(todoTaskEntity: ToDoTaskEntity) {
        externalScope.launch(appDispatchers.io) {
            todoDao.updateTask(todoTaskEntity)
        }.join()
    }

    override suspend fun deleteTask(todoTaskEntity: ToDoTaskEntity) {
        externalScope.launch(appDispatchers.io) {
            todoDao.deleteTask(todoTaskEntity)
        }.join()
    }

    override suspend fun deleteAllTasks() {
        todoDao.deleteAllTasks()
    }

    override fun searchDatabase(searchQuery: String): Flow<List<ToDoTaskEntity>> {
        return todoDao.searchDatabase(searchQuery)
    }
}
