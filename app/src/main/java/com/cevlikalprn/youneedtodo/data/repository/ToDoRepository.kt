package com.cevlikalprn.youneedtodo.data.repository

import com.cevlikalprn.youneedtodo.data.model.ToDoTask
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {

    val getAllTasks: Flow<List<ToDoTask>>

    val sortByLowPriority: Flow<List<ToDoTask>>

    val sortByHighPriority: Flow<List<ToDoTask>>

    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    suspend fun addTask(todoTask: ToDoTask)

    suspend fun updateTask(todoTask: ToDoTask)

    suspend fun deleteTask(todoTask: ToDoTask)

    suspend fun deleteAllTasks()

    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>
}
