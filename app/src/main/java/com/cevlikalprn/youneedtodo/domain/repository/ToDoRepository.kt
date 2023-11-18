package com.cevlikalprn.youneedtodo.domain.repository

import com.cevlikalprn.youneedtodo.domain.model.ToDoTask
import kotlinx.coroutines.flow.Flow

interface ToDoRepository {

    /*
     * Get all ToDoTask
     */
    fun getAllTasks(): Flow<List<ToDoTask>>

    /*
     * Get selected ToDoTask by taskId
     */
    fun getSelectedTask(taskId: Int): Flow<ToDoTask>

    /*
     * Get all ToDoTask sorted by low priority
     */
    fun getSortedByLowPriority(): Flow<List<ToDoTask>>

    /*
     * Get all ToDoTask sorted by high priority
     */
    fun getSortedByHighPriority(): Flow<List<ToDoTask>>

    /*
     * Add a ToDoTask
     */
    suspend fun addTask(todoTask: ToDoTask)

    /*
     * Update a ToDoTask
     */
    suspend fun updateTask(todoTask: ToDoTask)

    /*
     * Delete a ToDoTask
     */
    suspend fun deleteTask(todoTask: ToDoTask)

    /*
    * Delete all ToDoTask
    */
    suspend fun deleteAllTasks()

    /*
     * Get all searched ToDoTask
     */
    fun searchDatabase(searchQuery: String): Flow<List<ToDoTask>>
}
